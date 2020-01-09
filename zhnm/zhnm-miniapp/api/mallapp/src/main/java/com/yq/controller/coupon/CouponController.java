package com.yq.controller.coupon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yq.service.coupon.CouponManager;
import com.yq.util.DatetimeUtil;

@Controller
public class CouponController extends BaseController {

	@Resource(name = "couponService")
	private CouponManager couponService;
	private Gson gson = new GsonBuilder().serializeNulls().create();

	/**
	 * 用户添加优惠券
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/app/userCoupon/add", produces = "application/json;charset=UTF-8")
	public String appadd(Page page) throws Exception {// coupon_id USER_ID
		int result = 0;
		String message = "";
		Map<String, Object> map = new HashMap<String, Object>();
		long nowtime = new Date().getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String addtime = sf.format(new Date());
		PageData pd = new PageData();
		pd = this.getPageData();
		//String COUPON_NUM = pd.getString("COUPON_NUM");
		PageData coupon = couponService.findById(pd);// 根据COUPON_NUM获取优惠券信息
		if (coupon!=null) {// 兑换码正确
		long endtime = sf.parse(coupon.getString("endtime")).getTime() + 1000 * 60 * 60 * 24; // 次日凌晨

			pd.put("coupon_id", coupon.getString("coupon_id"));
			if (couponService.findById(pd) == null) {// 未兑换过
				if (nowtime < endtime) {// 未过期
					pd.put("USER_coupon_id", this.get32UUID()); // 主键
					pd.put("ADDTIME", addtime);
					pd.put("STATUS", 1);
					couponService.save(pd);
					result = 1 ;
					message = "兑换成功";
				} 
				else {
					message = "兑换码已过期";
				}

			} else {
				message = "您已兑换";
			}
		} else {
			message = "兑换码不正确";
		}
		
		map.put("result", result);
		map.put("message",message);
		return gson.toJson(map);
	}
	
	
	/**
	 * 优惠券
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/coupon/list", produces = "application/json;charset=UTF-8")
	public String applist(Page page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("nowtime",DatetimeUtil.getDate());
		page.setPd(pd);
		List<PageData> list =  couponService.list(page);
		map.put("page",page);
		map.put("list",list);
		return gson.toJson(map);
	}
	/**
	 * 去我的优惠券页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/coupon/touser_list")
	public ModelAndView tolist() throws Exception {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("center/coupon/user-list");
		return mv;
	}
	
	/**
	 * 去兑换优惠券页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/coupon/tolist")
	public ModelAndView togetlist() throws Exception {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("center/coupon/list");
		return mv;
	}
}
