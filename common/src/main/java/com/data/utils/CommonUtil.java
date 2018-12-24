package com.data.utils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : ganjiaxin
 * create at:  2018/12/11  11:15 AM
 * @description:
 */
public class CommonUtil {


        /**
         * 返回给定日期的同一个星期内的所有日期
         *
         * @param date
         * @return
         */
        public static Date[] dateToWeek(Date date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int b = cal.get(Calendar.DAY_OF_WEEK) - 2;
            if (b < 0) {
                b = 6;
            }
            Date[] weekDays = new Date[7];
            Date fdate;
            Long fTime = date.getTime() - b * 24 * 3600000;
            for (int a = 0; a < 7; a++) {
                fdate = DateUtils.getNow();
                fdate.setTime(fTime + (a * 24 * 3600000));
                weekDays[a] = fdate;
            }
            return weekDays;
        }

        /**
         * 将给定日期转换为0时0分0秒的日期对象
         *
         * @param date
         * @return
         */
        public static Date getZeroClockOfDate(Date date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            Calendar zDate = new GregorianCalendar(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
            return zDate.getTime();
        }

        /**
         * 将给定日期转换为23时59分59秒的日期对象
         *
         * @param date
         * @return
         */
        public static Date getLastClockOfDate(Date date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            Calendar zDate = new GregorianCalendar(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
            return zDate.getTime();
        }

        /**
         * 计算两个日期之间相差的天数
         *
         * @param smdate
         *            较小的时间
         * @param bdate
         *            较大的时间
         * @return 相差天数
         * @throws ParseException
         */
        public static int daysBetween(Date smdate, Date bdate) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                smdate = sdf.parse(sdf.format(smdate));
                bdate = sdf.parse(sdf.format(bdate));
                Calendar cal = Calendar.getInstance();
                cal.setTime(smdate);
                long time1 = cal.getTimeInMillis();
                cal.setTime(bdate);
                long time2 = cal.getTimeInMillis();
                long between_days = (time2 - time1) / (1000 * 3600 * 24);
                return Integer.parseInt(String.valueOf(between_days));
            } catch (ParseException e) {
            }
            return 0;
        }

        /**
         * 字符串的日期格式的计算, (yyyy-MM-dd格式)
         *
         * @param smdate
         *            较小的时间
         * @param bdate
         *            较大的时间
         * @return
         * @throws ParseException
         */
        public static int daysBetween(String smdate, String bdate) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();
                cal.setTime(sdf.parse(smdate));
                long time1 = cal.getTimeInMillis();
                cal.setTime(sdf.parse(bdate));
                long time2 = cal.getTimeInMillis();
                long between_days = (time2 - time1) / (1000 * 3600 * 24);

