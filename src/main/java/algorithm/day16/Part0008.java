package algorithm.day16;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 */
public class Part0008 {
    public int myAtoi(String str) {
        String trim = str.trim();
        char[] chars = trim.toCharArray();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i == 0) {
                if (c == '+') {
                    continue;
                }
                if (c == '-' || (c >= '0' && c <= '9')) {
                    b.append(c);
                } else {
                    break;
                }
            } else {
                if (c >= '0' && c <= '9') {
                    b.append(c);
                } else {
                    break;
                }
            }
        }
        if (b.toString().isEmpty() || "-".equals(b.toString())) {
            return 0;
        }
        try {
            return Integer.parseInt(b.toString());
        } catch (NumberFormatException nfe) {
            return b.toString().charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
