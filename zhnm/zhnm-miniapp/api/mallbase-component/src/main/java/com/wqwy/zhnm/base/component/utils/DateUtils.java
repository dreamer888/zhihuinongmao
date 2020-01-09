package com.wqwy.zhnm.base.component.utils;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 
 * 类描述：时间操作定义类
 * 
 * @author: zwx @date： 日期：2012-12-8 时间：下午12:15:03
 * @version 1.0
 */
public class DateUtils extends PropertyEditorSupport {
	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
	// 各种时间格式
	public static final SimpleDateFormat date_sdf = new SimpleDateFormat("yyyy-MM-dd");
	// 各种时间格式
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	// 各种时间格式
	public static final SimpleDateFormat date_sdf_wz = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat time_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat time_sdf2 = new SimpleDateFormat("MM月dd日 HH:mm");
	public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat short_time_sdf2 = new SimpleDateFormat("HH时mm分ss秒");
	public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat datetimeFormat2 = new SimpleDateFormat("yyyyMMddmmHHssSSS");
	// 以毫秒表示的时间
	private static final long DAY_IN_MILLIS = 24 * 3600 * 1000;
	public static final long HOUR_IN_MILLIS = 3600 * 1000;
	private static final long MINUTE_IN_MILLIS = 60 * 1000;
	private static final long SECOND_IN_MILLIS = 1000;

	// 指定模式的时间格式
	private static SimpleDateFormat getSDFormat(String pattern) {
		return new SimpleDateFormat(pattern);
	}

	/**
	 * 
	 * @date 12 Jan 2018 11:37:40 AM @Title: formatDateByPattern @Description: date
	 * to cron with special date format. @param @param date @param @param
	 * dateFormat @param @return @return String @throws
	 */
	public static String GetCron(Date date) {
		String dateFormat = "ss mm HH dd MM ? yyyy";
		return GetDateStringWithDateFormat(date, dateFormat);
	}

	public static String GetDateStringWithDateFormat(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String formatTimeStr = null;
		if (date != null) {
			formatTimeStr = sdf.format(date);
		}
		return formatTimeStr;
	}

	public static String GetDateStringWithDateFormat(Date date, SimpleDateFormat sdf) {
		String formatTimeStr = "";
		if (date != null)
			formatTimeStr = sdf.format(date);
		return formatTimeStr;
	}

	/**
	 * 
	 * @date 23 Jan 2018 3:19:40 PM @Title: FormatLongToHHMMSSDate @Description:
	 * 将long 类型的时间毫秒数装换为 HH:mm:ss 的时间格式 @param @param millis @param @return @return
	 * String @throws
	 */
	public static String FormatLongToHHMMSSDate(long millis) {
		return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
				TimeUnit.MILLISECONDS.toSeconds(millis)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
	}

	/**
	 * 
	 * @date 23 Jan 2018 3:38:06 PM @Title: GetGroupPurchaseTimeLeft @Description:
	 * 计算团购剩余时间 @param @param createTime @param @param
	 * timeLimitMill @param @return @return long @throws
	 */
	public static long GetGroupPurchaseTimeLeft(Date createTime, long timeLimitMill) {
		if (createTime == null || timeLimitMill == 0)
			return 0L;
		return createTime.getTime() + timeLimitMill - new Date().getTime();
	}

	public static long GetGroupPurchaseTerminalTime(Date createTime, long timeLimitMill) {
		if (createTime == null || timeLimitMill == 0)
			return 0L;
		return createTime.getTime() + timeLimitMill;
	}

	/**
	 * 当前日历，这里用中国时间表示
	 * 
	 * @return 以当地时区表示的系统当前日历
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 指定毫秒数表示的日历
	 * 
	 * @param millis
	 *            毫秒数
	 * @return 指定毫秒数表示的日历
	 */
	public static Calendar getCalendar(long millis) {
		Calendar cal = Calendar.getInstance();
		// --------------------cal.setTimeInMillis(millis);
		cal.setTime(new Date(millis));
		return cal;
	}

