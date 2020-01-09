package com.weixin.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.marker.weixin.DefaultSession;
import org.marker.weixin.HandleMessageAdapter;
import org.marker.weixin.MySecurity;
import org.marker.weixin.msg.Data4Item;
import org.marker.weixin.msg.Msg4Event;
import org.marker.weixin.msg.Msg4Image;
import org.marker.weixin.msg.Msg4ImageText;
import org.marker.weixin.msg.Msg4Link;
import org.marker.weixin.msg.Msg4Location;
import org.marker.weixin.msg.Msg4Text;
import org.marker.weixin.msg.Msg4Video;
import org.marker.weixin.msg.Msg4Voice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.service.command.CommandService;
import com.weixin.service.imgmsg.ImgmsgService;
import com.weixin.service.textmsg.TextmsgService;
import com.weixin.util.Accesstoken;
import com.weixin.util.GetWxOrderno;
import com.weixin.util.StringUtil;
import com.weixin.util.WxXml;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.constant.DefaultConstants.WechatResponseEnum;
import com.wqwy.zhnm.base.component.constant.WechatApiConstants;
import com.wqwy.zhnm.base.component.exception.WechatException;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPayUtil;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.base.AboutOrderService;
import com.yq.controller.pay.ReturnController;
import com.yq.service.cart.CartManager;
import com.yq.service.goods.GoodsManager;
import com.yq.service.order.OrderDetailManager;
import com.yq.service.order.OrderManager;
import com.yq.service.user.ShopUserManager;
import com.yq.util.GetIp;

import net.sf.json.JSONObject;

