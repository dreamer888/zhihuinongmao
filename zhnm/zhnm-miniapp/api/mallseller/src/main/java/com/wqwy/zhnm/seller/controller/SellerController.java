/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.component.SellerCategoryNameComponent;
import com.wqwy.zhnm.base.component.component.SellerGoodsComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.ForgotPasswordRequest;
import com.wqwy.zhnm.base.component.request.SellerLoginRequest;
import com.wqwy.zhnm.base.component.request.SellerRegisterRequest;
import com.wqwy.zhnm.base.component.response.SellerDetailResponse;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.StringUtil;
import com.wqwy.zhnm.base.component.utils.ValidateUtils;
import com.wqwy.zhnm.base.entity.Balance;
import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.entity.Seller;
import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.entity.SellerBankAccount;
import com.wqwy.zhnm.base.entity.SellerDynamic;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.entity.ShopCategory;
import com.wqwy.zhnm.base.entity.ShopGoods;
import com.wqwy.zhnm.base.entity.ValidateCode;
import com.wqwy.zhnm.base.service.BalanceService;
import com.wqwy.zhnm.base.service.MarketService;
import com.wqwy.zhnm.base.service.SellerBalanceService;
import com.wqwy.zhnm.base.service.SellerBankAccountService;
import com.wqwy.zhnm.base.service.SellerDynamicService;
import com.wqwy.zhnm.base.service.SellerGoodsService;
import com.wqwy.zhnm.base.service.SellerService;
import com.wqwy.zhnm.base.service.ShopCategoryService;
import com.wqwy.zhnm.base.service.ShopGoodsService;
import com.wqwy.zhnm.base.service.ValidateCodeService;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;
import com.wqwy.zhnm.seller.annotation.CurrentUser;
import com.wqwy.zhnm.seller.base.BaseController;