	// ////////////////////////////////////////////////////////////////////////////
	// getDate
	// 各种方式获取的Date
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 当前日期
	 * 
	 * @return 系统当前时间
	 */
	public static Date getDate() {
		return new Date();
	}

	/**
	 * 指定毫秒数表示的日期
	 * 
	 * @param millis
	 *            毫秒数
	 * @return 指定毫秒数表示的日期
	 */
	public static Date getDate(long millis) {
		return new Date(millis);
	}

	/**
	 * 时间戳转换为字符串
	 * 
	 * @param time
	 * @return
	 */
	public static String timestamptoStr(Timestamp time) {
		Date date = null;
		if (null != time) {
			date = new Date(time.getTime());
		}
		return date2Str(date_sdf);
	}

	/**
	 * 字符串转换时间戳
	 * 
	 * @param str
	 * @return
	 */
	public static Timestamp str2Timestamp(String str) {
		Date date = str2Date(str, date_sdf);
		return new Timestamp(date.getTime());
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @param sdf
	 * @return
	 */
	public static Date str2Date(String str, SimpleDateFormat sdf) {
		if (null == str || "".equals(str)) {
			return null;
		}
		Date date = null;
		try {
			date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            日期格式
	 * @return 字符串
	 */
	public static String date2Str(SimpleDateFormat date_sdf) {
		Date date = getDate();
		if (null == date) {
			return null;
		}
		return date_sdf.format(date);
	}

	/**
	 * 格式化时间
	 * 
	 * @param data
	 * @param format
	 * @return
	 */
	public static String dataformat(String data, String format) {
		SimpleDateFormat sformat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sformat.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sformat.format(date);
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            日期格式
	 * @return 字符串
	 */
	public static String date2Str(Date date, SimpleDateFormat date_sdf) {
		if (null == date) {
			return null;
		}
		return date_sdf.format(date);
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            日期格式
	 * @return 字符串
	 */
	public static String getDate(String format) {
		Date date = new Date();
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 指定毫秒数的时间戳
	 * 
	 * @param millis
	 *            毫秒数
	 * @return 指定毫秒数的时间戳
	 */
	public static Timestamp getTimestamp(long millis) {
		return new Timestamp(millis);
	}

	/**
	 * 以字符形式表示的时间戳
	 * 
	 * @param time
	 *            毫秒数
	 * @return 以字符形式表示的时间戳
	 */
	public static Timestamp getTimestamp(String time) {
		return new Timestamp(Long.parseLong(time));
	}

	/**
	 * 系统当前的时间戳
	 * 
	 * @return 系统当前的时间戳
	 */
	public static Timestamp getTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 指定日期的时间戳
	 * 
	 * @param date
	 *            指定日期
	 * @return 指定日期的时间戳
	 */
	public static Timestamp getTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * 指定日历的时间戳
	 * 
	 * @param cal
	 *            指定日历
	 * @return 指定日历的时间戳
	 */
	public static Timestamp getCalendarTimestamp(Calendar cal) {
		// ---------------------return new Timestamp(cal.getTimeInMillis());
		return new Timestamp(cal.getTime().getTime());
	}

	public static Timestamp gettimestamp() {
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = df.format(dt);
		java.sql.Timestamp buydate = java.sql.Timestamp.valueOf(nowTime);
		return buydate;
	}

	// ////////////////////////////////////////////////////////////////////////////
	// getMillis
	// 各种方式获取的Millis
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 系统时间的毫秒数
	 * 
	 * @return 系统时间的毫秒数
	 */
	public static long getMillis() {
		return new Date().getTime();
	}

	/**
	 * 指定日历的毫秒数
	 * 
	 * @param cal
	 *            指定日历
	 * @return 指定日历的毫秒数
	 */
	public static long getMillis(Calendar cal) {
		// --------------------return cal.getTimeInMillis();
		return cal.getTime().getTime();
	}

	/**
	 * 指定日期的毫秒数
	 * 
	 * @param date
	 *            指定日期
	 * @return 指定日期的毫秒数
	 */
	public static long getMillis(Date date) {
		return date.getTime();
	}

	/**
	 * 指定时间戳的毫秒数
	 * 
	 * @param ts
	 *            指定时间戳
	 * @return 指定时间戳的毫秒数
	 */
	public static long getMillis(Timestamp ts) {
		return ts.getTime();
	}

	// ////////////////////////////////////////////////////////////////////////////
	// formatDate
	// 将日期按照一定的格式转化为字符串
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 默认方式表示的系统当前日期，具体格式：年-月-日
	 * 
	 * @return 默认日期按“年-月-日“格式显示
	 */
	public static String formatDate() {
		return date_sdf.format(getCalendar().getTime());
	}

	/**
	 * 获取时间字符串
	 */
	public static String getDataString(SimpleDateFormat formatstr) {
		return formatstr.format(getCalendar().getTime());
	}

	/**
	 * 指定日期的默认显示，具体格式：年-月-日
	 * 
	 * @param cal
	 *            指定的日期
	 * @return 指定日期按“年-月-日“格式显示
	 */
	public static String formatDate(Calendar cal) {
		return date_sdf.format(cal.getTime());
	}

	/**
	 * 指定日期的默认显示，具体格式：年-月-日
	 * 
	 * @param date
	 *            指定的日期
	 * @return 指定日期按“年-月-日“格式显示
	 */
	public static String formatDate(Date date) {
		return date_sdf.format(date);
	}

	/**
	 * 指定毫秒数表示日期的默认显示，具体格式：年-月-日
	 * 
	 * @param millis
	 *            指定的毫秒数
	 * @return 指定毫秒数表示日期按“年-月-日“格式显示
	 */
	public static String formatDate(long millis) {
		return date_sdf.format(new Date(millis));
	}

	/**
	 * 默认日期按指定格式显示
	 * 
	 * @param pattern
	 *            指定的格式
	 * @return 默认日期按指定格式显示
	 */
	public static String formatDate(String pattern) {
		return getSDFormat(pattern).format(getCalendar().getTime());
	}

	/**
	 * 指定日期按指定格式显示
	 * 
	 * @param cal
	 *            指定的日期
	 * @param pattern
	 *            指定的格式
	 * @return 指定日期按指定格式显示
	 */
	public static String formatDate(Calendar cal, String pattern) {
		return getSDFormat(pattern).format(cal.getTime());
	}

	/**
	 * 指定日期按指定格式显示
	 * 
	 * @param date
	 *            指定的日期
	 * @param pattern
	 *            指定的格式
	 * @return 指定日期按指定格式显示
	 */
	public static String formatDate(Date date, String pattern) {
		return getSDFormat(pattern).format(date);
	}

	// ////////////////////////////////////////////////////////////////////////////
	// formatTime
	// 将日期按照一定的格式转化为字符串
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 默认方式表示的系统当前日期，具体格式：年-月-日 时：分
	 * 
	 * @return 默认日期按“年-月-日 时：分“格式显示
	 */
	public static String formatTime() {
		return time_sdf.format(getCalendar().getTime());
	}

	/**
	 * 指定毫秒数表示日期的默认显示，具体格式：年-月-日 时：分
	 * 
	 * @param millis
	 *            指定的毫秒数
	 * @return 指定毫秒数表示日期按“年-月-日 时：分“格式显示
	 */
	public static String formatTime(long millis) {
		return time_sdf.format(new Date(millis));
	}

	/**
	 * 指定日期的默认显示，具体格式：年-月-日 时：分
	 * 
	 * @param cal
	 *            指定的日期
	 * @return 指定日期按“年-月-日 时：分“格式显示
	 */
	public static String formatTime(Calendar cal) {
		return time_sdf.format(cal.getTime());
	}

	/**
	 * 指定日期的默认显示，具体格式：年-月-日 时：分
	 * 
	 * @param date
	 *            指定的日期
	 * @return 指定日期按“年-月-日 时：分“格式显示
	 */
	public static String formatTime(Date date) {
		return time_sdf.format(date);
	}

	// ////////////////////////////////////////////////////////////////////////////
	// formatShortTime
	// 将日期按照一定的格式转化为字符串
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 默认方式表示的系统当前日期，具体格式：时：分
	 * 
	 * @return 默认日期按“时：分“格式显示
	 */
	public static String formatShortTime() {
		return short_time_sdf.format(getCalendar().getTime());
	}

	/**
	 * 指定毫秒数表示日期的默认显示，具体格式：时：分
	 * 
	 * @param millis
	 *            指定的毫秒数
	 * @return 指定毫秒数表示日期按“时：分“格式显示
	 */
	public static String formatShortTime(long millis) {
		return short_time_sdf.format(new Date(millis));
	}

	/**
	 * 指定日期的默认显示，具体格式：时：分
	 * 
	 * @param cal
	 *            指定的日期
	 * @return 指定日期按“时：分“格式显示
	 */
	public static String formatShortTime(Calendar cal) {
		return short_time_sdf.format(cal.getTime());
	}

	/**
	 * 指定日期的默认显示，具体格式：时：分
	 * 
	 * @param date
	 *            指定的日期
	 * @return 指定日期按“时：分“格式显示
	 */
	public static String formatShortTime(Date date) {
		return short_time_sdf.format(date);
	}

	// ////////////////////////////////////////////////////////////////////////////
	// parseDate
	// parseCalendar
	// parseTimestamp
	// 将字符串按照一定的格式转化为日期或时间
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
	 * 
	 * @param src
	 *            将要转换的原始字符窜
	 * @param pattern
	 *            转换的匹配格式
	 * @return 如果转换成功则返回转换后的日期
	 * @throws ParseException
	 * @throws AIDateFormatException
	 */
	public static Date parseDate(String src, String pattern) throws ParseException {
		return getSDFormat(pattern).parse(src);

	}

	/**
	 * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
	 * 
	 * @param src
	 *            将要转换的原始字符窜
	 * @param pattern
	 *            转换的匹配格式
	 * @return 如果转换成功则返回转换后的日期
	 * @throws ParseException
	 * @throws AIDateFormatException
	 */
	public static Calendar parseCalendar(String src, String pattern) throws ParseException {

		Date date = parseDate(src, pattern);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static String formatAddDate(String src, String pattern, int amount) throws ParseException {
		Calendar cal;
		cal = parseCalendar(src, pattern);
		cal.add(Calendar.DATE, amount);
		return formatDate(cal);
	}

	/**
	 * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
	 * 
	 * @param src
	 *            将要转换的原始字符窜
	 * @param pattern
	 *            转换的匹配格式
	 * @return 如果转换成功则返回转换后的时间戳
	 * @throws ParseException
	 * @throws AIDateFormatException
	 */
	public static Timestamp parseTimestamp(String src, String pattern) throws ParseException {
		Date date = parseDate(src, pattern);
		return new Timestamp(date.getTime());
	}

	// ////////////////////////////////////////////////////////////////////////////
	// dateDiff
	// 计算两个日期之间的差值
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 计算两个时间之间的差值，根据标志的不同而不同
	 * 
	 * @param flag
	 *            计算标志，表示按照年/月/日/时/分/秒等计算
	 * @param calSrc
	 *            减数
	 * @param calDes
	 *            被减数
	 * @return 两个日期之间的差值
	 */
	public static int dateDiff(char flag, Calendar calSrc, Calendar calDes) {

		long millisDiff = getMillis(calSrc) - getMillis(calDes);

		if (flag == 'y') {
			return (calSrc.get(calSrc.YEAR) - calDes.get(calDes.YEAR));
		}

		if (flag == 'd') {
			return (int) (millisDiff / DAY_IN_MILLIS);
		}

		if (flag == 'h') {
			return (int) (millisDiff / HOUR_IN_MILLIS);
		}

		if (flag == 'm') {
			return (int) (millisDiff / MINUTE_IN_MILLIS);
		}

		if (flag == 's') {
			return (int) (millisDiff / SECOND_IN_MILLIS);
		}

		return 0;
	}

	/**
	 * String类型 转换为Date, 如果参数长度为10 转换格式”yyyy-MM-dd“ 如果参数长度为19 转换格式”yyyy-MM-dd
	 * HH:mm:ss“ * @param text String类型的时间值
	 */
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.hasText(text)) {
			try {
				if (text.indexOf(":") == -1 && text.length() == 10) {
					setValue(this.date_sdf.parse(text));
				} else if (text.indexOf(":") > 0 && text.length() == 19) {
					setValue(this.datetimeFormat.parse(text));
				} else {
					throw new IllegalArgumentException("Could not parse date, date format is error ");
				}
			} catch (ParseException ex) {
				IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
				iae.initCause(ex);
				throw iae;
			}
		} else {
			setValue(null);
		}
	}

	public static int getYear() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getDate());
		return calendar.get(Calendar.YEAR);
	}

	public static String GetDeliveryTimeSlice(Calendar c) {
		String s = "10:00-11:00";
		
		ZERO_AM.set(Calendar.YEAR, c.get(Calendar.YEAR));
		ZERO_AM.set(Calendar.MONTH,c.get(Calendar.MONTH));
		ZERO_AM.set(Calendar.DATE,c.get(Calendar.DAY_OF_MONTH));
		
		TEN_AM.set(Calendar.YEAR, c.get(Calendar.YEAR));
		TEN_AM.set(Calendar.MONTH,c.get(Calendar.MONTH));
		TEN_AM.set(Calendar.DATE,c.get(Calendar.DAY_OF_MONTH));
		
		NINETEEN_PM.set(Calendar.YEAR, c.get(Calendar.YEAR));
		NINETEEN_PM.set(Calendar.MONTH,c.get(Calendar.MONTH));
		NINETEEN_PM.set(Calendar.DATE,c.get(Calendar.DAY_OF_MONTH));
		
		TWENTYFOUR_PM.set(Calendar.YEAR, c.get(Calendar.YEAR));
		TWENTYFOUR_PM.set(Calendar.MONTH,c.get(Calendar.MONTH));
		TWENTYFOUR_PM.set(Calendar.DATE,c.get(Calendar.DAY_OF_MONTH));
		
		String currTime = datetimeFormat.format(c.getTime());
	    String startTime = datetimeFormat.format(TEN_AM.getTime());
	    String endTime = datetimeFormat.format(NINETEEN_PM.getTime());
	    
	    logger.info("GetDeliveryTimeSlice-->currTime:"+currTime);
	    logger.info("GetDeliveryTimeSlice-->startTime:"+startTime);
	    logger.info("GetDeliveryTimeSlice-->endTime:"+endTime);	
	    
	    //0点-10点下单配送时间：10:00-11:00
	    if (c.after(ZERO_AM) && c.before(TEN_AM)) {
			 s = getDate_(0) +" " +s;
		}
	    
	    //10点-19点下单配送时间：下单时间+1个小时
		if (c.after(TEN_AM) && c.before(NINETEEN_PM)) {
			 try {
				s = new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HH:mm").parse(c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)))+
				"-"
				+new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HH:mm").parse((c.get(Calendar.HOUR_OF_DAY)+1)+":"+c.get(Calendar.MINUTE)));
			 } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 s = getDate_(0) +" " +s;
		}
		
		//19-24点下单配送时间：第二天10:00-11:00
		if (c.after(NINETEEN_PM) && c.before(TWENTYFOUR_PM)) {
			 s = getDate_(1) +" " +s;
		}
		return s;
	}
	
	public static String GetDeliveryTimeSlice() {
		/**
		 * 1.上午10:00前的订单 时间段为10:00-11:00
		 * 2.下午19:00为最后一个可配送订单时间点 时间段为19:00-20:00
		 * 3.10:00-19:00下单 配送时间段为 now()-(now()+1小时)
		 * 4.19:00后 配送时间段为第二天10:00-11:00
		 * 
		 * note: 当前时间显示仅显示 时:分 故4和1的字段值没有区别
		 */
		return GetDeliveryTimeSlice(Calendar.getInstance());
	}
	 // 0点
	 public static final Calendar ZERO_AM = Calendar.getInstance();
	 // 9点
	 public static final Calendar NINE_AM = Calendar.getInstance();
	 // 10点
	 public static final Calendar TEN_AM = Calendar.getInstance();
	 // 19点
	 public static final Calendar NINETEEN_PM = Calendar.getInstance();
	 // 24点
	 public static final Calendar TWENTYFOUR_PM = Calendar.getInstance();
	 
	 static {
		 
		 ZERO_AM.set(Calendar.HOUR_OF_DAY, 0);
		 ZERO_AM.set(Calendar.MINUTE, 0);
		 ZERO_AM.set(Calendar.SECOND, 0);
		 
		 NINE_AM.set(Calendar.HOUR_OF_DAY, 9);
		 NINE_AM.set(Calendar.MINUTE, 0);
		 NINE_AM.set(Calendar.SECOND, 0);
		 
		 TEN_AM.set(Calendar.HOUR_OF_DAY, 10);
		 TEN_AM.set(Calendar.MINUTE, 0);
		 TEN_AM.set(Calendar.SECOND, 0);
	
		 NINETEEN_PM.set(Calendar.HOUR_OF_DAY, 18);
		 NINETEEN_PM.set(Calendar.MINUTE, 0);
		 NINETEEN_PM.set(Calendar.SECOND, 0);
		 
		 TWENTYFOUR_PM.set(Calendar.HOUR_OF_DAY, 23);
		 TWENTYFOUR_PM.set(Calendar.MINUTE, 59);
		 TWENTYFOUR_PM.set(Calendar.SECOND, 59);
	 }
     
	 public static String getDate(int day){  
	    	Format f = new SimpleDateFormat("MM月dd日");
	        Date today = new Date();
	        
	        Calendar c = Calendar.getInstance();
	        c.setTime(today);
	        c.add(Calendar.DAY_OF_MONTH, day);// 天数追加
	 
	        Date tomorrow = c.getTime();
	        //System.out.println("当前是:" + dayName+f.format(tomorrow));
	        return f.format(tomorrow);
	 }
	 
	 public static String getDate_(int day){  
	    	Format f = new SimpleDateFormat("MM-dd");
	        Date today = new Date();
	        
	        Calendar c = Calendar.getInstance();
	        c.setTime(today);
	        c.add(Calendar.DAY_OF_MONTH, day);// 天数追加
	 
	        Date tomorrow = c.getTime();
	        //System.out.println("当前是:" + dayName+f.format(tomorrow));
	        return f.format(tomorrow);
	 }
	 
	 public static String getHour(){  
	    	Format f = new SimpleDateFormat("HH:mm");
	        Date today = new Date();
	        
	        Calendar c = Calendar.getInstance();
	        c.setTime(today);
	 
	        Date tomorrow = c.getTime();
	        return f.format(tomorrow);
	 }
	 
	 public static int compare_date(String DATE1, String DATE2) {
	        DateFormat df = new SimpleDateFormat("HH:mm");
	        try {
	            Date dt1 = df.parse(DATE1);
	            Date dt2 = df.parse(DATE2);
	            if (dt1.getTime() > dt2.getTime()) {
	                //System.out.println("dt1 在dt2前");
	                return 1;
	            } else if (dt1.getTime() < dt2.getTime()) {
	                //System.out.println("dt1在dt2后");
	                return -1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
	 
	 public static Date addDay(Date date, int num) {  
	       Calendar startDT = Calendar.getInstance();  
	       startDT.setTime(date);  
	       startDT.add(Calendar.DATE, num); 
	       return startDT.getTime();  
	 }  
	 
	 public static String getCurrDate() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(new Date());
	 }
	 public static String getDatetime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(new Date());
	 }
	 public static String getDatetimems() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sf.format(new Date());
	 }
	
	 public static String getDatetimemslong() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sf.format(new Date());
	 } 
		
	 public static void main(String[] args) {
//		    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
//		    String time2 = format2.format(Calendar.getInstance().getTime());
//		    System.out.println("-->"+time2);
			System.out.println("-->"+GetDeliveryTimeSlice(Calendar.getInstance()));
		 
//			Calendar c = Calendar.getInstance();
			//&& sameDay
//			if (c.after(DateUtils.NINE_AM) && c.before(DateUtils.NINETEEN_PM)) { 
//				 System.out.println("11");
//			}
//		 Calendar calendar = Calendar.getInstance();
//    	 String year = String.valueOf(calendar.get(Calendar.YEAR));
//    	 String str = "10-24 21";
//    	 str = year + "-" +str+":00:00";
//         System.out.println("-->"+str);
//         
//         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//         
//         try {
//			Date date= sdf.parse(str);
//			date.setHours(date.getHours()-1);
//			System.out.println("-->"+sdf.format(date));
//			
//			Calendar calendar1 = Calendar.getInstance();
//			calendar1.setTime(date);
//			
//			System.out.println("==>"+calendar1.getTime());
//			
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
         
         
//		System.out.println("hour-->"+getHour());
//		String hour = "16:30-17:30";
//		System.out.println("=="+hour.substring(0, 5));
//		System.out.println("result-->"+compare_date(hour.substring(0, 5),getHour()));
		 
//		 Calendar calendar3 = Calendar.getInstance();
//		 calendar3.set(Calendar.HOUR_OF_DAY, 9);
//		 calendar3.set(Calendar.MINUTE, 0);
//		 calendar3.set(Calendar.SECOND, 0);
//		 calendar3.add(Calendar.DATE, 1);
//		 System.out.println("==="+calendar3.getTime());
		 
		// System.out.println("-->"+GetDeliveryTimeSlice(Calendar.getInstance()));
		 
		 
	 }
	// /*
	// * 判断参数时间是否在 可选的预期送达时间 内
	// * 以上可选的预期送达时间为:
	// * 1.今天或明天的8:00-20:00
	// * 2.((当前时间+-3min)+1h)以后的时间 或 ((当前时间+-3min)+30min)之间的时间段
	// * x>now()-3min+1h || x-30min-3min < now() < x-30min+3min
	// */
	// public static final boolean isLegalExceptedShippingFinishTime(Date d){
	// Calendar c1 = Calendar.getInstance();
	// c1.setTime(d);
	// //今天8点
	// Calendar calendar1 = Calendar.getInstance();
	// calendar1.set(Calendar.HOUR_OF_DAY, 8);
	// calendar1.set(Calendar.MINUTE, 0);
	// calendar1.set(Calendar.SECOND, 0);
	// //今天20点
	// Calendar calendar2 = Calendar.getInstance();
	// calendar2.set(Calendar.HOUR_OF_DAY, 20);
	// calendar2.set(Calendar.MINUTE, 0);
	// calendar2.set(Calendar.SECOND, 0);
	// //明天8点
	// Calendar calendar3 = Calendar.getInstance();
	// calendar3.set(Calendar.HOUR_OF_DAY, 8);
	// calendar3.set(Calendar.MINUTE, 0);
	// calendar3.set(Calendar.SECOND, 0);
	// calendar3.add(Calendar.DATE, 1);
	// //明天20点
	// Calendar calendar4 = Calendar.getInstance();
	// calendar4.set(Calendar.HOUR_OF_DAY, 20);
	// calendar4.set(Calendar.MINUTE, 0);
	// calendar4.set(Calendar.SECOND, 0);
	// calendar4.add(Calendar.DATE, 1);
	//// Calendar c4 = Calendar.getInstance();
	//// Calendar c5 = Calendar.getInstance();
	// Long now = new Date().getTime();
	// if (c1.after(calendar3) && c1.before(calendar4))//明天8-20
	// return true;
	// if (c1.after(calendar1) && c1.before(calendar2)){//今天8-20
	// if (now - 3*60*1000 +3600*1000 < d.getTime())
	// return true;
	// else if ( d.getTime() - 30*60*1000 - 3*60*1000 < now && now < d.getTime() -
	// 30*60*1000 + 3*60*1000)
	// return true;
	// }
	// return false;
	// }

}