//package com.weixin.controller.reply;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.annotation.Resource;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.io.IOUtils;
//import org.apache.log4j.Logger;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import com.fh.controller.base.BaseController;
//import com.fh.entity.Page;
//import com.fh.util.AppUtil;
//import com.fh.util.ObjectExcelView;
//import com.fh.util.PageData;
//import com.fh.util.Jurisdiction;
//import com.fh.util.Tools;
//import com.weixin.service.reply.ReplyManager;
//import com.weixin.entity.ClickText;
//import com.weixin.entity.Item;
//import com.weixin.entity.RequestTextMessage;
//import com.weixin.util.ReplyMessage;
//import com.weixin.util.SHA1;
///** 
// * 说明：微信回复事件
// * 创建人：千派网络  www.qanpai.com
// * 创建时间：2017-04-10
// */
//@Controller
//@RequestMapping(value="/reply")
//public class ReplyController extends BaseController {
//	private String TOKEN = "yqkj";
//	private static final Logger log =Logger.getLogger(ReplyController.class);
//	String menuUrl = "reply/list.do"; //菜单地址(权限用)
//	@Resource(name="replyService")
//	private ReplyManager replyService;
//	
//	
//	@RequestMapping(value = "reply.html")
//	public void repaly(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		checkToken(request, response); //仅在认证微信开发者模式时调用一次即可
//		try {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//		String wxMsgXml =IOUtils.toString(request.getInputStream(), "utf-8");
//		log.info("获取的数据信息>>>>>"+wxMsgXml);
//		PageData pd = new PageData();
//		boolean eventType =wxMsgXml.contains("Event") ;// 如果包含，则是触发事件
//		RequestTextMessage textMsg =null ;
//		String returnXml = null;
//		StringBuffer replyMsg = new StringBuffer();
//		if(!eventType){ //信息交互事件
//			textMsg = ReplyMessage.getRequestTextMessage(wxMsgXml);
//			String receive = textMsg.getContent().trim();
//			pd.put("key", receive);
//			PageData clickText = replyService.findById(pd);
//			String type = clickText.getString("type");
//			String content = clickText.getString("content");
//			String intro = clickText.getString("intro");
//			String title = clickText.getString("title");
//			String pic_url = clickText.getString("pic_url");
//			String url = clickText.getString("url");
//			if (type.equals(1)) {
//				replyMsg.append(content);
//				returnXml = ReplyMessage.getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
//						textMsg.getToUserName());
//			}else if(type.equals(2)){
//				List<Item> articleList = new ArrayList<>();
//				Item item = null ;
//				if(intro.contains("-=")){//多条图文信息
//					String[] titles =  title.split("-=");
//					String[] intros =  intro.split("-=");
//					String[] pic_urls =  pic_url.split("-=");
//					String[] urls =  url.split("-=");
//					for(int i =0 ; i < titles.length; i++){
//						item = new Item();
//						item.setTitle(titles[i]); //标题
//				        item.setDescription(intros[i]);//介绍
//				        item.setPicUrl(pic_urls[i]);	//图片链接
//				        item.setUrl(urls[i]);        //链接指向
//				        articleList.add(item);
//					}
//				}else{ //单条图文信息
//					item = new Item();
//					item.setTitle(title); //标题
//			        item.setDescription(intro);//介绍
//			        item.setPicUrl(pic_url);	//图片链接
//			        item.setUrl(url);        //链接指向
//			        articleList.add(item);
//				}
//				returnXml = ReplyMessage.getReplyTuwenMessage(textMsg.getFromUserName(), textMsg.getToUserName(),articleList);
//			}
//		}else{
//			textMsg = ReplyMessage.getRequestFocus(wxMsgXml);
//			if(textMsg.getEvent().equals("subscribe")){ //关注事件
//				pd.put("key", "subscribe");
//				PageData clickText = replyService.findById(pd);
//				String content = clickText.getString("content");
//				replyMsg.append(content);
//				log.info("关注回复->"+content);
//				returnXml = 
//						ReplyMessage.getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
//						textMsg.getToUserName());
//			}
//		}
//		
//		log.info("wxMsgXml>>>>>>>>>>>>>>"+wxMsgXml);
//		log.info("returnXml>>>>>>>>>>>>>>"+returnXml);
//		pw.println(returnXml);
//		
//		} 
//		catch (Exception e) {
//			log.info(e.getMessage());
//		}
//	}
//	
//	/**
//	 * 微信token认证，使用时调用
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws IOException
//	 */
//	
//	public void checkToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		// 微信加密签名
//		String signature = request.getParameter("signature");
//		// 随机字符串
//		String echostr = request.getParameter("echostr");
//		// 时间戳
//		String timestamp = request.getParameter("timestamp");
//		// 随机数
//		String nonce = request.getParameter("nonce");
//
//		String[] str = { TOKEN, timestamp, nonce };
//		Arrays.sort(str); // 字典序排序
//		String bigStr = str[0] + str[1] + str[2];
//		// SHA1加密
//		String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
//
//		// 确认请求来至微信
//		if (digest.equals(signature)) {
//			response.getWriter().print(echostr);
//		}
//	}
//	
//	
//	
//	/**保存
//	 * @param
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/save")
//	public ModelAndView save() throws Exception{
//		logBefore(logger, Jurisdiction.getUsername()+"新增Reply");
//		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
//		ModelAndView mv = this.getModelAndView();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		pd.put("reply_id", this.get32UUID());	//主键
//		replyService.save(pd);
//		mv.addObject("msg","success");
//		mv.setViewName("save_result");
//		return mv;
//	}
//	
//	/**删除
//	 * @param out
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/delete")
//	public void delete(PrintWriter out) throws Exception{
//		logBefore(logger, Jurisdiction.getUsername()+"删除Reply");
//		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		replyService.delete(pd);
//		out.write("success");
//		out.close();
//	}
//	
//	/**修改
//	 * @param
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/edit")
//	public ModelAndView edit() throws Exception{
//		logBefore(logger, Jurisdiction.getUsername()+"修改Reply");
//		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
//		ModelAndView mv = this.getModelAndView();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		replyService.edit(pd);
//		mv.addObject("msg","success");
//		mv.setViewName("save_result");
//		return mv;
//	}
//	
//	/**列表
//	 * @param page
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/list")
//	public ModelAndView list(Page page) throws Exception{
//		logBefore(logger, Jurisdiction.getUsername()+"列表Reply");
//		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
//		ModelAndView mv = this.getModelAndView();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		String keywords = pd.getString("keywords");				//关键词检索条件
//		if(null != keywords && !"".equals(keywords)){
//			pd.put("keywords", keywords.trim());
//		}
//		page.setPd(pd);
//		List<PageData>	varList = replyService.list(page);	//列出Reply列表
//		mv.setViewName("reply/reply_list");
//		mv.addObject("varList", varList);
//		mv.addObject("pd", pd);
//		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
//		return mv;
//	}
//	
//	/**去新增页面
//	 * @param
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/goAdd")
//	public ModelAndView goAdd()throws Exception{
//		ModelAndView mv = this.getModelAndView();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		mv.setViewName("reply/reply_edit");
//		mv.addObject("msg", "save");
//		mv.addObject("pd", pd);
//		return mv;
//	}	
//	
//	 /**去修改页面
//	 * @param
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/goEdit")
//	public ModelAndView goEdit()throws Exception{
//		ModelAndView mv = this.getModelAndView();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		pd = replyService.findById(pd);	//根据ID读取
//		mv.setViewName("reply/reply_edit");
//		mv.addObject("msg", "edit");
//		mv.addObject("pd", pd);
//		return mv;
//	}	
//	
//	 /**批量删除
//	 * @param
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/deleteAll")
//	@ResponseBody
//	public Object deleteAll() throws Exception{
//		logBefore(logger, Jurisdiction.getUsername()+"批量删除Reply");
//		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
//		PageData pd = new PageData();		
//		Map<String,Object> map = new HashMap<String,Object>();
//		pd = this.getPageData();
//		List<PageData> pdList = new ArrayList<PageData>();
//		String DATA_IDS = pd.getString("DATA_IDS");
//		if(null != DATA_IDS && !"".equals(DATA_IDS)){
//			String ArrayDATA_IDS[] = DATA_IDS.split(",");
//			replyService.deleteAll(ArrayDATA_IDS);
//			pd.put("msg", "ok");
//		}else{
//			pd.put("msg", "no");
//		}
//		pdList.add(pd);
//		map.put("list", pdList);
//		return AppUtil.returnObject(pd, map);
//	}
//	
//	 /**导出到excel
//	 * @param
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/excel")
//	public ModelAndView exportExcel() throws Exception{
//		logBefore(logger, Jurisdiction.getUsername()+"导出Reply到excel");
//		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
//		ModelAndView mv = new ModelAndView();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		Map<String,Object> dataMap = new HashMap<String,Object>();
//		List<String> titles = new ArrayList<String>();
//		titles.add("关键词");	//1
//		titles.add("类型");	//2
//		titles.add("回复内容");	//3
//		titles.add("标题");	//4
//		titles.add("简介");	//5
//		titles.add("图片");	//6
//		titles.add("链接");	//7
//		dataMap.put("titles", titles);
//		List<PageData> varOList = replyService.listAll(pd);
//		List<PageData> varList = new ArrayList<PageData>();
//		for(int i=0;i<varOList.size();i++){
//			PageData vpd = new PageData();
//			vpd.put("var1", varOList.get(i).getString("key"));	//1
//			vpd.put("var2", varOList.get(i).getString("type"));	//2
//			vpd.put("var3", varOList.get(i).getString("content"));	//3
//			vpd.put("var4", varOList.get(i).getString("title"));	//4
//			vpd.put("var5", varOList.get(i).getString("intro"));	//5
//			vpd.put("var6", varOList.get(i).getString("pic_url"));	//6
//			vpd.put("var7", varOList.get(i).getString("url"));	//7
//			varList.add(vpd);
//		}
//		dataMap.put("varList", varList);
//		ObjectExcelView erv = new ObjectExcelView();
//		mv = new ModelAndView(erv,dataMap);
//		return mv;
//	}
//	
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
//	}
//}
