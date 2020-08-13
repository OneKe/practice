package algorithm.day35;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Part0043 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int length1 = array1.length;
        int length2 = array2.length;
        int[] res = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--) {
            int n1 = array1[i] - '0';
            for (int j = length2 - 1; j >= 0; j--) {
                int n2 = array2[j] - '0';
                int ans = n1 * n2 + res[i + j + 1];
                res[i + j] += ans / 10;
                res[i + j + 1] = ans % 10;
            }
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && i == 0) {
                continue;
            }
            b.append(res[i]);

        }
        return b.toString();
    }

}
