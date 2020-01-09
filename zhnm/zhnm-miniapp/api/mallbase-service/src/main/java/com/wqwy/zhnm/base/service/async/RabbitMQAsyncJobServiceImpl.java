package com.wqwy.zhnm.base.service.async;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.wqwy.zhnm.base.component.component.BalanceOfflineOrderNotifyToMQComponent;
import com.wqwy.zhnm.base.component.component.JsonResponseForMQ;
import com.wqwy.zhnm.base.component.component.SellerGoodsComponent;
import com.wqwy.zhnm.base.component.component.ShopOrderPrintComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.response.SellerDetailResponse;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.component.utils.MQResultUtils;
import com.wqwy.zhnm.base.entity.Balance;
import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.service.SellerBalanceService;
import com.wqwy.zhnm.base.service.ShopOrderDetailServiceImpl;
import com.wqwy.zhnm.base.service.base.RedisService;

import net.sf.json.JSONArray;

/**
 * 
 * @ClassName: RabbitMQAsyncJobServiceImpl  
 * @Description: TODO 重构 
 * @author seven  
 *
 */
@Component
public class RabbitMQAsyncJobServiceImpl implements RabbitMQAsyncJobService {

	@Autowired
	private RabbitAdmin rabbitAdmin;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	@Qualifier("sellerTopicExchange")
	private TopicExchange sellerTopicExchange;

	@Autowired
	@Qualifier("balanceTopicExchange")
	private TopicExchange balanceTopicExchange;
	
	@Autowired
	@Qualifier("delivererTopicExchange")
	private TopicExchange delivererTopicExchange;
	
	@Autowired
	private SellerBalanceService sellerBalanceService;
	
	@Autowired(required=false)
	private RedisService redisService;

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQAsyncJobServiceImpl.class);

	@Override
	//@Async
	public Future<String> doSendOrderGoodsMessageToMQSellerQueue(ShopOrderDTO shopOrder, List<ShopOrderDetailDTO> shopOrderDetailDTOList) {
//		shopOrderDetailDTOList = shopOrder.getShopOrderDetailList();
		Assert.notEmpty(shopOrderDetailDTOList, "shopOrderDetailDTOList not empty");
		shopOrderDetailDTOList.stream().collect(Collectors.groupingBy(ShopOrderDetailDTO::getPreSellerId))
				.forEach((key, value) -> {
//					shopOrder.setShopOrderDetailList(value.stream().map(v -> {
//						ShopOrderDetail sod = new ShopOrderDetail();
//						BeanUtils.copyProperties(v, sod);
//						return sod;
//					}).collect(Collectors.toList()));
					logger.info("doSendOrderGoodsMessageToMQSellerQueue-->key:"+key);
					logger.info("doSendOrderGoodsMessageToMQSellerQueue-->value:"+JSONArray.fromObject(value));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
					shopOrder.setPushTime(System.currentTimeMillis());
					shopOrder.setOrderTotal(new BigDecimal(value.stream().mapToDouble(s -> s.getPayTotal().doubleValue()).sum()).setScale(DefaultConstants.BIGDECIMAL_SHOW_DIGIT, BigDecimal.ROUND_HALF_UP));
					shopOrder.setShopOrderDetailDTOList(value);
					doSendMessageToSellerQueue(key, new JsonResponseForMQ<>(MQResultUtils.MQ_PREEMPT_SHOP_ORDER_GOODS, MQResultUtils.MQ_PREEMPT_SHOP_ORDER_GOODS_MSG, shopOrder));
					if (redisService != null)
						redisService.addPreemptOrderToSellerList(key, JsonUtils.AsJsonString(shopOrder));
				});
		return new AsyncResult<>("doSendOrderGoodsMessageToMQSellerQueue accomplished!");
	}
	
	@Override
//	@Async
	public Future<String> doSendOrderGoodsPrepareMessageToMQSellerQueue(ShopOrderDTO shopOrder, List<ShopOrderDetail> shopOrderDetailList) {
		Assert.notEmpty(shopOrderDetailList, "shopOrderDetailList not empty");
		shopOrderDetailList.stream().collect(Collectors.groupingBy(ShopOrderDetail::getSellerId))
				.forEach((key, value) -> {
					shopOrder.setShopOrderDetailList(value);
					doSendMessageToSellerQueue(key, new JsonResponseForMQ<>(MQResultUtils.MQ_PREPARE_SHOP_ORDER_GOODS, MQResultUtils.MQ_PREPARE_SHOP_ORDER_GOODS_MSG, shopOrder));
					
					// for print tickets
					SellerBalance sb = new SellerBalance();
					sb.setSellerId(key);
					List<SellerBalance> sbList = sellerBalanceService.findList(sb);
					if (sbList!=null && !sbList.isEmpty()) {
						doSendMessageToBalanceQueue(sbList.get(0).getBalanceId(), new JsonResponseForMQ<>(MQResultUtils.MQ_PREPARE_SHOP_ORDER_GOODS, MQResultUtils.MQ_PREPARE_SHOP_ORDER_GOODS_MSG, shopOrder));
					}
				});
		return new AsyncResult<>("doSendOrderGoodsPrepareMessageToMQSellerQueue accomplished!");
	}
	
	@Override