/**
 * createTime: 2018-05-08 18:51:02
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class SellerController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);
	
	@Autowired
	private ValidateCodeService validateCodeService;
	
	@Autowired
	private SellerService  sellerService;
	
	@Autowired
	private SellerDynamicService  sellerDynamicService;
	
	@Autowired
	private SellerBalanceService  sellerBalanceService;
	
	@Autowired
	private BalanceService  balanceService;
	
	@Autowired
	private SellerGoodsService  sellerGoodsService;
	
	@Autowired
	private ShopGoodsService  shopGoodsService;
	
	@Autowired
	private ShopCategoryService  shopCategoryService;
	
	@Autowired
	private MarketService marketService;
	
	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService;
	
	@Autowired
	private SellerBankAccountService  sellerBankAccountService;
	

	/**
	 * 
	 * @Title: loginByQRCode  
	 * @Description: 商户端扫码登录或者绑定称  
	 * @date 14 May 2018 2:18:57 PM  
	 * @param @param loginComponent
	 * @param @return  
	 * @return JsonResponse<?>  
	 * @throws
	 */
	/*
	 * 商户端扫码 登录 or 绑定 称
	 */
	/*
	 * 称: 称在打开扫码登录二维码后，会 在一定的时间范围内 subscribe MQ 对应的队列(队列在未登录状态不会存在)
	 * 
	 * 商户: 商户扫码成功后，接口会返回结果(可登录success 或 不可登录fail);
	 * 	在return之前会创建一个queue在MQ中(如果queue不存在)，并将登录结果放入queue 后 return
	 */
	@RequestMapping(value="loginByQRCode", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> loginByQRCode(@RequestBody SellerLoginRequest loginComponent) {
		logger.info("loginComponent: " + loginComponent.toString());
		if (loginComponent.getSellerId()==null || loginComponent.getBalanceId()==null)
			throw new BusinessException();
		SellerBalance sb1 = new SellerBalance();
		sb1.setSellerId(loginComponent.getSellerId());
		List<SellerBalance> sbList1 = sellerBalanceService.findList(sb1);
		if (sbList1==null || sbList1.isEmpty()) {
			SellerBalance sb2 = new SellerBalance();
			sb2.setBalanceId(loginComponent.getBalanceId());
			List<SellerBalance> sbList2 = sellerBalanceService.findList(sb2);
			if (sbList2==null || sbList2.isEmpty()) {
				//do binding
				//1.add sellerBalance
				SellerBalance sbToBind = new SellerBalance();
				sbToBind.setSellerId(loginComponent.getSellerId());
				sbToBind.setBalanceId(loginComponent.getBalanceId());
				sellerBalanceService.insert(sbToBind);
				//2.balance change to used
				Balance b = new Balance();
				b.setId(loginComponent.getBalanceId());
				b.setUsed(DefaultConstants.BalanceEnum.USED.getBalanceEnum());
				balanceService.update(b);
			} else {
				throw new BusinessException(ResultUtils.BALANCE_ALREADY_BINDED_SELLER, ResultUtils.BALANCE_ALREADY_BINDED_SELLER_MSG);//balance binded a seller
			}
		} else {
			sb1 = sbList1.get(0);
			if (!loginComponent.getBalanceId().equals(sb1.getBalanceId())) {
				throw new BusinessException(ResultUtils.SELLER_ALREADY_BINDED_BALANCE, ResultUtils.SELLER_ALREADY_BINDED_BALANCE_MSG);//seller binded a balance
			} else {
				//do login
			}
		}
		/*
		 * 1.封装返回response
		 * 2.创建queue并将结果返回
		 */
		/*
		 * 1
		 */
		SellerDetailResponse sellerDetailComponent = new SellerDetailResponse();
		Seller seller = sellerService.get(loginComponent.getSellerId().toString());
		//制空密码
		seller.setPassword(null);
		//商户品类名称
		ShopCategory sc = new ShopCategory();
		sc = shopCategoryService.get(seller.getSellerCategory());
		//商户所属菜市场名称
		Market m = marketService.get(seller.getBelongMarket().toString());
		SellerCategoryNameComponent scnc = new SellerCategoryNameComponent();
		BeanUtils.copyProperties(seller, scnc);
		scnc.setCategoryName(sc.getCategoryName());
		scnc.setMarketName(m.getMarketName());
		Balance balance = balanceService.get(loginComponent.getBalanceId().toString());
		
		SellerDynamic sellerDynamic = new SellerDynamic();
		sellerDynamic.setSellerId(seller.getId());
		List<SellerDynamic> sdList = sellerDynamicService.findList(sellerDynamic);
		if (sdList != null && !sdList.isEmpty())
			sellerDynamic = sdList.get(0);
		
		//商户的商品列表 
		//TODO	登录后返回商户的商品信息到称
		SellerGoods sellerGoods = new SellerGoods();
		sellerGoods.setSellerId(seller.getId());
		List<SellerGoods> sgList = sellerGoodsService.findList(sellerGoods);
		List<SellerGoodsComponent> sgcList = new ArrayList<SellerGoodsComponent>();
		sgList.forEach(sg -> {
			SellerGoodsComponent sgc = new SellerGoodsComponent();
			BeanUtils.copyProperties(sg, sgc);
			ShopGoods shopG = shopGoodsService.get(sg.getGoodsId().toString());//TODO 缓存
			sgc.setShopGoods(shopG);
			sgcList.add(sgc);
		});
		sellerDetailComponent.setSeller(scnc);
		sellerDetailComponent.setSellerDynamic(sellerDynamic);
		sellerDetailComponent.setBalance(balance);
		sellerDetailComponent.setSellerGoodsList(sgcList);
		
		//追加支付方式返回
		SellerBankAccount account = new SellerBankAccount();
		account.setSellerId(seller.getId());
		List<SellerBankAccount> acclist = sellerBankAccountService.findList(account);
		
		SellerBankAccount sellerBankAccount = new SellerBankAccount();
		if(null!=acclist && !acclist.isEmpty()) {
		    sellerBankAccount = acclist.get(0);
		}
		
		if(null!=sellerBankAccount) {
			if(StringUtil.isValid(sellerBankAccount.getPublickey())) {
				sellerDetailComponent.setPayWay(DefaultConstants.BalanceOfflineOrderEnum.PAY_WAY_CCB_DRAGON.getBalanceOfflineOrderEnum());
			}else {
				if(StringUtil.isValid(sellerBankAccount.getStaticcode())) {
					sellerDetailComponent.setPayWay(DefaultConstants.BalanceOfflineOrderEnum.PAY_WAY_CCB_STATIC.getBalanceOfflineOrderEnum());
				}
			}
			
		}
		
		/*
		 * 2
		 */
		rabbitMQAsyncJobService.doSendRegisterOrLoginMessage(sellerDetailComponent);

		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerDetailComponent);
	}
	
	/**
	 * 
	 * @Title: login  
	 * @Description: 商户终端&称终端 的 帐号密码登录 操作  
	 * @date 14 May 2018 1:48:58 PM  
	 * @param @param loginComponent
	 * @param @return  
	 * @return JsonResponse<SellerDetailResponse>  
	 * @throws
	 */
	/*
	 * 接口无token校验
	 */
	@RequestMapping(value="login", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerDetailResponse> login(@RequestBody SellerLoginRequest loginComponent) {
		logger.info("loginComponent: " + loginComponent.toString());
		Seller seller = new Seller();
		seller.setAccount(loginComponent.getAccount());
		List<Seller> sList = sellerService.findList(seller);
		if (sList == null || sList.isEmpty())
			throw new BusinessException(ResultUtils.ACCOUNT_NOT_EXIST, ResultUtils.ACCOUNT_NOT_EXIST_MSG);
		if (!loginComponent.getPassword().equals(sList.get(0).getPassword()))
			throw new BusinessException(ResultUtils.PASSWORD_WRONG, ResultUtils.PASSWORD_WRONG_MSG);
		seller = sList.get(0);
		//商户终端登录后修改token并把新的token返回客户端
//		if (DefaultConstants.LoginEnum.ROLE_SELLER.getLoginEnum().equals(loginComponent.getRole())) {
//			String token = ValidateUtils.GetToken(loginComponent.getAccount(), loginComponent.getPassword());
//			seller.setToken(token);
//			sellerService.update(seller);
//		}
		//制空密码
		seller.setPassword(null);
		
		//商户品类名称
		ShopCategory sc = new ShopCategory();
		sc = shopCategoryService.get(seller.getSellerCategory());
		//商户所属菜市场名称
		Market m = marketService.get(seller.getBelongMarket().toString());
		SellerCategoryNameComponent scnc = new SellerCategoryNameComponent();
		BeanUtils.copyProperties(seller, scnc);
		scnc.setCategoryName(sc.getCategoryName());
		scnc.setMarketName(m.getMarketName());
		
		//商户动态数据
		SellerDetailResponse sellerDetailComponent = new SellerDetailResponse();
		SellerDynamic sellerDynamic = new SellerDynamic();
		sellerDynamic.setSellerId(seller.getId());
		List<SellerDynamic> sdList = sellerDynamicService.findList(sellerDynamic);
		if (sdList != null && !sdList.isEmpty())
			sellerDynamic = sdList.get(0);
		
		//商户的称
		Balance balance = new Balance();
		SellerBalance sellerBalance = new SellerBalance();
		sellerBalance.setSellerId(seller.getId());
		List<SellerBalance> sbList = sellerBalanceService.findList(sellerBalance);
		if (sbList != null && !sbList.isEmpty()) {
			//商户有称
			sellerBalance = sbList.get(0);
			balance = balanceService.get(sellerBalance.getBalanceId().toString());
		}
		
		//Imei没有绑定当前商户号，则提示
		if(StringUtil.isValid(loginComponent.getRole()) && loginComponent.getRole()==0 && StringUtil.isValid(loginComponent.getAndroidIMEI())) {
			if(balance==null) {
				throw new BusinessException(ResultUtils.BALANCE_ALREADY_BINDED_SELLER, ResultUtils.BALANCE_ALREADY_BINDED_SELLER_MSG);
			}
			if(!balance.getBalanceImei().equals(loginComponent.getAndroidIMEI())) {
				throw new BusinessException(ResultUtils.BALANCE_ALREADY_BINDED_SELLER, ResultUtils.BALANCE_ALREADY_BINDED_SELLER_MSG);
			}
		}
		
		//商户的商品列表 
		//TODO	登录后返回商户的商品信息到称
		SellerGoods sellerGoods = new SellerGoods();
		sellerGoods.setSellerId(seller.getId());
		List<SellerGoods> sgList = sellerGoodsService.findList(sellerGoods);
		List<SellerGoodsComponent> sgcList = new ArrayList<SellerGoodsComponent>();
		sgList.forEach(sg -> {
			SellerGoodsComponent sgc = new SellerGoodsComponent();
			BeanUtils.copyProperties(sg, sgc);
			ShopGoods shopG = shopGoodsService.get(sg.getGoodsId().toString());//TODO 缓存
			sgc.setShopGoods(shopG);
			sgcList.add(sgc);
		});
		
		sellerDetailComponent.setSeller(scnc);
		sellerDetailComponent.setSellerDynamic(sellerDynamic);
		sellerDetailComponent.setBalance(balance);
		sellerDetailComponent.setSellerGoodsList(sgcList);
		
		//追加支付方式返回
		SellerBankAccount account = new SellerBankAccount();
		account.setSellerId(seller.getId());
		List<SellerBankAccount> acclist = sellerBankAccountService.findList(account);
		
		SellerBankAccount sellerBankAccount = new SellerBankAccount();
		if(null!=acclist && !acclist.isEmpty()) {
		    sellerBankAccount = acclist.get(0);
		}
		
		if(null!=sellerBankAccount) {
			if(StringUtil.isValid(sellerBankAccount.getPublickey())) {
				sellerDetailComponent.setPayWay(DefaultConstants.BalanceOfflineOrderEnum.PAY_WAY_CCB_DRAGON.getBalanceOfflineOrderEnum());
			}else {
				if(StringUtil.isValid(sellerBankAccount.getStaticcode())) {
					sellerDetailComponent.setPayWay(DefaultConstants.BalanceOfflineOrderEnum.PAY_WAY_CCB_STATIC.getBalanceOfflineOrderEnum());
				}
			}
			
		}
		
		return new JsonResponse<SellerDetailResponse>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerDetailComponent);
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:02
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param seller
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<Seller>>
	 * @throws
	 */
	@RequestMapping(value="sellers", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<Seller>> findByPage(Seller seller, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<Seller> queryResultList = sellerService.findListByPage(seller, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<Seller>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:02
	 * @Title: findSellerDetail 
	 * @Description: TODO
	 * @param @param seller
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Seller>
	 * @throws
	 */
	@RequestMapping(value="sellers/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Seller> findSellerDetail(@PathVariable("id")Integer id, Seller seller, HttpServletRequest request){
		seller = sellerService.get(id.toString());
		return new JsonResponse<Seller>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, seller);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:02
	 * @Title: modifySellerDetail 
	 * @Description: 商户基本信息修改
	 * @param @param id
	 * @param @param seller
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Seller>
	 * @throws
	 */
	@RequestMapping(value="sellers/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Seller> modifySellerDetail(@PathVariable("id")Integer id, @RequestBody Seller seller, HttpServletRequest request){
		seller.setId(id);
		sellerService.update(seller);
		return new JsonResponse<Seller>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @Title: modifySellerDetail  
	 * @Description: 修改密码  
	 * @date 26 May 2018 10:33:37 AM  
	 * @param @param id
	 * @param @param forgotPasswordRequest
	 * @param @param request
	 * @param @return  
	 * @return JsonResponse<Seller>  
	 * @throws
	 */
	@RequestMapping(value="sellers/password", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Seller> modifySellerDetail(@RequestBody ForgotPasswordRequest forgotPasswordRequest, HttpServletRequest request){
		Seller seller = new Seller();
		seller.setAccount(forgotPasswordRequest.getPhone());
		List<Seller> sList = sellerService.findList(seller);
		if (sList==null || sList.isEmpty())
			throw new BusinessException(ResultUtils.ACCOUNT_NOT_EXIST, ResultUtils.ACCOUNT_NOT_EXIST_MSG);
		seller = sList.get(0);
		// 不是当前用户(token -> user -> account != forgotPasswordRequest.phone)
//		if (!seller.getAccount().equals(forgotPasswordRequest.getPhone()))
//			throw new BusinessException(ResultUtils.NOT_SELF_ACCOUNT, ResultUtils.NOT_SELF_ACCOUNT_MSG);
		ValidateCode vc = new ValidateCode();
		BeanUtils.copyProperties(forgotPasswordRequest, vc);
		vc.setCode(null);
		List<ValidateCode> vcList = validateCodeService.findList(vc);
		// 并未发送验证码
		if (vcList==null || vcList.isEmpty())
			throw new BusinessException(ResultUtils.NO_VERIFYCODE_AVALIABLE, ResultUtils.NO_VERIFYCODE_AVALIABLE_MSG);
		vc = vcList.get(0);
		// code错误
		if (!vc.getCode().equals(forgotPasswordRequest.getCode()))
			throw new BusinessException(ResultUtils.VERIFYCODE_FAIL, ResultUtils.VERIFYCODE_FAIL_MSG);
		// 验证码超时
		if (vc.getSendTime().getTime() + DefaultConstants.VALIDATE_CODE_VALID_TIME < new Date().getTime())
			throw new BusinessException(ResultUtils.VERIFYCODE_TIME_OUT, ResultUtils.VERIFYCODE_TIME_OUT_MSG);
		
		/*
		 * 修改密码
		 */
		seller.setPassword(forgotPasswordRequest.getPassword());
		String token = ValidateUtils.GetToken(forgotPasswordRequest.getPhone(), forgotPasswordRequest.getPassword());
		seller.setToken(token);
		sellerService.update(seller);
		return new JsonResponse<Seller>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:02
	 * @Title: addSeller 
	 * @Description: 商户注册
	 * @param @param seller
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Seller>
	 * @throws
	 */
	@RequestMapping(value="register", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerDetailResponse> addSeller(@RequestBody SellerRegisterRequest seller, HttpServletRequest request){
		/*
		 * validateCode校验
		 */
		ValidateCode vc = new ValidateCode();
		vc.setPhone(seller.getAccount());
		vc.setOperationType(seller.getOperationType());
		vc.setUserType(seller.getUserType());
		List<ValidateCode> vcList = validateCodeService.findList(vc);
		// 并未发送验证码
		if (vcList==null || vcList.isEmpty())
			throw new BusinessException(ResultUtils.NO_VERIFYCODE_AVALIABLE, ResultUtils.NO_VERIFYCODE_AVALIABLE_MSG);
		vc = vcList.get(0);
		// code错误
		if (!vc.getCode().equals(seller.getValidateCode()))
			throw new BusinessException(ResultUtils.VERIFYCODE_FAIL, ResultUtils.VERIFYCODE_FAIL_MSG);
		// 验证码超时
		if (vc.getSendTime().getTime() + DefaultConstants.BANK_VALIDATE_CODE_VALID_TIME < new Date().getTime())
			throw new BusinessException(ResultUtils.VERIFYCODE_TIME_OUT, ResultUtils.VERIFYCODE_TIME_OUT_MSG);
		
		return new JsonResponse<SellerDetailResponse>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerService.insert(seller));
	}
	
//	/**
//	 * 
//	 * @date 2018-05-08 18:51:02
//	 * @Title: removeSeller 
//	 * @Description: TODO
//	 * @param @param id
//	 * @param @param request
//	 * @param @return
//	 * @return JsonResponse<>
//	 * @throws
//	 */
//	@RequestMapping(value="sellers/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
//	public JsonResponse<?> removeSeller(@PathVariable("id")Integer id, HttpServletRequest request){
//		sellerService.delete(id.toString());
//		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
//	}
	
}
