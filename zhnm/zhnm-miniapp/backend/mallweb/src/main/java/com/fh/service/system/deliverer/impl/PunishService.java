package com.fh.service.system.deliverer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.deliverer.PunishManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Service("punishService")
public class PunishService  implements PunishManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listDelivererPs(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("PunishMapper.PunishlistPage", page);
	}
}