//	@Async
	public Future<String> doSendOrderMessageToMQDelivererQueue(ShopOrder... shopOrders) {
		List<ShopOrder> soList = Arrays.asList(shopOrders);
		soList.stream().collect(Collectors.groupingBy(ShopOrder::getDelivererId))
				.forEach((key, value) -> {
					doSendMessageToDelivererQueue(key, new JsonResponseForMQ<>(MQResultUtils.MQ_DELIVERY_SHOP_ORDER, MQResultUtils.MQ_DELIVERY_SHOP_ORDER_MSG, value));
				});
		return new AsyncResult<>("doSendOrderMessageToMQDelivererQueue accomplished!");
	}

	@Override
	// @Async
	public Future<String> doSendRegisterOrLoginMessage(SellerDetailResponse sellerDetailResponse) {
//		Seller seller = sellerDetailResponse.getSeller();
		Balance balance = sellerDetailResponse.getBalance();
		Queue sellerLoginQueue = new Queue(
				DefaultConstants.BalanceQueuePrefix + DefaultConstants.QueueSpliter + balance.getId(),
				true, false, false, DefaultConstants.BalanceQRLoginArgsMap);

		rabbitAdmin.deleteQueue(sellerLoginQueue.getName());
		rabbitAdmin.declareQueue(sellerLoginQueue);
		rabbitAdmin.declareBinding(BindingBuilder.bind(sellerLoginQueue).to(balanceTopicExchange)
				.with(DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + balance.getId()));
		rabbitTemplate.convertAndSend(balanceTopicExchange.getName(),
				DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + balance.getId(),
				JsonUtils.AsJsonString(new JsonResponseForMQ<>(MQResultUtils.SELLER_BALANCE_LOGIN, MQResultUtils.SELLER_BALANCE_LOGIN_MSG, sellerDetailResponse)));
		return new AsyncResult<>("doSendRegisterOrLoginMessage accomplished!");
	}
	
	@Override
	@Async
	public Future<String> doSendOrderGoodsMessageToMQBalanceQueue(ShopOrderDTO shopOrder, List<ShopOrderDetailDTO> shopOrderDetailDTOList) {
//		shopOrderDetailDTOList = shopOrder.getShopOrderDetailList();
		Assert.notEmpty(shopOrderDetailDTOList, "shopOrderDetailDTOList not empty");
		shopOrderDetailDTOList.stream().collect(Collectors.groupingBy(ShopOrderDetailDTO::getPreSellerId))
				.forEach((key, value) -> {
//					shopOrder.setShopOrderDetailList(value.stream().map(v -> {
//						ShopOrderDetail sod = new ShopOrderDetail();
//						BeanUtils.copyProperties(v, sod);
//						return sod;
//					}).collect(Collectors.toList()));
					logger.info("doSendOrderGoodsMessageToMQBalanceQueue-->key:"+key);
					logger.info("doSendOrderGoodsMessageToMQBalanceQueue-->value:"+JSONArray.fromObject(value));
					SellerBalance sb = new SellerBalance();
					sb.setSellerId(key);
					List<SellerBalance> sbList = sellerBalanceService.findList(sb);
					if (sbList!=null && !sbList.isEmpty()) {
						logger.info("doSendOrderGoodsMessageToMQBalanceQueue-->balance-->value:"+value.size());
						shopOrder.setPushTime(System.currentTimeMillis());
						shopOrder.setOrderTotal(new BigDecimal(value.stream().mapToDouble(s -> s.getPayTotal().doubleValue()).sum()).setScale(DefaultConstants.BIGDECIMAL_SHOW_DIGIT, BigDecimal.ROUND_HALF_UP));
						shopOrder.setShopOrderDetailDTOList(value);
						doSendMessageToBalanceQueue(sbList.get(0).getBalanceId(), new JsonResponseForMQ<>(MQResultUtils.MQ_PREEMPT_SHOP_ORDER_GOODS, MQResultUtils.MQ_PREEMPT_SHOP_ORDER_GOODS_MSG, shopOrder));
					}
				});
		return new AsyncResult<>("doSendOrderGoodsMessageToMQBalanceQueue accomplished!");
	}
	
	@Override
