package com.yq.controller.user;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.util.MD5;
import org.change.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.weixin.util.GetInfo;
import com.wqwy.zhnm.base.component.constant.WechatApiConstants;
import com.yq.service.cart.CartManager;
import com.yq.service.user.ShopUserManager;
import com.yq.util.CookieUtil;
import com.yq.util.DatetimeUtil;
import com.yq.util.HttpRequest;
import com.yq.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * 说明：会员用户 创建人： qq 357788906 创建时间：2016-12-28
 */
@Controller
public class ShopUserController extends BaseController {

	@Resource(name = "shopUserService")
	private ShopUserManager shopUserService;

	@Resource(name = "cartService")
	private CartManager cartService;

	private Gson gson = new GsonBuilder().serializeNulls().create();

	private static final Logger logger = LoggerFactory.getLogger(ShopUserController.class);
	
	@ResponseBody
	@RequestMapping(value = "/check_session_out")
	public String check_session_out() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result", 1);
		return gson.toJson(map);
	}
	
	@RequestMapping(value = "/app/to_wxlogin")
	public void to_wxlogin(HttpServletResponse response) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		String url = pd.getString("url");
//		PageData config = Config.getconfig();
		response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WechatApiConstants.WECHAT_APPID
				+ "&redirect_uri=" + WechatApiConstants.WECHAT_REDIRECT_PREFIX + "/app/to_login?url=" + url
				+ "&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect");
		// this.getRequest().getRequestDispatcher("").forward(this.getRequest(),
		// response);
	}

	@RequestMapping(value = "/app/to_login")
	public ModelAndView to_login() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		ModelAndView mv = this.getModelAndView();
		pd.put("url", this.getRequest().getAttribute("url"));
		logger.info("app/to_login-->" + pd);
		mv.addObject("pd", pd);
		mv.setViewName("center/user/login");
		return mv;
	}

	@RequestMapping(value = "/app/to_regist")
	public ModelAndView to_regist() throws Exception {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("center/user/regist");
		return mv;
	}

	@RequestMapping(value = "/app/to_forget")
	public ModelAndView to_forget() throws Exception {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("center/user/forget");
		return mv;
	}

	/**
	 * 退出
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login_out")
	public ModelAndView login_out(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		ModelAndView mv = this.getModelAndView();
		session.removeAttribute("shopUser");
		session.removeAttribute("cart_count");
		CookieUtil.cookiedelete(request, response);
		mv.setViewName("redirect:app/center/index");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = {"/user/info", "/", "/test/user/info" }, produces = "application/json;charset=UTF-8")
	public String user_info() throws Exception {
		Map<String, Object> shopUser = StringUtil.shopUser(this.getRequest());
		PageData pd = new PageData();
		pd.put("user_id", shopUser.get("user_id"));
		PageData user = shopUserService.findById(pd);
		user.put("cart_count", shopUser.get("cart_count"));
		return gson.toJson(user);
	}

	@RequestMapping(value = "/user/phone")
	public ModelAndView phone() throws Exception {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("center/user/phone");
		return mv;
	}

	/**
	 * 用户注册
	 * 
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/app/regist", produces = "application/json;charset=UTF-8")
	public String regist(HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		String message = "";
		PageData pd = new PageData();
		pd = this.getPageData();
		String phone = pd.getString("phone");
		String code = pd.getString("code");
		String password = pd.getString("password");
		pd.put("password", null);
		PageData isUser = shopUserService.findByPhone(pd);
		pd.put("password", password);
		if (isUser == null) {
			if (checkcode(phone, code)) {// 验证短信
				if (checkpassword()) { // 验证两次输入的密码
					PageData baseInfo = (PageData) this.getRequest().getSession().getAttribute("baseInfo");
					if (baseInfo != null) {
						pd.put("openid", baseInfo.getString("openid"));
					}
					pd.put("password", MD5.md5(pd.getString("password")));
					pd.put("addtime", DatetimeUtil.getDatetime());
					pd.put("head_img", "static/upload/headimg.jpg");
					pd.put("username", "商城用户");
					pd.put("user_id", this.get32UUID());
					shopUserService.save(pd);
					// PageData shopUser = pd;//
					// shopUserService.findByPhone(pd);
					// CookieUtil.cookieadd(response, "phone", phone);
					// CookieUtil.cookieadd(response, "password", password);
					// this.getRequest().getSession().setAttribute("shopUser",
					// shopUser);
					// this.getRequest().getSession().setAttribute("cart_count",
					// 0);
					// map.put("shopUser", shopUser);
					result = 1;
					message = "注册成功！";
				} else {
					result = 0;
					message = "两次密码不一致！";
				}
			} else {
				result = 0;
				message = "验证码错误！";
			}
		} else {
			result = 0;
			message = "用户已存在，请重新输入！";
		}

		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	@RequestMapping(value = "/app/to_checklogin")
	public void to_checklogin(HttpServletResponse response) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		logger.info("196 . pd = " + pd);
		String path = this.getRequest().getContextPath();
		String url = this.getRequest().getScheme() + "://" + this.getRequest().getServerName() + ":"
				+ this.getRequest().getServerPort() + path + "/index";

		// String url = "index";//pd.getString("url");
		// url = (this.getRequest().getRequestURL() + "?" +
		// this.getRequest().getQueryString()).toString();
		String phone = pd.getString("phone");
		String password = pd.getString("password");
		logger.info("196 -> url = " + url);
		String param = "{url:\"" + url + "\",phone:\"" + phone + "\",password:\"" + password + "\"}";
		logger.info("204 -> param = " + param);
		String ua = this.getRequest().getHeader("user-agent").toLowerCase();
		if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
//			PageData config = Config.getconfig();
			String resUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WechatApiConstants.WECHAT_APPID
					+ "&redirect_uri=" + WechatApiConstants.WECHAT_REDIRECT_PREFIX + "/app/login?param=" + param
					+ "&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";
			logger.info("203 . resUrl = " + resUrl);
			response.sendRedirect(resUrl);
		} else {
			logger.info("216 -> param = " + param);
			this.getRequest().getRequestDispatcher("login?param=" + param).forward(this.getRequest(), response);
		}
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/app/login")
	public void login(HttpServletResponse response) throws Exception {
		int result = 0;
		String message = "";
		PageData pd = new PageData();
		pd = this.getPageData();
		logger.info("223 -> pd = " + pd);
		String param = pd.getString("param");
		logger.info("226 -> param = " + param);
		JsonObject jsondata = new JsonParser().parse(param).getAsJsonObject();
		// jsondata.get("");
		String url = jsondata.get("url").getAsString();
		String phone = jsondata.get("phone").getAsString();
		logger.info("225 -> phone = " + phone);
		if (StringUtils.isNotEmpty(phone)) {
			String password = jsondata.get("password").getAsString();
			if (StringUtils.isEmpty(password)) {
				pd.put("password", " ");
			} else {
				pd.put("password", MD5.md5(password));
			}
			pd.put("phone", phone);
			PageData shopUser = shopUserService.findByPhone(pd);
			pd.put("password", null);
			PageData isUser = shopUserService.findByPhone(pd);
			if (isUser != null) { // 用户存在
				if (shopUser != null) {// 账号密码正确
					result = 1;
					message = "登录成功！";
					if (pd.getString("code") != null) {
						PageData baseInfo = GetInfo.baseInfo(pd, this.getRequest());
						String openid = baseInfo.getString("openid");
						shopUser.put("openid", openid);
						CookieUtil.cookieadd(response, "openid", openid);
					}
					CookieUtil.cookieadd(response, "phone", phone);
					CookieUtil.cookieadd(response, "password", password);
					this.getRequest().getSession().setAttribute("shopUser", shopUser);
					pd.put("user_id", shopUser.getString("user_id"));
					this.getRequest().getSession().setAttribute("cart_count", cartService.count(pd));
				} else {
					result = 0;
					message = "密码错误！";
				}
			} else {
				result = -1;
				message = "用户不存在，请注册！";
			}

		} else {
			result = -2;
			message = "请输入手机号！";
		}
		if (result == 1) {
			// String path = this.getRequest().getContextPath();
			// url =
			// this.getRequest().getScheme()+"://"+this.getRequest().getServerName()+":"+this.getRequest().getServerPort()+path+"/"
			// +url;
			response.sendRedirect(url);
		} else {
			response.sendRedirect("to_login?url=" + url + "&result=" + result);
		}
	}

	// /**
	// * 微信登录
	// *
	// * @return
	// * @throws Exception
	// */
	// @ResponseBody
	// @RequestMapping(value = "/app/wxlogin", produces =
	// "application/json;charset=UTF-8")
	// public String appwxlogin() throws Exception {
	// Map<String, Object> map = new HashMap<String, Object>();
	// int result = 0;
	// String message = "";
	// PageData pd = new PageData();
	// pd = this.getPageData();
	// PageData isUser = shopUserService.findById(pd);
	// if (isUser != null) { // 用户存在
	// result = 1;
	// message = "登录成功！";
	//
	// this.getRequest().getSession().setAttribute("shopUser", isUser);
	//
	// } else {
	// result = 0;
	// message = "请填写手机信息！";
	// }
	// map.put("shopUser", isUser);
	// map.put("result", result);
	// map.put("message", message);
	// return gson.toJson(map);
	// }

	/**
	 * 微信登录
	 * 
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping(value = "/app/wxlogin")
	public void wxlogin(HttpServletResponse response) throws IOException {
		PageData pd = new PageData();
		pd = this.getPageData();
		String url = pd.getString("url");
//		PageData config = Config.getconfig();
		response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WechatApiConstants.WECHAT_APPID
				+ "&redirect_uri=" + WechatApiConstants.WECHAT_REDIRECT_PREFIX + "/app/weixinlogin?url=" + url
				+ "&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect");
	}

	@ResponseBody
	@RequestMapping(value = "/app/weixinlogin", produces = "application/json;charset=UTF-8")
	public String weixinlogin(HttpSession session) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		String session_id = StringUtil.get_session_id(this.getRequest()) ;
		Map<String, Object> map = new HashMap<String, Object>();
		int cart_count = 0 ;
		int result = 0;
		PageData shopUser = new PageData();
		Map<String, Object> shop_user_map =  StringUtil.shopUser(this.getRequest());
		if (shop_user_map == null) {
			String user_id = "";
			String code = pd.getString("code");
//			PageData config = Config.getconfig();
			String appid = WechatApiConstants.WECHAT_APPID;// 小程序的 app secret (在微信小程序管理后台获取)
			String secret = WechatApiConstants.WECHAT_APPSECRET;
			String grant_type = "authorization_code";// 授权（必填）
			String params = "appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=" + grant_type;// 请求参数			
			String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);// 发送请求
			JSONObject json = JSONObject.fromObject(sr);
			String session_key = json.get("session_key").toString();// 获取会话密钥（session_key）
			pd.put("session_key", session_key);
			PageData info = GetInfo.userInfo(pd, this.getRequest());
			
//			PageData info = new PageData();
//			info.put("avatarUrl", "https://wx.qlogo.cn/mmopen/vi_32/mKr88avkPmgvdI4ves1iatcDeYAoAakTVUon7icAicOiaNzQZDFyiaq5aWIRMaVccySibPHE6tUuXpXL3FWPEEibQP2Aw/132");
//			info.put("nickName", "唐熙连");
			if (info != null) {
				result = 1;
				
				String openid = info.getString("openId");
//				String openid = "osWd35Ei3O9hJ4XqI_37V_lw_F38";// TODO
				
				// String unionid = info.getString("unionid");
				pd.put("openid", openid);
				shopUser = shopUserService.findById(pd);
				if (shopUser == null) { // 用户不存在
					user_id = this.get32UUID();
					shopUser = new PageData(); 
					shopUser.put("addtime", DatetimeUtil.getDatetime());
					shopUser.put("user_id", user_id);
					shopUser.put("head_img", info.get("avatarUrl"));
					shopUser.put("username", info.get("nickName"));
					shopUser.put("openid", openid);
					shopUserService.save(shopUser);
					cart_count = 0;
				} else {
					pd.put("user_id", shopUser.getString("user_id"));
					cart_count = cartService.count(pd);
				}
				shopUser.put("cart_count", cart_count);
				session.setAttribute("shopUser", shopUser);
				map.put("shopUser", shopUser);
			}
		} else {
			result =1 ;
			cart_count=  (new Double((double) shop_user_map.get("cart_count"))).intValue();
			shop_user_map.put("cart_count", cart_count);
			map.put("shopUser", shop_user_map);
			session.setAttribute("shopUser", shop_user_map);
		}
		StringUtil.add_session(session);
		map.put("cart_count", cart_count);
		map.put("result", result);
		map.put("session_id", session_id);
		return gson.toJson(map);
	}

	public boolean checkcode(String phone, String code) {
		PageData session = (PageData) this.getRequest().getSession().getAttribute("phonecode");
		if (this.getRequest().getSession().getAttribute("phonecode") != null) {

			// logger.info("内存中的phone = " + session.getString("phone"));
			// logger.info("内存中的code = " + session.getString("code"));
			if (phone.equals(session.getString("phone")) && code.equals(session.getString("code"))) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}

	}

	@ResponseBody
	@RequestMapping(value = "/app/getUser", produces = "application/json;charset=UTF-8")
	public String appgetUser() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData shopUser = shopUserService.findById(pd);
		this.getRequest().getSession().setAttribute("shopUser", shopUser);
		return gson.toJson(shopUser);
	}

	@RequestMapping(value = "/getUser", produces = "application/json;charset=UTF-8")
	public ModelAndView getUser() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object> user = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", user.get("user_id"));
		PageData shopUser = shopUserService.findById(pd);
		this.getRequest().getSession().setAttribute("shopUser", shopUser);
		mv.setViewName("center/index");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/app/getcode", produces = "application/json;charset=UTF-8")
	public String getcode() {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		String message = "";
		try {
			this.getRequest().getSession().removeAttribute("phonecode");
			PageData pd = new PageData();
			pd = this.getPageData();
			String random = "1";// (int) ((Math.random() * 9 + 1) * 100000) +
								// "";
			System.out.println(random);
			String phone = pd.getString("phone");
			String url = "http://sms.253.com/msg/";// 应用地址
			String un = "";// 账号
			String pw = "";// 密码
			String msg = "【嗨皮购商城】尊敬的用户，您本次的验证码为" + random + "有效期10分钟。";// 短信内容
			String rd = "0";// 是否需要状态报告，需要1，不需要0
			String ex = null;// 扩展码
			// String returnString = SmsUtil.batchSend(url, un, pw, phone, msg,
			// rd, ex);
			pd.put("phone", phone);
			pd.put("code", random);
			System.out.println(msg);
			this.getRequest().getSession().setAttribute("phonecode", pd);
			result = 1;
			message = "发送成功！";
		} catch (Exception e) {
			result = -1;
			message = "服务器异常！";
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	/**
	 * 验证2次输入的密码
	 * 
	 * @return
	 */
	public boolean checkpassword() {
		PageData pd = new PageData();
		pd = this.getPageData();
		if (pd.getString("password").equals(pd.getString("password1"))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改
	 * 
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/app/forget", produces = "application/json;charset=UTF-8")
	public String edit() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		String message = "";
		PageData pd = new PageData();
		pd = this.getPageData();
		String phone = pd.getString("phone");
		String code = pd.getString("code");
		PageData isUser = shopUserService.findByPhone(pd);
		if (isUser == null) {
			if (checkpassword()) { // 验证两次输入的密码
				if (checkcode(phone, code)) {// 验证短信
					pd.put("password", MD5.md5(pd.getString("password")));
					shopUserService.edit(pd);
					result = 1;
					message = "修改成功！";

				} else {
					result = 0;
					message = "验证码错误！";
				}
			} else {
				result = 0;
				message = "两次密码不一致！";
			}
		} else {
			result = 0;
			message = "手机号已存在，请重新输入！";
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	@ResponseBody
	@RequestMapping(value = "/user/upload", produces = "application/json;charset=UTF-8")
	public String upload(@RequestParam MultipartFile file, HttpServletRequest request) throws Exception {
		PageData pd = new PageData();
		Map<String, Object> map = new HashMap<String, Object>();
		String realpath = request.getSession().getServletContext().getRealPath("");
		String path = "";
		if (realpath.contains("\\")) {
			path = realpath.substring(0, realpath.lastIndexOf("\\")) + "/mallupload"; // windows
		} else {
			path = realpath.substring(0, realpath.lastIndexOf("/")) + "/mallupload"; // linux
		}

		String fileName = new Date().getTime() + ".png";

		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		file.transferTo(targetFile);
		String url = "/mallupload/" + fileName;
		Map<String, Object> shopUser = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", shopUser.get("user_id"));
		pd.put("head_img", url);
		shopUserService.edit(pd);
		shopUser.put("head_img", url);
		map.put("result", 1);
		map.put("message", "提交成功！");
		map.put("img", url);
		return gson.toJson(map);
	}

	/**
	 * 更新用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/user/update", produces = "application/json;charset=UTF-8")
	public String update() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object> shopUser = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", shopUser.get("user_id"));
		shopUserService.edit(pd);
		PageData user = shopUserService.findById(pd);
		this.getRequest().getSession().setAttribute("shopUser", user);
		map.put("shopUser", user);
		map.put("result", 1);
		map.put("message", "提交成功！");
		return gson.toJson(map);
	}

	/**
	 * 更新用户手机
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/user/update_phone", produces = "application/json;charset=UTF-8")
	public String update_phone() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		int result = 0;
		String message = "";
		String phone = pd.getString("phone");
		String code = pd.getString("code");
		// if (checkcode(phone, code)) {// 验证短信
		PageData isUser = shopUserService.findByPhone(pd);
		if (isUser == null) { // 用户存在

			Map<String, Object> shopUser = StringUtil.shopUser(this.getRequest());
			pd.put("user_id", shopUser.get("user_id"));
			shopUserService.update_phone(pd);
			PageData user = shopUserService.findById(pd);
			this.getRequest().getSession().setAttribute("shopUser", user);
			result = 1;
			message = "提交成功！";
		} else {
			message = "手机号已存在！";
		}
		// } else {
		// message = "验证码错误！";
		// }
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	/**
	 * 更新用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/app/password", produces = "application/json;charset=UTF-8")
	public String getpassword() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		String message = "";
		PageData pd = new PageData();
		pd = this.getPageData();
		String phone = pd.getString("phone");
		String code = pd.getString("code");
		String password = MD5.md5(pd.getString("password"));
		if (checkcode(phone, code)) {// 验证短信
			// PageData shopUser = (PageData)
			// this.getRequest().getSession().getAttribute("phonecode");
			pd.put("phone", phone);
			pd.put("password", password);
			shopUserService.setpassword(pd);
			result = 1;
			message = "提交成功！";
			PageData user = shopUserService.findByPhone(pd);
			this.getRequest().getSession().setAttribute("shopUser", user);
			map.put("shopUser", user);

		} else {
			result = 0;
			message = "验证码错误！";
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/app/remove", produces = "application/json;charset=UTF-8")
	public String remove() {
		String result = "1";
		try {
			this.getApp().removeAttribute("page");
		} catch (Exception e) {
			result = "2";
		}
		return result;
	}
}