/**
 * 
 * 类名称：WeixinController.java 类描述： 微信公共平台开发
 * 
 * @author 作者单位： 联系方式： 创建时间：2014年7月10日
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/weixin")
public class WeixinController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(WeixinController.class);

	@Resource(name = "textmsgService")
	private TextmsgService textmsgService;
	@Resource(name = "commandService")
	private CommandService commandService;
	@Resource(name = "imgmsgService")
	private ImgmsgService imgmsgService;

	@Resource(name = "orderService")
	public OrderManager orderService;
	
	@Resource(name = "orderDetailService")
	private OrderDetailManager orderDetailService;
	@Resource(name = "goodsService")
	public GoodsManager goodsService;
	@Resource(name = "cartService")
	public CartManager cartService;
	
	@Resource(name = "shopUserService")
	public ShopUserManager shopUserService;
	public ReturnController returnController = new ReturnController();
	
	
	@Autowired
	private AboutOrderService aboutOrder;
	
	
	

	/**
	 * 接口验证,总入口
	 * 
	 * @param out
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/reply")
	public void index(PrintWriter out, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("微信接口");
		String ip = GetIp.getIp(request);
		logger.info("请求ip---->"+ip+GetIp.getAddresses("ip=" + ip, "utf-8"));
		PageData pd = new PageData();
		try {
			pd = this.getPageData();
			String signature = pd.getString("signature"); // 微信加密签名
			String timestamp = pd.getString("timestamp"); // 时间戳
			String nonce = pd.getString("nonce"); // 随机数
			String echostr = pd.getString("echostr"); // 字符串

			if (null != signature && null != timestamp && null != nonce && null != echostr) {/* 接口验证 */
				logger.info("进入身份验证");
				List<String> list = new ArrayList<String>(3) {
					private static final long serialVersionUID = 2621444383666420433L;

					public String toString() { // 重写toString方法，得到三个参数的拼接字符串
						return this.get(0) + this.get(1) + this.get(2);
					}
				};
				list.add(StringUtil.token()); // 读取Token(令牌)
				list.add(timestamp);
				list.add(nonce);
				Collections.sort(list); // 排序
				String tmpStr = new MySecurity().encode(list.toString(), MySecurity.SHA_1); // SHA-1加密

				if (signature.equals(tmpStr)) {
					out.write(echostr); // 请求验证成功，返回随机码
				} else {
					out.write("");
				}
				out.flush();
				out.close();
			} else {/* 消息处理 */
				logger.info("进入消息处理");
				response.reset();
				sendMsg(request, response);
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	/**
	 * 处理微信服务器发过来的各种消息，包括：文本、图片、地理位置、音乐等等
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void sendMsg(HttpServletRequest request, HttpServletResponse response) throws Exception {

		InputStream is = request.getInputStream();
		OutputStream os = response.getOutputStream();

		final DefaultSession session = DefaultSession.newInstance();
		session.addOnHandleMessageListener(new HandleMessageAdapter() {

			/**
			 * 事件
			 */
			@Override
			public void onEventMsg(Msg4Event msg) {
				/**
				 * msg.getEvent() unsubscribe：取消关注 ; subscribe：关注
				 */
				if ("subscribe".equals(msg.getEvent())) {
					returnMSg(msg, null, "关注");
				}
			}

			/**
			 * 收到的文本消息
			 */
			@Override
			public void onTextMsg(Msg4Text msg) {
				returnMSg(null, msg, msg.getContent().trim());
			}

			@Override
			public void onImageMsg(Msg4Image msg) {
				super.onImageMsg(msg);
			}

			@Override
			public void onLocationMsg(Msg4Location msg) {
				super.onLocationMsg(msg);
			}

			@Override
			public void onLinkMsg(Msg4Link msg) {
				super.onLinkMsg(msg);
			}

			@Override
			public void onVideoMsg(Msg4Video msg) {
				super.onVideoMsg(msg);
			}

			@Override
			public void onVoiceMsg(Msg4Voice msg) {
				super.onVoiceMsg(msg);
			}

			@Override
			public void onErrorMsg(int errorCode) {
				super.onErrorMsg(errorCode);
			}

			/**
			 * 返回消息
			 * 
			 * @param emsg
			 * @param tmsg
			 * @param getmsg
			 */
			public void returnMSg(Msg4Event emsg, Msg4Text tmsg, String getmsg) {
				PageData msgpd;
				PageData pd = new PageData();
				String toUserName, fromUserName, createTime;
				if (null == emsg) {
					toUserName = tmsg.getToUserName();
					fromUserName = tmsg.getFromUserName();
					createTime = tmsg.getCreateTime();
				} else {
					toUserName = emsg.getToUserName();
					fromUserName = emsg.getFromUserName();
					createTime = emsg.getCreateTime();
				}
				pd.put("KEYWORD", getmsg);
				try {
					msgpd = textmsgService.findByKw(pd);
					if (null != msgpd) {
						Msg4Text rmsg = new Msg4Text();
						rmsg.setFromUserName(toUserName);
						rmsg.setToUserName(fromUserName);
						// rmsg.setFuncFlag("0");
						rmsg.setContent(msgpd.getString("CONTENT")); // 回复文字消息
						session.callback(rmsg);
					} else {
						msgpd = imgmsgService.findByKw(pd);
						if (null != msgpd) {
							Msg4ImageText mit = new Msg4ImageText();
							mit.setFromUserName(toUserName);
							mit.setToUserName(fromUserName);
							mit.setCreateTime(createTime);
							// 回复图文消息
							if (null != msgpd.getString("TITLE1") && null != msgpd.getString("IMGURL1")) {
								Data4Item d1 = new Data4Item(msgpd.getString("TITLE1"), msgpd.getString("DESCRIPTION1"),
										msgpd.getString("IMGURL1"), msgpd.getString("TOURL1"));
								mit.addItem(d1);

								if (null != msgpd.getString("TITLE2") && null != msgpd.getString("IMGURL2")
										&& !"".equals(msgpd.getString("TITLE2").trim())
										&& !"".equals(msgpd.getString("IMGURL2").trim())) {
									Data4Item d2 = new Data4Item(msgpd.getString("TITLE2"),
											msgpd.getString("DESCRIPTION2"), msgpd.getString("IMGURL2"),
											msgpd.getString("TOURL2"));
									mit.addItem(d2);
								}
								if (null != msgpd.getString("TITLE3") && null != msgpd.getString("IMGURL3")
										&& !"".equals(msgpd.getString("TITLE3").trim())
										&& !"".equals(msgpd.getString("IMGURL3").trim())) {
									Data4Item d3 = new Data4Item(msgpd.getString("TITLE3"),
											msgpd.getString("DESCRIPTION3"), msgpd.getString("IMGURL3"),
											msgpd.getString("TOURL3"));
									mit.addItem(d3);
								}
								if (null != msgpd.getString("TITLE4") && null != msgpd.getString("IMGURL4")
										&& !"".equals(msgpd.getString("TITLE4").trim())
										&& !"".equals(msgpd.getString("IMGURL4").trim())) {
									Data4Item d4 = new Data4Item(msgpd.getString("TITLE4"),
											msgpd.getString("DESCRIPTION4"), msgpd.getString("IMGURL4"),
											msgpd.getString("TOURL4"));
									mit.addItem(d4);
								}
								if (null != msgpd.getString("TITLE5") && null != msgpd.getString("IMGURL5")
										&& !"".equals(msgpd.getString("TITLE5").trim())
										&& !"".equals(msgpd.getString("IMGURL5").trim())) {
									Data4Item d5 = new Data4Item(msgpd.getString("TITLE5"),
											msgpd.getString("DESCRIPTION5"), msgpd.getString("IMGURL5"),
											msgpd.getString("TOURL5"));
									mit.addItem(d5);
								}
								if (null != msgpd.getString("TITLE6") && null != msgpd.getString("IMGURL6")
										&& !"".equals(msgpd.getString("TITLE6").trim())
										&& !"".equals(msgpd.getString("IMGURL6").trim())) {
									Data4Item d6 = new Data4Item(msgpd.getString("TITLE6"),
											msgpd.getString("DESCRIPTION6"), msgpd.getString("IMGURL6"),
											msgpd.getString("TOURL6"));
									mit.addItem(d6);
								}
								if (null != msgpd.getString("TITLE7") && null != msgpd.getString("IMGURL7")
										&& !"".equals(msgpd.getString("TITLE7").trim())
										&& !"".equals(msgpd.getString("IMGURL7").trim())) {
									Data4Item d7 = new Data4Item(msgpd.getString("TITLE7"),
											msgpd.getString("DESCRIPTION7"), msgpd.getString("IMGURL7"),
											msgpd.getString("TOURL7"));
									mit.addItem(d7);
								}
								if (null != msgpd.getString("TITLE8") && null != msgpd.getString("IMGURL8")
										&& !"".equals(msgpd.getString("TITLE8").trim())
										&& !"".equals(msgpd.getString("IMGURL8").trim())) {
									Data4Item d8 = new Data4Item(msgpd.getString("TITLE8"),
											msgpd.getString("DESCRIPTION8"), msgpd.getString("IMGURL8"),
											msgpd.getString("TOURL8"));
									mit.addItem(d8);
								}
							}
							// mit.setFuncFlag("0");
							session.callback(mit);
						} else {
							msgpd = commandService.findByKw(pd);
							if (null != msgpd) {
								Runtime runtime = Runtime.getRuntime();
								runtime.exec(msgpd.getString("COMMANDCODE"));
							} else {
								Msg4Text rmsg = new Msg4Text();
								rmsg.setFromUserName(toUserName);
								rmsg.setToUserName(fromUserName);
								rmsg.setContent("无匹配结果");
								session.callback(rmsg);
							}
						}
					}
				} catch (Exception e1) {
					logger.info("匹配错误");
				}
			}

		});

		/* 必须调用这两个方法 如果不调用close方法，将会出现响应数据串到其它Servlet中。 */
		session.process(is, os); // 处理微信消息
		session.close(); // 关闭Session
	}

	// ================================================获取关注列表==============================================================
	public final static String gz_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=";

	// 获取access_token
	@RequestMapping(value = "/getGz")
	public void getGz(PrintWriter out) {
		logger.info("获取关注列表");
		try {
			String access_token = Accesstoken.getaccesstoken();

			System.out.println(access_token + "============");

			String requestUrl = gz_url.replace("ACCESS_TOKEN", access_token);

			System.out.println(requestUrl + "============");
			JSONObject jsonObject = Accesstoken.httpsRequest(requestUrl, "GET", null);
			System.out.println(jsonObject);
			// System.out.println(jsonObject.getString("total")+"============");

			/*
			 * PrintWriter pw; try { pw = new PrintWriter( new FileWriter(
			 * "e:/gz.txt" ) ); pw.print(jsonObject.getString("total"));
			 * pw.close(); } catch (IOException e) { 
			 * catch block e.printStackTrace(); }
			 * 
			 * out.write("success"); out.close();
			 */
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	// ================================================获取access_token==============================================================
	// 获取access_token
	@RequestMapping(value = "/getaccesstoken")
	public String getaccesstoken() throws Exception {
		logger.info("获取access_token");
		String access_token = Accesstoken.getaccesstoken();
		System.out.println(access_token);
		return access_token;

	}

	@Autowired
	private ShopOrderService shopOrderService;
	
	/**
	 * 微信支付成功，返回结果
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/return")
	@ResponseBody
	public String noticeOrder(HttpServletRequest request) throws Exception {
		String xmlStr = WxXml.getWxXml(request);
		Map map = GetWxOrderno.doXMLParse(xmlStr);
		String return_code = (String) map.get("return_code");
		String order_id = (String) map.get("out_trade_no");
		logger.info("微信支付成功，返回order_id=="+order_id);
		logger.info("微信支付成功，返回return_code=="+return_code);
		if (return_code.equals("SUCCESS")) {
			
			ShopOrder so = shopOrderService.get(order_id);
			if (!DefaultConstants.ShopOrderEnum.SHOPORDER_PAYED_NEED_ACCEPT_ORDER.getShopOrderEnum().equals(so.getStatus())) {
				returnController.updateorder(order_id, orderService);
				
				/**
				 * 获取微信回调表明用户支付成功 后 标识订单正式创建完成
				 */
				/**
				 * 用户下单success后执行操作
				 */
				aboutOrder.doAfterUserPayedOnlineOrder(order_id);
			}
			return DefaultConstants.WechatResponseXmlMap.get(WechatResponseEnum.SUCCESS);
		}
		return DefaultConstants.WechatResponseXmlMap.get(WechatResponseEnum.FAIL);
	}
	
	/**
	 * 
	 * @Title: notifyOrderRefund  
	 * @Description: 微信退款回调  
	 * @date 12 Jun 2018 5:47:46 PM  
	 * @param @param request
	 * @param @return
	 * @param @throws Exception  
	 * @return String  
	 * @throws
	 */
	@RequestMapping(value = "/notifyRefund")
	@ResponseBody
	public String notifyOrderRefund(HttpServletRequest request) throws Exception {
		// TODO 与商户端支付回调 {#link WechatPayController#wechatPayNofity}冗余
		logger.info("do wxpay notify refund...");
		String str = null;
		Map<String, String> requestMap = new HashMap<String, String>();
		try {
			str = request.getReader().lines().collect(Collectors.joining());
			requestMap = WXPayUtil.xmlToMap(str);
		} catch (Exception e) {
			logger.error("wxpay notify refund response wrong, str: " + str);
			throw new WechatException();
		}
		logger.debug("str: " + str);
		logger.debug("requestMap: " + requestMap.toString());
		String returnCode = requestMap.get("return_code");// 通信标识，非交易标识，交易是否成功需要查看result_code来判断
		String returnMsg = requestMap.get("return_msg");
		//String resultCode = requestMap.get("result_code");
		logger.info("returnCode: " + returnCode);
		logger.info("returnMsg: " + returnMsg);
		if (!DefaultConstants.SUCCESS.equals(returnCode)) {
			logger.error("return_code or result_code not SUCCESS");
			throw new WechatException(returnMsg);
		}
		
		/*
		 * 1
		 */
		try {
			Boolean isValidSign = WXPayUtil.isSignatureValid(str, WechatApiConstants.SIGN_KEY);
			if (!isValidSign)
				throw new WechatException("data " + str + " sign invalid");
		} catch (Exception e1) {
			logger.error(e1.getMessage());
			throw new WechatException();
		}
		return DefaultConstants.WechatResponseXmlMap.get(WechatResponseEnum.SUCCESS);
	}

}
