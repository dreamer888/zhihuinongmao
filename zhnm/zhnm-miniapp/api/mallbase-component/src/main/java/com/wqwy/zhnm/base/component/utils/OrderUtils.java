package com.wqwy.zhnm.base.component.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OrderUtils {

	/**
	 * 锁对象，可以为任意对象
	 */
	private static Object lockObj = "lockerOrder";
	/**
	 * 订单号生成计数器
	 */
	private static long orderNumCount = 0L;
	/**
	 * 每毫秒生成订单号数量最大值
	 */
	private static int maxPerMSECSize = 1000;

	public static void main(String[] args) {
		System.out.println(createOrderNum());
	}

	// 代理商+时间戳年月日+时间戳时分秒+UUID(字符串)
	public static String createOrderNum() {
		String dailishang = "WQWY";
		return CreateNumWithSpecialHeader(dailishang);
	}

	public static String CreateNumWithSpecialHeader(String headerString) {
		String dailishang = headerString;
		// 最终生成的订单号
		String finOrderNum = "";
		try {
			synchronized (lockObj) {
				// 取系统当前时间作为订单号变量前半部分，精确到毫秒
				long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()));
				// 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
				if (orderNumCount >= maxPerMSECSize) {
					orderNumCount = 0L;
				}
				// 组装订单号
				String countStr = maxPerMSECSize + orderNumCount + "";
				finOrderNum = dailishang + nowLong/* +countStr.substring(1) */ + getOrderIdByUUId();
				/* finOrderNum=nowLong+""; */
				orderNumCount++;
				System.out.println(finOrderNum);
				System.out.println(orderNumCount);
				// Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finOrderNum;
	}

	public static String getOrderIdByUUId() {
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%015d", hashCodeV);
	}

}