                return Integer.parseInt(String.valueOf(between_days));
            } catch (ParseException e) {
            }
            return 0;
        }

        /**
         * float 类型相加
         *
         * @param f1
         * @param f2
         * @return
         */
        public static float floatAdd(Float f1, Float f2) {
            float result = 0f;
            if (f1 == null)
                f1 = 0f;
            else if (f2 == null)
                f2 = 0f;
            BigDecimal b1 = new BigDecimal(Float.toString(f1));
            BigDecimal b2 = new BigDecimal(Float.toString(f2));
            result = b1.add(b2).floatValue();
            return result;
        }

        /**
         * float 类型相减
         *
         * @param f1
         * @param f2
         * @return
         */
        public static float floatSubtract(Float f1, Float f2) {
            float result = 0f;
            if (f1 == null)
                f1 = 0f;
            else if (f2 == null)
                f2 = 0f;
            BigDecimal b1 = new BigDecimal(Float.toString(f1));
            BigDecimal b2 = new BigDecimal(Float.toString(f2));
            result = b1.subtract(b2).floatValue();
            return result;
        }

        /**
         * 进行乘法运算
         *
         * @param f1
         * @param f2
         * @return
         */
        public static float floatMul(Float f1, Float f2) {
            BigDecimal b1 = new BigDecimal(Float.toString(f1));
            BigDecimal b2 = new BigDecimal(Float.toString(f2));
            return b1.multiply(b2).floatValue();
        }

        /**
         * 进行除法运算
         *
         * @param f1
         * @param f2
         * @return
         */
        public static float floatDiv(Float f1, Float f2, int len) {
            return floatDiv(f1, f2, len, BigDecimal.ROUND_HALF_UP);
        }

        /**
         *
         * @param f1
         * @param f2
         * @param len
         * @param roundingMode
         * @see {@link BigDecimal#ROUND_UP}
         * @see {@link BigDecimal#ROUND_DOWN}
         * @see {@link BigDecimal#ROUND_CEILING}
         * @see {@link BigDecimal#ROUND_FLOOR}
         * @see {@link BigDecimal#ROUND_HALF_UP}
         * @see {@link BigDecimal#ROUND_HALF_DOWN}
         * @see {@link BigDecimal#ROUND_HALF_EVEN}
         * @see {@link BigDecimal#ROUND_UNNECESSARY}
         * @return
         */
        public static float floatDiv(Float f1, Float f2, int len, int roundingMode) {
            BigDecimal b1 = new BigDecimal(Float.toString(f1));
            BigDecimal b2 = new BigDecimal(Float.toString(f2));
            return b1.divide(b2, len, roundingMode).floatValue();
        }

        /**
         * 提供精确的小数位四舍五入处理
         *
         * @param v
         *            需要四舍五入的数字
         * @param scale
         *            小数点后保留几位
         * @param round_mode
         *            指定的舍入模式 BigDecimal.ROUND_UP,ROUND_DOWN...8种
         * @return 四舍五入后的结果
         */
        public static float round(float v, int scale, int round_mode) {
            if (scale < 0) {
                throw new IllegalArgumentException(
                        "The scale must be a positive integer or zero");
            }
            BigDecimal b = new BigDecimal(String.valueOf(v));
            return b.setScale(scale, round_mode).floatValue();
        }

        /**
         * 返回处理过的银行卡信息
         *
         * @param card
         * @return
         */
        public static String getBankCard(String card) {
            StringBuilder sb = new StringBuilder(32);
            sb.append(card.substring(0, 4))
                    .append(card.substring(4, card.length() - 4).replaceAll(".",
                            "*")).append(card.substring(card.length() - 4));
            return sb.toString();
        }

        public static String middleSymbol(String str, int offset, String sign) {
            StringBuilder sb = new StringBuilder(str.length() + 10);
            sb.append(str.substring(0, offset))
                    .append(str.substring(offset, str.length() - offset)
                            .replaceAll(".", sign))
                    .append(str.substring(str.length() - offset));
            return sb.toString();
        }

        // 把原图地址转换为缩略图地址
        public static String getThumbUrl(String imgurl) {
            return imgurl == null ? null : imgurl.replace(".", "_thumb.");
        }

        public static String getIp(HttpServletRequest request) {
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");

            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            String[] retIp = ip.split(",");
            return retIp[0].trim();
        }

        /**
         * 返回四位随机数.
         *
         * @return
         */
        public static String rundomFourLength() {
            return String.valueOf((int) (Math.random() * 9000 + 1000));
        }

        /**
         * 将右边的字符替换成星号"*".
         *
         * @param str
         * @param startIdx
         *            从左边第几个字符开始.
         * @return
         */
        public static String replaceRightAsterisk(String str, int startIdx) {
            StringBuilder sb = new StringBuilder();
            if (str.length() > startIdx) {
                sb.append(str.substring(0, startIdx));
                sb.append(str.substring(startIdx).replaceAll(".", "*"));
            } else {
                sb.append(str);
            }
            return sb.toString();
        }

        /**
         * 字符串后面补充字符
         *
         * @param str
         *            要补充字符的字符串
         * @param length
         *            小于这个长度就补充字符
         * @param c
         *            填充字符
         */
        public static String fillRightCharSequence(String str, int length, char c) {
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(str);
            if (str.length() < length) {
                int n = length - str.length();
                for (int i = 0; i < n; i++) {
                    sBuilder.append(c);
                }
            }
            return sBuilder.toString();
        }

        /***
         * 获取CVersion
         *
         * @return
         */
        public static Long getCVersion() {
            return System.currentTimeMillis();
        }

        /**
         * 将数值扩大指定倍数
         *
         * @param val
         * @param times
         * @return
         */
        public static long enlarge(double val, int times) {
            if (times == 0) {
                times = 1;
            }
            return (long) (val * times);
        }

        /**
         * 将数值扩大指定倍数
         *
         * @param val
         * @param times
         * @return
         */
        public static long enlarge(float val, int times) {
            if (times == 0) {
                times = 1;
            }
            return (long) (val * times);
        }

        /**
         * 验证身份证是否符合
         *
         * @param str
         * @return
         */
        public static boolean matcheIdCard(String str) {
            Pattern pat = Pattern
                    .compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
            Matcher mat = pat.matcher(str);
            return mat.matches();
        }

        /**
         * 是否是今天
         *
         * @param date
         * @return
         */
        public static boolean isToday(final Date date) {
            return isTheDay(date, DateUtils.getNow());
        }

        /**
         * 是否是指定日期
         *
         * @param date
         * @param day
         * @return
         */
        public static boolean isTheDay(final Date date, final Date day) {
            return date.getTime() >= DateUtils.dayBegin(day).getTime()
                    && date.getTime() <= DateUtils.dayEnd(day).getTime();
        }

        public static int compare_date(Date dt1, String DATE2) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            try {
                Date dt2 = df.parse(DATE2);
                if (dt1.getTime() > dt2.getTime()) {
                    System.out.println("dt1 在dt2前");
                    return 1;
                } else if (dt1.getTime() < dt2.getTime()) {
                    System.out.println("dt1在dt2后");
                    return -1;
                } else {
                    return 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return 0;
        }

        public static Date getNextDay(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            date = calendar.getTime();
            return date;
        }
}
