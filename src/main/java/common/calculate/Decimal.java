package common.calculate;

import java.math.BigDecimal;

public class Decimal {
    /**
     * 加法
     */
    public static String add(String origin, String passive) {
        return new BigDecimal(origin).add(new BigDecimal(passive)).toPlainString();
    }

    public static double add(double origin, double passive) {
        return BigDecimal.valueOf(origin).add(BigDecimal.valueOf(passive)).doubleValue();
    }

    /**
     * 减法
     */
    public static String subtract(String origin, String passive) {
        return new BigDecimal(origin).subtract(new BigDecimal(passive)).toPlainString();
    }

    public static double subtract(double origin, double passive) {
        return BigDecimal.valueOf(origin).subtract(BigDecimal.valueOf(passive)).doubleValue();
    }

    /**
     * 乘法
     */
    public static String multiply(String origin, String passive) {
        return new BigDecimal(origin).multiply(new BigDecimal(passive)).toPlainString();
    }

    public static double multiply(double origin, double passive) {
        return BigDecimal.valueOf(origin).multiply(BigDecimal.valueOf(passive)).doubleValue();
    }

    /**
     * 除法，保留两位小数，四舍五入
     */
    public static String divide(String origin, String passive) {
        return new BigDecimal(origin).divide(new BigDecimal(passive), 2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

    public static double divide(double origin, double passive) {
        return BigDecimal.valueOf(origin).divide(BigDecimal.valueOf(passive), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
