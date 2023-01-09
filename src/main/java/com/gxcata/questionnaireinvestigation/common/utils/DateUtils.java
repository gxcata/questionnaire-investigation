package com.gxcata.questionnaireinvestigation.common.utils;

import com.gxcata.questionnaireinvestigation.common.exception.RRException;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author gxcata
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String YYYYMMDD = "yyyyMMdd";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final Date parseStringToDate(String dateStr) {
        return dateTime(YYYYMMDD, dateStr);
    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String dateStringTime(final Date date) {
        return parseDateToStr(YYYYMMDD, date);
    }

    public static final String dateStringTime2(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Date parseDateTimeToDateOnly(Date date) {
        if (date == null) {
            return null;
        }
        String temp = parseDateToStr(YYYY_MM_DD, date);
        return dateTime(YYYY_MM_DD, temp);
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 字符串日期时间转日期
     */
    public static String getDateTimeString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return format.format(date);
    }

    /**
     * @param timestamp
     * @desc 时间戳转字符串
     * @example timestamp=1558322327000
     **/
    public static String getStringTime(long timestamp) {
//        String date = new SimpleDateFormat("yyyy-MM-dd").format(timestamp);  // 获取只有年月日的时间
        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));  // 获取年月日时分秒
        return datetime;
    }

    public static String getStringTime2(long timestamp) {
//        String date = new SimpleDateFormat("yyyy-MM-dd").format(timestamp);  // 获取只有年月日的时间
        String datetime = new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp));  // 获取年月日时分秒
        return datetime;
    }

    public Long getTimestamp(String time) {
        Long timestamp = null;
        try {
            timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    /**
     * 获取一年前月份
     *
     * @param date
     * @return
     */
    public static Date getLastYear(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        String year = format.format(y);
        System.out.println("过去一年：" + year);
        return y;
    }

    /**
     * 获取一年后月份
     *
     * @param date
     * @return
     */
    public static Date getNextYear(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        c.add(Calendar.YEAR, 1);
        Date y = c.getTime();
        String year = format.format(y);
        System.out.println("未来一年：" + year);
        return y;
    }

    public static boolean compareTo(Date firstDate, Date secondDate) {
        return firstDate.getTime() <= secondDate.getTime();
    }

    public static Date getDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTime();
    }

    /**
     * 获取一个日期当天的0点时间戳
     * */
    public static long dateAtZero(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,00);
        calendar.set(Calendar.MINUTE,00);
        calendar.set(Calendar.SECOND,00);
        calendar.set(Calendar.MILLISECOND,000);
        return calendar.getTimeInMillis();
    }
    /**
     * 计算两个时间之间的天数 (区分正负)
     * */
    public static long  intervalDays(Date prev,Date next){
        long days = (dateAtZero(next) - dateAtZero(prev))/1000L/3600L/24L;
        return days;
    }

    /**
     * 计算一个日期n天后的日期
     * */
    public static Date afterDaysDate(Date current,int n){


        long nTimes = ((long)n)*24L*3600L*1000L;
        long afterTimes = dateAtZero(current)+nTimes;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(afterTimes);
        calendar.set(Calendar.HOUR_OF_DAY,00);
        calendar.set(Calendar.MINUTE,00);
        calendar.set(Calendar.SECOND,00);
        calendar.set(Calendar.MILLISECOND,000);
        return calendar.getTime();
    }

    /**
     * 计算一个日期n天前的日期
     * */
    public static Date beforeDaysDate(Date current,int n){

        long nTimes = ((long)n)*24L*3600L*1000L;
        long afterTimes = dateAtZero(current)-nTimes;
        Calendar calendar = Calendar.getInstance();
        //算出来的前一天的结果时间戳 小于一天就返回current
        if(afterTimes>nTimes){
            calendar.setTimeInMillis(afterTimes);
        }

        return calendar.getTime();
    }
    /**
    * 计算一个日期n 后最晚的日期时间
    **/
    public static Date afterDayMax(Date current,int n) throws ParseException {
         n = n -1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        calendar.add(Calendar.DATE, n);
        String T1 = format.format(calendar.getTime() ) ;
        try {
            Date date = df.parse(T1);
            return date;
        }catch (ParseException e){
            throw new RRException("时间计算错误");
        }
    }

    /**
     * 计算两个时间差 返回时间戳
     * */
    public static long timeDiffer(Date oneDate,Date twoDate){
        return oneDate.getTime() - twoDate.getTime();

    }


    /**
    * 两分钟之后的时间
    **/
    public static Date timeAddSecond(Date date){
        long  addTime = 2*60*1000;
        Date addAfter = new Date(date.getTime()+addTime);
        return addAfter;
    }
}
