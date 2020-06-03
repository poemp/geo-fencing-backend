package org.poem.utils;

import java.math.BigDecimal;

public class NumberUtils {

    /**
     * 默认除法运算精度
     */
    public static final int DEF_DIV_SCALE = 10;


    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @return 两个参数的和
     */
    public static int add(int... v1) {
        int tempValue = 0;
        for (int value : v1) {
            BigDecimal b1 = BigDecimal.valueOf(tempValue);
            BigDecimal b2 = BigDecimal.valueOf(value);
            tempValue = b1.add(b2).intValue();
        }
        return tempValue;

    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @return 两个参数的和
     */
    public static double add(double... v1) {
        double tempValue = 0;
        for (double value : v1) {
            BigDecimal b1 = BigDecimal.valueOf(tempValue);
            BigDecimal b2 = BigDecimal.valueOf(value);
            tempValue = b1.add(b2).doubleValue();
        }
        return tempValue;

    }
    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static int sub(int v1, int v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).intValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @return 两个参数的积
     */
    public static int mul(int... v1) {
        int tempValue = 1;
        for (int value : v1) {
            BigDecimal b1 = BigDecimal.valueOf(tempValue);
            BigDecimal b2 = BigDecimal.valueOf(value);
            tempValue = b1.multiply(b2).intValue();
        }
        return tempValue;
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @return 两个参数的积
     */
    public static long mul(long... v1) {
        int tempValue = 1;
        for (long value : v1) {
            BigDecimal b1 = BigDecimal.valueOf(tempValue);
            BigDecimal b2 = BigDecimal.valueOf(value);
            tempValue = b1.multiply(b2).intValue();
        }
        return tempValue;
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @return 两个参数的积
     */
    public static double mul(double... v1) {
        double tempValue = 1D;
        for (double value : v1) {
            BigDecimal b1 = BigDecimal.valueOf(tempValue);
            BigDecimal b2 = BigDecimal.valueOf(value);
            tempValue = b1.multiply(b2).doubleValue();
        }
        return tempValue;
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static int div(int v1, int v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    private static double div(double v1, double v2, int scale) {
        if (v2 == 0) {
            return 0;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    private static int div(int v1, int v2, int scale) {
        if (v2 == 0) {
            return 0;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).intValue();
    }
}
