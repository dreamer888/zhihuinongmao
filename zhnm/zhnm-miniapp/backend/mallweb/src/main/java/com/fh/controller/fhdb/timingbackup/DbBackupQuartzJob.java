package com.fh.controller.fhdb.timingbackup;

import java.util.Date;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import org.change.controller.base.BaseController;
import com.fh.service.fhdb.brdb.impl.BRdbService;
import com.fh.service.fhdb.timingbackup.impl.TimingBackUpService;
import com.fh.util.DbFH;
import com.fh.util.FileUtil;
import org.change.util.PageData;
import org.change.util.Tools;

/** quartz 瀹氭椂浠诲姟璋冨害 鏁版嵁搴撹嚜鍔ㄥ浠藉伐浣滃煙

 * @date 2016-4-10
 */
public class DbBackupQuartzJob extends BaseController implements Job{

	@SuppressWarnings("unchecked")
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		Map<String,Object> parameter = (Map<String,Object>)dataMap.get("parameterList");	//鑾峰彇鍙傛暟
		String TABLENAME = parameter.get("TABLENAME").toString();
		TABLENAME = TABLENAME.equals("all")?"":TABLENAME;
		
		//鏅�氱被浠巗pring瀹瑰櫒涓嬁鍑簊ervice
		WebApplicationContext webctx=ContextLoader.getCurrentWebApplicationContext();
		BRdbService brdbService = (BRdbService)webctx.getBean("brdbService");
		PageData pd = new PageData();
		try {
			String kackupPath = DbFH.getDbFH().backup(TABLENAME).toString();//璋冪敤鏁版嵁搴撳浠�
			if(Tools.notEmpty(kackupPath) && !"errer".equals(kackupPath)){
				pd.put("FHDB_ID", this.get32UUID());						//涓婚敭
				pd.put("USERNAME", "绯荤粺");									//鎿嶄綔鐢ㄦ埛
				pd.put("BACKUP_TIME", Tools.date2Str(new Date()));			//澶囦唤鏃堕棿
				pd.put("TABLENAME", TABLENAME.equals("")?"鏁村簱":TABLENAME);	//琛ㄥ悕or鏁村簱
				pd.put("SQLPATH", kackupPath);								//瀛樺偍浣嶇疆
				pd.put("DBSIZE", FileUtil.getFilesize(kackupPath));			//鏂囦欢澶у皬
				pd.put("TYPE", TABLENAME.equals("")?1:2);					//1: 澶囦唤鏁村簱锛�2锛氬浠芥煇琛�
				pd.put("BZ", "瀹氭椂澶囦唤鎿嶄綔");								//澶囨敞
				brdbService.save(pd);										//瀛樺叆澶囦唤璁板綍
			}else{
				shutdownJob(context,pd,parameter,webctx);
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
			try {
				shutdownJob(context,pd,parameter,webctx);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**鎶婂畾鏃跺浠戒换鍔＄姸鎬佹敼涓哄叧闂�
	 * @param pd
	 * @param parameter
	 * @param webctx
	 */
	public void shutdownJob(JobExecutionContext context, PageData pd, Map<String,Object> parameter, WebApplicationContext webctx){
		try {
			context.getScheduler().shutdown();	//澶囦唤寮傚父鏃跺叧闂换鍔�
			TimingBackUpService timingbackupService = (TimingBackUpService)webctx.getBean("timingbackupService");
			pd.put("STATUS", 2);				//鏀瑰彉瀹氭椂杩愯鐘舵�佷负2锛屽叧闂�
			pd.put("TIMINGBACKUP_ID", parameter.get("TIMINGBACKUP_ID").toString()); //瀹氭椂澶囦唤ID
			timingbackupService.changeStatus(pd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
