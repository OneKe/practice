package algorithm.day27;

/**
 * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
 * <p>
 * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * <p>
 * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
 * <p>
 * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 */
public class Part0466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        /*
         * index为c2的索引， num1当前使用了ss1的个数， num2当前匹配的ss2的个数
         */
        int index = 0, num1 = 0, num2 = 0;
        while (num1 < n1) {
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] == c2[index]) {
                    if (index == c2.length - 1) {
                        index = 0;
                        num2++;
                    } else {
                        index++;
                    }
                }
            }
            num1++;
        }
        return num2 / n2;
    }
}
