package algorithm.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class Part0409 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>(len);
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        AtomicInteger result = new AtomicInteger(0);
        map.forEach((k, v) -> {
            if (v % 2 == 0) {
                result.addAndGet(v);
            } else {
                result.addAndGet(v - 1);
            }
        });
        if (len > result.get()) {
            result.getAndIncrement();
        }
        return result.get();
    }
}
