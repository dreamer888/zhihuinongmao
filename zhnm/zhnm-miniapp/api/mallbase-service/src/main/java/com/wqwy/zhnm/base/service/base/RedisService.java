package com.wqwy.zhnm.base.service.base;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.wqwy.zhnm.base.component.component.LimitOrderComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.dao.ShopOrderDetailMapper;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;

@Service
@ConditionalOnProperty(name = "redis.enabled", havingValue = "true")
public class RedisService {

	public static final Logger logger = LoggerFactory.getLogger(RedisService.class);
	
	@Autowired
    private RedisTemplate<String, String> template;

    // inject the template as ListOperations
//    @Autowired
//    @Qualifier("redisTemplate")
	@Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;
	
	@Autowired
	private ShopOrderDetailMapper shopOrderDetailMapper;
    
    public static enum KeyPrefix {
    	SELLER_PREEMPT_
    }
    
    /**
     * 
     * @Title: addPreemptOrderToSellerList  
     * @Description: 将商户的抢单信息数据放入redis  
     * @date 11 Jun 2018 4:57:02 PM  
     * @param @param sellerId
     * @param @param value  
     * @return void  
     * @throws
     */
    public void addPreemptOrderToSellerList(Integer sellerId, String value) {
    	logger.info("do addPreemptOrderToSellerList sellerId: " + sellerId + " value: " + value);
    	listOps.leftPush(KeyPrefix.SELLER_PREEMPT_.toString() + sellerId, value);
    }
    
    /**
     * 
     * @Title: findSellerPreemptOrderList  
     * @Description: 从redis中查询商户可抢单数据列表  
     * @date 11 Jun 2018 4:57:45 PM  
     * @param @param sellerId
     * @param @return  
     * @return List<String>  
     * @throws
     */
    public List<ShopOrderDTO> findSellerPreemptOrderList(Integer sellerId) {
    	/*
    	 * 1.find前check列表中的数据的超时时间 删除超时的数据
    	 */
    	checkSellerPreemptListUseful(sellerId);
    	/*
    	 * 2.返回数据列表 一次返回所有
    	 */
    	return listOps.range(KeyPrefix.SELLER_PREEMPT_.toString() + sellerId, 0, -1).stream().map(s -> (ShopOrderDTO) JsonUtils.AsJsonObject(s, ShopOrderDTO.class)).collect(Collectors.toList());
    }
    
    /**
     * 
     * @Title: cronCheckSellerPreemptListUseful  
     * @Description: Cron定时检查redis中的数据是否可用  
     * @date 11 Jun 2018 4:48:05 PM  
     * @param   
     * @return void  
     * @throws
     */
    public void cronCheckSellerPreemptListUseful() {
    	Set<String> keySet = template.keys(KeyPrefix.SELLER_PREEMPT_.toString() + "*");
    	keySet.forEach(s -> {
    		Integer i = Integer.valueOf(s.replaceFirst(KeyPrefix.SELLER_PREEMPT_.toString(), StringUtils.EMPTY));
    		checkSellerPreemptListUseful(i);
    	});
    }
    
    /**
     * 
     * @Title: checkSellerPreemptListUseful  
     * @Description: 检查商户待抢单列表数据是否是可用的  
     * @date 11 Jun 2018 3:59:31 PM  
     * @param @param sellerId  
     * @return void  
     * @throws
     */
    /**
     * @deprecated 可能产生较为严重的效率影响,尤其在作为定时任务执行时
     * 可考虑降低数据的准确性,转而在用户实际操作时报错阻止用户操作
     * 
	 * 商户抢单列表数据
	 * 1.key='seller_{sellerId}' value={orderDetail}
	 * 2.多个key的value中的orderDetail组成list 每个orderDetail有超时时间
	 * 3.取出数据时判断超时时间 超时则删除数据
	 * 4.定时取出数据判断超时时间 超时则删除数据
	 * 
	 * 单线程情况考虑如何判断超时(分布式暂时不考虑)
	 * f(x) = {
	 *     e = list.rightPop
	 *     if (e == null)
	 *         return;
	 *     if (e.expireLimitTime <= now())// 到期即为超时
	 *         f(x);
	 *     else
	 *         list.rightPush(e); return;
	 * }
	 * 1.取出数据前调用f(x)先check数据 => 再 return listOps.range(key, 0, -1)
	 * 2.定时check数据调用f(x) 后return
	 */
    /*
     * 可用条件:
     * 1.未超时
     * 2.该订单状态为待抢单状态
     * 3.该商户未抢该订单
     */
    private void checkSellerPreemptListUseful(Integer sellerId) {
    	logger.info("do checkSellerPreemptListUseful for seller: " + sellerId);
    	String s = listOps.rightPop(KeyPrefix.SELLER_PREEMPT_.toString() + sellerId);
    	if (s == null || s.isEmpty())
    		return;
    	LimitOrderComponent ltc = (LimitOrderComponent) JsonUtils.AsJsonObject(s, LimitOrderComponent.class);
    	ShopOrderDetail sod = new ShopOrderDetail();
    	sod.setOrderId(ltc.getOrderId());
    	// 该订单已经超时
    	if (new Date(ltc.getAddtime().getTime() + AboutOrderService.OrderTimeLimit).before(new Date())
        		// 订单已经不在待抢单状态了
    			|| !DefaultConstants.ShopOrderEnum.SHOPORDER_PAYED_NEED_ACCEPT_ORDER.getShopOrderEnum().equals(ltc.getStatus())
        		// 商户已经抢了订单中的任意一个商品 不能再抢了
    			|| shopOrderDetailMapper.findList(sod).stream().filter(so -> sellerId.equals(so.getSellerId())).count() != 0)
    		checkSellerPreemptListUseful(sellerId);
    	else
    		listOps.rightPush(KeyPrefix.SELLER_PREEMPT_.toString() + sellerId, s);
    }
    
}
