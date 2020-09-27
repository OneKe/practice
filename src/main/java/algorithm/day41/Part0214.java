package algorithm.day41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 */
public class Part0214 {
    //超时
    public String shortestPalindrome(String s) {
        if (s.length() < 2 || isPalindrome(s)) {
            return s;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            String temp = s.substring(0, i);
            if (isPalindrome(temp)) {
                list.add(i);
            }
        }
        if (!list.isEmpty()) {
            return new StringBuilder(s.substring(list.get(list.size() - 1))).reverse().append(s).toString();
        }
        return null;
    }

    private boolean isPalindrome(String s) {
        int l = s.toCharArray().length;
        for (int i = 0; i < l / 2; i++) {
            if (s.toCharArray()[i] != s.toCharArray()[l - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * KMP
     */
    public String shortestPalindrome0(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String str = s + "#" + rev;
        int[] next = new int[str.length()];
        next[0] = 0;
        int len = 0;
        int i = 1;
        char[] chars = str.toCharArray();
        while (i < str.length()) {
            if (chars[i] == chars[len]) {
                len++;
                next[i] = len;
                i++;
            } else {
                if (len == 0) {
                    next[i] = 0;
                    i++;
                } else {
                    len = next[len - 1];
                }
            }
        }
        System.out.println("KMP array:" + Arrays.toString(next));
        int maxLen = next[str.length() - 1]; // 最长回文前缀的长度
        return new StringBuilder(s.substring(maxLen)).reverse().append(s).toString();
    }
}