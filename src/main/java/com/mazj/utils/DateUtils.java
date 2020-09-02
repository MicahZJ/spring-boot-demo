package com.powerseu.dndx.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtils {
	/** 完整时间 yyyy-MM-dd HH:mm:ss */
	public static final String simple = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final SimpleDateFormat ymd = new SimpleDateFormat(yyyyMMdd);
	public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";

	public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String CST_TIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";

	public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(dateTimeFormatter);
	}

	public static String getDateFormat(Date date, String dateFormatType) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatType, Locale.CHINA);
		return simpleDateFormat.format(date);
	}

	public static String formatCstTime(String date, String format) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CST_TIME_PATTERN, Locale.US);
		Date usDate = simpleDateFormat.parse(date);
		return getDateFormat(usDate, format);
	}

	public static String formatInstant(Instant instant, String format) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		return localDateTime.format(DateTimeFormatter.ofPattern(format));
	}

	private static SimpleDateFormat getSimple(String patten){
		return new SimpleDateFormat(patten);
	}

	public static String formatFullTime(LocalDateTime localDateTime) {
		return formatFullTime(localDateTime, yyyyMMddHHmmss);
	}

	/**
	 * @Description: 计算时间差值格式化成 dd天hh小时mm分钟
	 * @param date 开始时间
	 * @param longTime 毫秒数
	 */
	public static String timeDifference(Date date ,Integer longTime){
		Date endTime = new Date(date.getTime()+longTime*1000);
		return timeDifference(date,endTime);
	}

	public static String timeDifference(Date date ,Date endTime){
		LocalDateTime start = toLocalDateTime(date);
		LocalDateTime end = toLocalDateTime(endTime);
		Duration between = Duration.between(start, end);
		long day = between.toDays();
		long hour = between.toHours() % 24;
		long min = between.toMinutes() % 60;
		return day+"天"+hour+"小时"+min+"分钟";
	}


	public static LocalDateTime toLocalDateTime(Date date){
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}


	public static Date parseDate(String time, String pattern) {
		DateFormat df = getSimple(pattern);
		Date date = null;
		try {
			date = df.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		return getSimple(pattern).format(date);
	}

	/**
	 * 获取本月份有多少天数
	 * @return
	 */
	public static int getDayOfMonth(){
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
		return aCalendar.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 判断选择的日期本月的第几天
	 */
	public static int getDaysNumber() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

}
