package com.edu.graduation.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description 时间
 * @Author q
 * @Date 18-7-22 下午3:42
 */
@Slf4j
public class DateUtil {

    public static String date2string(Date day){
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        return s.format(day);
    }


    /**
     * 获得当前日期  年-月-日
     * 并返回String
     *
     * @return
     */
    public static String getTimeDate() {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String timeDate = s.format(date);
        return timeDate;
    }

    /**
     * 获得当前时间  时-分
     * 并返回String
     *
     * @return
     */
    public static String getTimeInfo() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String time = format.format(date);
        return time;
    }

    /**
     * 日期 将string类型转成date类型
     *
     * @param datestr
     * @return
     */
    public static Date convertStringTodate(String datestr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = format.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间 将string类型转成date类型
     *
     * @param timestr
     * @return
     */
    public static Date convertStringToTime(String timestr) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = format.parse(timestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 计算时间差
     *
     * @param date1
     * @param date2
     * @return
     */
    public static String getTimeDiff(Date date1, Date date2) {
        /* 微妙差 */
        long diff = date2.getTime() - date1.getTime();
        /* 小时 */
        long hours = diff / (1000 * 60 * 60);
        /* 分 */
        long minutes = (diff - hours * (1000 * 60 * 60)) / (1000 * 60);
        String timeDiff = hours + "-" + minutes;
        return timeDiff;
    }

    /**
     * 计算两个时长总和
     *
     * @param total
     * @param tempDiff
     * @return
     */
    public static String calculateTotalTimeDiff(String total, String tempDiff) {
        /* 取出时分 */
        String[] tempTotal = total.split("-");
        String[] tempDiffList = tempDiff.split("-");
        /* 转成int类型数组 */
        int[] intTotal = stringToInt(tempTotal);
        int[] intDiff = stringToInt(tempDiffList);
        /* 计算加和之后的时分 */
        int minutes = (intTotal[1] + intDiff[1]) % 60;
        int hours = intTotal[0] + intDiff[0] + (intTotal[1] + intDiff[1]) / 60;
        return hours + "-" + minutes;
    }

    public static String calculateAverageTime(String totalTime, int timeFre) {
        String average = "0-0";
        String[] tempTotal = totalTime.split("-");
        int[] intTotal = stringToInt(tempTotal);
        /* 将总时间转化为分单位 */
        int total = intTotal[0] * 60 + intTotal[1];
        /* 计算平均时间  取整 */
        if (timeFre == 0) {
            return average;
        }
        int averageTime = total / timeFre;

        /* 小时 */
        long hours = averageTime / 60;
        /* 分 */
        long minutes = averageTime - hours * 60;

        average = hours + "-" + minutes;
        return average;
    }

    /**
     * string类型数组转为int类型数组
     *
     * @param strs
     * @return
     */
    public static int[] stringToInt(String[] strs) {
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }
        return ints;
    }

    public static Date addDay(Date day){
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.DAY_OF_MONTH,1);
        Date result = c.getTime();
//        result = s.format(result);
        return result;
    }




}
