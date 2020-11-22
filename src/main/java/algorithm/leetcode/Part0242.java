package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Part0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int length = sArray.length;
        for (int i = 0; i < length; i++) {
            map.put(sArray[i], map.getOrDefault(sArray[i], 0) + 1);
            map.put(tArray[i], map.getOrDefault(tArray[i], 0) - 1);
        }
        return map.values().stream().allMatch(e -> e == 0);
    }
}