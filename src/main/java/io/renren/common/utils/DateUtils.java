package io.renren.common.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * 日期处理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    private static final DateTimeFormatter GMT_FMT;
    private static final ZoneId GMT_ZONE_ID;

    public static int nowUnix() {
        return (int)Instant.now().getEpochSecond();
    }

    public static String toString(long unixTime, String pattern) {
        return Instant.ofEpochSecond(unixTime).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String toString(Date date, String pattern) {
        Instant instant = (new Date(date.getTime())).toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String toString(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String toString(LocalDateTime date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String toString(LocalDateTime time) {
        return toString(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static int toUnix(String time, String pattern) {
        LocalDateTime formatted = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        return (int)formatted.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    public static int toUnix(String time) {
        return toUnix(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static int toUnix(Date date) {
        return (int)date.toInstant().getEpochSecond();
    }

    public static Date toDate(String time, String pattern) {
        LocalDate formatted = LocalDate.parse(time, DateTimeFormatter.ofPattern(pattern));
        return Date.from(Instant.from(formatted.atStartOfDay(ZoneId.systemDefault())));
    }

    public static Date toDateTime(String time, String pattern) {
        LocalDateTime formatted = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        return Date.from(formatted.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate toLocalDate(String time, String pattern) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime toLocalDateTime(String time, String pattern) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    public static Date toDate(long unixTime) {
        return Date.from(Instant.ofEpochSecond(unixTime));
    }

    public static String gmtDate() {
        return GMT_FMT.format(LocalDateTime.now().atZone(GMT_ZONE_ID));
    }

    public static String gmtDate(LocalDateTime localDateTime) {
        return GMT_FMT.format(localDateTime.atZone(GMT_ZONE_ID));
    }

    public static String gmtDate(Date date) {
        return GMT_FMT.format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).atZone(GMT_ZONE_ID));
    }

    static {
        GMT_FMT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        GMT_ZONE_ID = ZoneId.of("GMT");
    }

}
