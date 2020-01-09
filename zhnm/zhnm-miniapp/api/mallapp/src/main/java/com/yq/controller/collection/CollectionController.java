package com.yq.controller.collection;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yq.service.collection.CollectionManager;
import com.yq.service.goods.GoodsManager;
import com.yq.util.DatetimeUtil;
import com.yq.util.StringUtil;

/** 
 * 说明：商品收藏
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-05-11
 */
@Controller
@RequestMapping(value="/collection")
public class CollectionController extends BaseController {
	
	String menuUrl = "collection/list.do"; //菜单地址(权限用)
	@Resource(name="collectionService")
	private CollectionManager collectionService;
	@Resource(name="goodsService")
	private GoodsManager goodsService;
	private Gson gson = new Gson();
	/**保存
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/add",produces = "application/json;charset=UTF-8")
	public String add() throws Exception{
		int result = 0;
		String message = "";
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", shopUser.get("user_id"));	
		//未收藏此商品
		if(collectionService.findById(pd)==null){
		PageData goods = goodsService.findById(pd);
		String pic =goods.getString("goods_pic");
		if(StringUtils.isNotEmpty(pic)){
			if(pic.contains(",")){
				pic = pic.split(",")[0];
			}
		}
		goods.put("goods_pic", pic);
		
		pd.put("collection_id", this.get32UUID());	//主键
		pd.put("goods_pic", pic);
		pd.put("goods_price", (BigDecimal)goods.get("goods_price"));
		pd.put("goods_name", goods.get("goods_name"));
		pd.put("addtime", DatetimeUtil.getDatetime());
		collectionService.save(pd);
		result = 1;
		message = "收藏成功";
		}
		}catch(Exception e){
			message = "收藏失败";
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/delete",produces = "application/json;charset=UTF-8")
	public String delete() throws Exception{
		int result = 0;
		String message = "";
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", shopUser.get("user_id"));	
		collectionService.delete(pd);
		result = 1;
		message = "取消收藏";
		
		}
		catch(Exception e){
			message = "提交失败";
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}
	
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/list",produces = "application/json;charset=UTF-8")
	public String list(Page page) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object>  shopUser = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", shopUser.get("user_id"));	
		page.setPd(pd);
		List<PageData>	list = collectionService.list(page);	//列出Collection列表
		map.put("list", list);
		map.put("page", page);
		return gson.toJson(map);
	}
	
	/**去列表页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/tolist")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("collection/list");
		mv.addObject("msg", "save");
		return mv;
	}	
}
