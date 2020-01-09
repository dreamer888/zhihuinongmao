package com.weixin.controller.button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.AppUtil;
import org.change.util.PageData;
import com.google.gson.Gson;
import com.fh.util.Jurisdiction;
import com.weixin.service.button.ButtonManager;
import com.weixin.util.MenuUtil;
/** 
 * 说明：微信菜单
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-04-10
 */
@Controller
@RequestMapping(value="/button")
public class ButtonController extends BaseController {
	
	String menuUrl = "button/list.do"; //菜单地址(权限用)
	@Resource(name="buttonService")
	private ButtonManager buttonService;
	Map<String,Object> map = new HashMap<String, Object>();
	Gson gson = new Gson();
	/**保存
	 * @param
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping(value="/save", produces = "application/json;charset=UTF-8")
	public String insert() throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		String message="";
		int rs  =0;
		int count=0;
		String button_id = this.get32UUID();
		if(pd.getString("level").equals("1")){
			pd.put("super_id", "");
			count =	buttonService.selectCount(pd);//查詢主菜单个数
			if(count>=3){
				message="主菜单已满3个啦";
			}
			else{
				pd.put("button_id", button_id);
				pd.put("super_id", button_id);
				rs  =	buttonService.save(pd);
			}
		}else{
			String super_id = pd.getString("super_id");
			pd.put("super_id", "");
			count =	buttonService.selectCount(pd);
			if(count>=5){
				message="子菜单已满5个啦";
			}else{
				pd.put("button_id", button_id);
				pd.put("super_id", super_id);
				rs  =	buttonService.save(pd);
			}
		}
		if(rs==-1){
			message="提交失败!";
		}
		map.put("rs",rs);
		map.put("message",message);
		return gson.toJson(map);
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/delete", produces = "application/json;charset=UTF-8")
	public String delete() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Button");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){ return "";} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		int  rs  = 0 ;
		String message="";
		if(pd.getString("level").equals("1")){
			pd.put("level", 2);
			pd.put("super_id", pd.getString("button_id"));
			if(buttonService.selectCount(pd)>0){
				rs = -5 ;
				message = "此主菜单下有子菜单，请先删除该下子菜单!";
			}else{
				rs  =	buttonService.delete(pd);
			}
		}else{
			rs  =	buttonService.delete(pd);
		}
		
		if(rs==-1){
			message = "删除失败!";
		}
		map.put("rs",rs);
		map.put("message",message);
		return gson.toJson(map);
	}
	/**
	 * 生成菜单
	 * @param button
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/creatmenu", produces = "application/json;charset=UTF-8")
	public String creatmenu() throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("level", 1);
		List<PageData> mainBtn = buttonService.listAll(pd);
		
		Map<String,Object> map = new HashMap<String, Object>();
		for(int i = 0;i < mainBtn.size();i++){
			PageData bpd = new PageData();
			bpd.put("level", 2);
			bpd.put("super_id", mainBtn.get(i).getString("button_id"));
			List<PageData> btn = buttonService.listAll(bpd);
			List<Object> vl = new ArrayList<Object>();
			if(btn.size()==0){
				mainBtn.get(i).put("url",mainBtn.get(i).getString("value"));
			}
			else{
			for(int m = 0;m < btn.size();m++){
			if(btn.get(m).getString("type").equals("view")){
				//ViewButton vb = new ViewButton();
				PageData vb = new PageData();
				vb.put("name",btn.get(m).getString("name"));
				vb.put("type",btn.get(m).getString("type"));
				vb.put("url",btn.get(m).getString("value"));
				vl.add(vb);
				}
			}
			mainBtn.get(i).put("sub_button", vl);
			}
		}
		map.put("button",mainBtn);
		return gson.toJson(MenuUtil.createMenu(map));
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/edit", produces = "application/json;charset=UTF-8")
	public String edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Button");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		String message="";
		int rs  =0;
		int count=0;
		String button_id = pd.getString("button_id");
		if(pd.getString("level").equals("1")){
			pd.put("super_id", "");
			count =	buttonService.selectCount(pd);//查詢主菜单个数
			if(count>=3){
				message="主菜单已满3个啦";
			}
			else{
				//pd.put("button_id", button_id);
				pd.put("super_id", button_id);
				rs  =	buttonService.edit(pd);
			}
		}else{
			//String super_id = pd.getString("super_id");
			//pd.put("super_id", button_id);
			count =	buttonService.selectCount(pd);
			if(count>=5){
				message="子菜单已满5个啦";
			}else{
				//pd.put("button_id", button_id);
				//pd.put("super_id", super_id);
				rs  =	buttonService.edit(pd);
			}
		}
		if(rs==-1){
			message="提交失败!";
		}
		map.put("rs",rs);
		map.put("message",message);
		return gson.toJson(map);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Button");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("level", 1);
		List<PageData> mainBtn = buttonService.listAll(pd);
		pd.put("level", 2);
		for(int i = 0;i < mainBtn.size();i++){
			String super_id =  mainBtn.get(i).getString("button_id");
			pd.put("super_id",super_id);
			List<PageData> btn = buttonService.listAll(pd);
			map.put("btn"+i, btn);
		}
		map.put("mainBtn", mainBtn);
		mv.addObject("map",map);
		mv.setViewName("weixin/button/list");
		mv.addObject("qx",Jurisdiction.getHC());	//按钮权限
		return  mv ;
	
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("level", 1);
		List<PageData> mainBtn = buttonService.listAll(pd);
		mv.setViewName("weixin/button/content");
		mv.addObject("msg", "save");
		mv.addObject("mainBtn", mainBtn);
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData button = buttonService.findById(pd);	//根据ID读取
		pd.put("level", 1);
		List<PageData> mainBtn = buttonService.listAll(pd);
		mv.setViewName("weixin/button/content");
		mv.addObject("msg", "edit");
		mv.addObject("mainBtn", mainBtn);
		mv.addObject("pd", pd);
		mv.addObject("button", button);
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Button");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			buttonService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
}