//	@Async
	public Future<String> doSendBalanceOfflineOrderMessageToMQBalanceQueueForPayNotify(BalanceOfflineOrderNotifyToMQComponent balanceOfflineOrderNotifyToMQComponent) {
		doSendMessageToBalanceQueue(balanceOfflineOrderNotifyToMQComponent.getBalanceId(), new JsonResponseForMQ<>(MQResultUtils.MQ_OFFLINE_ORDER_NOTIFY_RESULT_TO_BALANCE, MQResultUtils.MQ_OFFLINE_ORDER_NOTIFY_RESULT_TO_BALANCE_MSG+balanceOfflineOrderNotifyToMQComponent.getOrderTotal()+"元", balanceOfflineOrderNotifyToMQComponent));
		return new AsyncResult<>("doSendOrderGoodsMessageToMQBalanceQueueForPayNotify accomplished!");
	}
	
	private void doSendMessageToSellerQueue(Integer key, JsonResponseForMQ<?> value) {
		String queueName = DefaultConstants.SellerQueuePrefix + DefaultConstants.QueueSpliter + key;
		logger.info("doSendMessageToSellerQueue-->queueName: " + queueName);
		if (rabbitAdmin.getQueueProperties(queueName) == null) {
			Queue sellerQueue = new Queue(queueName, true, false, false,
					DefaultConstants.SellerPreemptArgsMap);
			rabbitAdmin.declareQueue(sellerQueue);
			rabbitAdmin.declareBinding(BindingBuilder.bind(sellerQueue).to(sellerTopicExchange).with(
					DefaultConstants.SellerRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key));
		}
		try {
			rabbitTemplate.convertAndSend(sellerTopicExchange.getName(),
					DefaultConstants.SellerRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key,
					JsonUtils.AsJsonString(value));
		} catch (AmqpException e) {
			logger.error("doSendOrderGoodsMessageToMQSellerQueue fail queueName: " + queueName);
			logger.error(e.getMessage());
		}
	}
	
	private void doSendMessageToDelivererQueue(Integer key, JsonResponseForMQ<?> value) {
		String queueName = DefaultConstants.DelivererQueuePrefix + DefaultConstants.QueueSpliter + key;
		logger.info("doSendMessageToDelivererQueue-->queueName: " + queueName);
		if (rabbitAdmin.getQueueProperties(queueName) == null) {
			Queue delivererQueue = new Queue(queueName, true, false, false, null);
			rabbitAdmin.declareQueue(delivererQueue);
			rabbitAdmin.declareBinding(BindingBuilder.bind(delivererQueue).to(delivererTopicExchange).with(
					DefaultConstants.DelivererRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key));
		}
		try {
			rabbitTemplate.convertAndSend(delivererTopicExchange.getName(),
					DefaultConstants.DelivererRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key,
					JsonUtils.AsJsonString(value));
		} catch (AmqpException e) {
			logger.error("doSendMessageToDelivererQueue fail queueName: " + queueName);
			logger.error(e.getMessage());
		}
	}
	
	private void doSendMessageToBalanceQueue(Integer key, JsonResponseForMQ<?> value) {
		String queueName = DefaultConstants.BalanceQueuePrefix + DefaultConstants.QueueSpliter + key;
		logger.info("doSendMessageToBalanceQueue-->queueName: " + queueName);
		if (rabbitAdmin.getQueueProperties(queueName) == null) {
			// 并不会执行
			Queue balanceQueue = new Queue(queueName, true, false, false, DefaultConstants.SellerPreemptArgsMap);
			rabbitAdmin.declareQueue(balanceQueue);
			rabbitAdmin.declareBinding(BindingBuilder.bind(balanceQueue).to(balanceTopicExchange).with(
					DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key));
		}
		try {
			rabbitTemplate.convertAndSend(balanceTopicExchange.getName(),
					DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key,
					JsonUtils.AsJsonString(value));
		} catch (AmqpException e) {
			logger.error("doSendMessageToBalanceQueue fail queueName: " + queueName);
			logger.error(e.getMessage());
		}
	}
	
	@Override
	@Async
	public Future<String> doSendUpdateShortcutMessage(SellerGoodsComponent sellerGoodsComponent) {
					SellerBalance sb = new SellerBalance();
					sb.setSellerId(sellerGoodsComponent.getSellerId());
					List<SellerBalance> sbList = sellerBalanceService.findList(sb);
					if (sbList!=null && !sbList.isEmpty()) {
						doSendUpdateShortcutToBalanceQueue(sbList.get(0).getBalanceId(), new JsonResponseForMQ<>(MQResultUtils.MQ_SHORTCUT_SELLER_GOODS, MQResultUtils.MQ_SHORTCUT_SELLER_GOODS_MSG, sellerGoodsComponent));
					}
			
		return new AsyncResult<>("doSendUpdateShortcutToBalanceQueue accomplished!");
	}
	
	
	private void doSendUpdateShortcutToBalanceQueue(Integer key, JsonResponseForMQ<?> value) {
		String queueName = DefaultConstants.BalanceQueuePrefix + DefaultConstants.QueueSpliter + key;
		logger.info("queueName: " + queueName);
		if (rabbitAdmin.getQueueProperties(queueName) == null) {
			// 并不会执行
			Queue balanceQueue = new Queue(queueName, true, false, false, DefaultConstants.SellerPreemptArgsMap);
			rabbitAdmin.declareQueue(balanceQueue);
			rabbitAdmin.declareBinding(BindingBuilder.bind(balanceQueue).to(balanceTopicExchange).with(
					DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key));
		}
		try {
			rabbitTemplate.convertAndSend(balanceTopicExchange.getName(),
					DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key,
					JsonUtils.AsJsonString(value));
		} catch (AmqpException e) {
			logger.error("doSendUpdateShortcutToBalanceQueue fail queueName: " + queueName);
			logger.error(e.getMessage());
		}
	}
    
	@Override
	@Async
	public Future<String> doSendUpdateGoodsMessage(SellerGoodsComponent sellerGoodsComponent) {
					SellerBalance sb = new SellerBalance();
					sb.setSellerId(sellerGoodsComponent.getSellerId());
					List<SellerBalance> sbList = sellerBalanceService.findList(sb);
					if (sbList!=null && !sbList.isEmpty()) {
						doSendUpdateGoodsToBalanceQueue(sbList.get(0).getBalanceId(), new JsonResponseForMQ<>(MQResultUtils.MQ_UPDATE_SELLER_GOODS, MQResultUtils.MQ_UPDATE_SELLER_GOODS_MSG, sellerGoodsComponent));
					}
			
		return new AsyncResult<>("doSendUpdateShortcutToBalanceQueue accomplished!");
	}
	
	
	private void doSendUpdateGoodsToBalanceQueue(Integer key, JsonResponseForMQ<?> value) {
		String queueName = DefaultConstants.BalanceQueuePrefix + DefaultConstants.QueueSpliter + key;
		logger.info("queueName: " + queueName);
		if (rabbitAdmin.getQueueProperties(queueName) == null) {
			// 并不会执行
			Queue balanceQueue = new Queue(queueName, true, false, false, DefaultConstants.SellerPreemptArgsMap);
			rabbitAdmin.declareQueue(balanceQueue);
			rabbitAdmin.declareBinding(BindingBuilder.bind(balanceQueue).to(balanceTopicExchange).with(
					DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key));
		}
		try {
			rabbitTemplate.convertAndSend(balanceTopicExchange.getName(),
					DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key,
					JsonUtils.AsJsonString(value));
		} catch (AmqpException e) {
			logger.error("doSendUpdateShortcutToBalanceQueue fail queueName: " + queueName);
			logger.error(e.getMessage());
		}
	}
	
	@Override
	@Async
	public Future<String> doSendPrintOrderMessage(ShopOrderPrintComponent shopOrderPrintComponent) {
					SellerBalance sb = new SellerBalance();
					sb.setSellerId(shopOrderPrintComponent.getSellerId());
					List<SellerBalance> sbList = sellerBalanceService.findList(sb);
					if (sbList!=null && !sbList.isEmpty()) {
						doSendPrintOrderToBalanceQueue(sbList.get(0).getBalanceId(), new JsonResponseForMQ<>(MQResultUtils.MQ_PRINT_ORDER_GOODS, MQResultUtils.MQ_PRINT_ORDER_GOODS_MSG, shopOrderPrintComponent));
					}
			
		return new AsyncResult<>("doSendPrintOrderToBalanceQueue accomplished!");
	}
	
	
	private void doSendPrintOrderToBalanceQueue(Integer key, JsonResponseForMQ<?> value) {
		String queueName = DefaultConstants.BalanceQueuePrefix + DefaultConstants.QueueSpliter + key;
		logger.info("queueName: " + queueName);
		if (rabbitAdmin.getQueueProperties(queueName) == null) {
			// 并不会执行
			Queue balanceQueue = new Queue(queueName, true, false, false, DefaultConstants.SellerPreemptArgsMap);
			rabbitAdmin.declareQueue(balanceQueue);
			rabbitAdmin.declareBinding(BindingBuilder.bind(balanceQueue).to(balanceTopicExchange).with(
					DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key));
		}
		try {
			rabbitTemplate.convertAndSend(balanceTopicExchange.getName(),
					DefaultConstants.BalanceRoutingKeyPrefix + DefaultConstants.RoutingKeySpliter + key,
					JsonUtils.AsJsonString(value));
		} catch (AmqpException e) {
			logger.error("doSendPrintOrderToBalanceQueue fail queueName: " + queueName);
			logger.error(e.getMessage());
		}
	}
	
	
	@Override
	@Async
	public Future<String> doSendUnPrepareGoodsMessageToMQBalanceQueue(ShopOrderDTO shopOrder, List<ShopOrderDetailDTO> shopOrderDetailDTOList,String msgType) {
		Assert.notEmpty(shopOrderDetailDTOList, "shopOrderDetailDTOList not empty");
		shopOrderDetailDTOList.stream().collect(Collectors.groupingBy(ShopOrderDetailDTO::getPreSellerId))
				.forEach((key, value) -> {
					logger.info("doSendUnPrepareGoodsMessageToMQBalanceQueue-->key:"+key);
					logger.info("doSendUnPrepareGoodsMessageToMQBalanceQueue-->value:"+value.size());
					SellerBalance sb = new SellerBalance();
					sb.setSellerId(key);
					List<SellerBalance> sbList = sellerBalanceService.findList(sb);
					if (sbList!=null && !sbList.isEmpty()) {
						logger.info("doSendUnPrepareGoodsMessageToMQBalanceQueue-->balance-->value:"+value.size());
						shopOrder.setShopOrderDetailDTOList(value);
						if(msgType.equals(ShopOrderDetailServiceImpl.tenminunpreparegoodsmsgtype)) {
							doSendMessageToBalanceQueue(sbList.get(0).getBalanceId(), new JsonResponseForMQ<>(MQResultUtils.MQ_PREPARE_SHOP_ORDER_GOODS, MQResultUtils.MQ_TEN_UN_PREPARE_GOODS_MSG, msgType));
						}
						if(msgType.equals(ShopOrderDetailServiceImpl.twentyminunpreparegoodsmsgtype)) {
							doSendMessageToBalanceQueue(sbList.get(0).getBalanceId(), new JsonResponseForMQ<>(MQResultUtils.MQ_PREPARE_SHOP_ORDER_GOODS, MQResultUtils.MQ_TWENTY_UN_PREPARE_GOODS_MSG, msgType));
						}
					}
				});
		return new AsyncResult<>("doSendUnPrepareGoodsMessageToMQBalanceQueue accomplished!");
	}
	
	@Override
	@Async
	public Future<String> doSendUnPrepareGoodsMessageToMQSellerQueue(ShopOrderDTO shopOrder, List<ShopOrderDetailDTO> shopOrderDetailDTOList,String msgType) {
		Assert.notEmpty(shopOrderDetailDTOList, "shopOrderDetailDTOList not empty");
		shopOrderDetailDTOList.stream().collect(Collectors.groupingBy(ShopOrderDetailDTO::getPreSellerId))
				.forEach((key, value) -> {
					logger.info("doSendOrderGoodsMessageToMQSellerQueue-->key:"+key);
					logger.info("doSendOrderGoodsMessageToMQSellerQueue-->value:"+value.size());
					shopOrder.setShopOrderDetailDTOList(value);
					if(msgType.equals(ShopOrderDetailServiceImpl.tenminunpreparegoodsmsgtype)) {
						doSendMessageToSellerQueue(key, new JsonResponseForMQ<>(MQResultUtils.MQ_PREPARE_SHOP_ORDER_GOODS, MQResultUtils.MQ_TEN_UN_PREPARE_GOODS_MSG, msgType));
					}
					if(msgType.equals(ShopOrderDetailServiceImpl.twentyminunpreparegoodsmsgtype)) {
						doSendMessageToSellerQueue(key, new JsonResponseForMQ<>(MQResultUtils.MQ_PREPARE_SHOP_ORDER_GOODS, MQResultUtils.MQ_TWENTY_UN_PREPARE_GOODS_MSG, msgType));
					}
				});
		return new AsyncResult<>("doSendOrderGoodsMessageToMQSellerQueue accomplished!");
	}
	
}
