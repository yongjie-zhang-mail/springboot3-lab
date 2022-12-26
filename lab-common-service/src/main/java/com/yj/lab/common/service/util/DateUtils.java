package com.yj.lab.common.service.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_HH_MM_SS = "HH:mm:ss";
    public static final String DATE_FORMAT_YYYYMMDDHHMMMSS = "yyyyMMddHHmmss";
    private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

    private DateUtils() {
    }

    /**
     * 获取当前时间，以Date 格式输出，yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static Date nowDate() {
        Calendar cNow = Calendar.getInstance();
        Date dNow = cNow.getTime();
        return dNow;
    }

    public static Date getNday(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, n);
        return calendar.getTime();
    }

    public static Date addNday(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, n);
        return calendar.getTime();
    }

    public static Date getNMonth(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, n);
        return calendar.getTime();
    }

    public static Date addNMonth(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, n);
        return calendar.getTime();
    }

    public static Date parseDate(String strDate) {
        return parseDate(strDate, (String) null);
    }

    public static Date parseDate(String strDate, String pattern) {
        Date date = null;

        try {
            SimpleDateFormat format = new SimpleDateFormat((String) StringUtils.defaultIfEmpty(pattern, "yyyy-MM-dd"));
            date = format.parse(strDate);
        } catch (ParseException var4) {
            log.error("parseDate error:" + var4);
        }

        return date;
    }

    public static String formatDate(Date date) {
        return formatDate(date, (String) null);
    }

    public static String formatDate(Date date, String pattern) {
        String strDate = null;
        if (date != null) {
            try {
                SimpleDateFormat format = new SimpleDateFormat((String) StringUtils.defaultIfEmpty(pattern, "yyyy-MM-dd"));
                strDate = format.format(date);
            } catch (IllegalArgumentException var4) {
                log.error("formatDate error:", var4);
            }
        }

        return strDate;
    }

    public static int getYear(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(parseDate(date));
        return c.get(1);
    }

    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(7);
    }

    public static int getSeason(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(parseDate(date));
        int month = c.get(2);
        return (int) Math.ceil((double) (month + 1) / 3.0D);
    }

    public static int getSeason(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(2);
        return (int) Math.ceil((double) (month + 1) / 3.0D);
    }

    public static String getFormatNDayByDate(Date date, int nDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(5);
        calendar.set(5, day - nDay);
        return formatDate(calendar.getTime(), "yyyy-MM-dd");
    }

    public static Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(1, year);
        cal.set(2, month - 1);
        int lastDay = cal.getActualMaximum(5);
        cal.set(5, lastDay);
        return cal.getTime();
    }

    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(1, year);
        cal.set(2, month - 1);
        int firstDay = cal.getActualMinimum(5);
        cal.set(5, firstDay);
        return cal.getTime();
    }

    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(5);
    }

    public static int getPassDayOfSeason(Date date) {
        int day = 0;
        Date[] seasonDates = getSeasonDate(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(2);
        if (month != 0 && month != 3 && month != 6 && month != 9) {
            if (month != 1 && month != 4 && month != 7 && month != 10) {
                if (month == 2 || month == 5 || month == 8 || month == 11) {
                    day = getDayOfMonth(seasonDates[0]) + getDayOfMonth(seasonDates[1]) + getPassDayOfMonth(seasonDates[2]);
                }
            } else {
                day = getDayOfMonth(seasonDates[0]) + getPassDayOfMonth(seasonDates[1]);
            }
        } else {
            day = getPassDayOfMonth(seasonDates[0]);
        }

        return day;
    }

    public static Date[] getSeasonDate(Date date) {
        Date[] season = new Date[3];
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int nSeason = getSeason(date);
        if (nSeason == 1) {
            c.set(2, 0);
            season[0] = c.getTime();
            c.set(2, 1);
            season[1] = c.getTime();
            c.set(2, 2);
            season[2] = c.getTime();
        } else if (nSeason == 2) {
            c.set(2, 3);
            season[0] = c.getTime();
            c.set(2, 4);
            season[1] = c.getTime();
            c.set(2, 5);
            season[2] = c.getTime();
        } else if (nSeason == 3) {
            c.set(2, 6);
            season[0] = c.getTime();
            c.set(2, 7);
            season[1] = c.getTime();
            c.set(2, 8);
            season[2] = c.getTime();
        } else if (nSeason == 4) {
            c.set(2, 9);
            season[0] = c.getTime();
            c.set(2, 10);
            season[1] = c.getTime();
            c.set(2, 11);
            season[2] = c.getTime();
        }

        return season;
    }

    public static int getPassDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(5);
    }

    public static String getMarketTaskSendTime(Calendar calendar) {
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;
        if (month <= 2) {
            month += 10;
            --year;
        } else {
            month -= 2;
        }

        return String.format("%d-%02d-31 23:59:59", year, month);
    }

    public static ArrayList<String> getDateList(String startDate, String endDate, String dateFormat) {
        ArrayList<String> dateList = Lists.newArrayList();
        Date startTime = StringUtils.isNotBlank(startDate) ? parseDate(startDate) : new Date();

        for (Date endTime = StringUtils.isNotBlank(endDate) ? parseDate(endDate) : new Date(); startTime.getTime() <= endTime.getTime(); startTime = addNday(startTime, 1)) {
            dateList.add(formatDate(startTime, dateFormat));
        }

        return dateList;
    }

    /**
     * 获取今天剩余时间,单位:s
     */
    public static Long getRemainingTimeForToday() {
        LocalDateTime midnight = LocalDateTime.now()
                .plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
        return seconds;
    }

    /**
     * 获取days天前的时间
     *
     * @param days
     * @return
     */
    public static String getFrontDate(int days, String patten) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - days);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat(patten);
        return format.format(today);
    }

    /**
     * 获取days天前的时间
     *
     * @param days
     * @return
     */
    public static Date getDateByDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - days);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * 格式化日期格式
     *
     * @param date
     * @param pattern
     * @return
     * @author zangchuanlei
     */
    public static String dateFormat(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateStr = null;
        if (date != null) {
            dateStr = simpleDateFormat.format(date);
        }
        return dateStr;
    }

    /**
     * 获取指定日期的前几天，并指定返回格式
     *
     * @param specifiedDay
     * @param days
     * @param patten
     * @return
     */
    public static String getSpecifiedDayBefore(String specifiedDay, int days, String patten) {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat(patten).parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - days);

        String dayBefore = new SimpleDateFormat(patten).format(c.getTime());
        return dayBefore;
    }

    /**
     * 获取指定之前天数的秒数
     *
     * @param days
     * @return
     */
    public static long getTimeByDays(int days) {
        Date fontDate = DateUtils.getDateByDays(days);
        long startTime = fontDate.getTime() / 1000;
        return startTime;
    }

    public static void main(String[] args) {
        Integer s = 1635004800;
        String s1 = formatDate(new Date(s * 1000), DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
        System.out.println(s1);
    }

    /**
     * 获取指定秒数之前的具体时间
     *
     * @param seconds
     * @return
     */
    public static String getFrontSecond(Date date, long seconds) {
        Date dateTwo = new Date(date.getTime() - seconds * 1000);
        String dateStr = dateFormat(dateTwo, DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
        return dateStr;
    }

    // 时间戳转换为定义的String
    public static String timeToString(Long time, String patten) {
        SimpleDateFormat format = new SimpleDateFormat(patten);
        String strDate = format.format(time);
        return strDate;
    }
}

