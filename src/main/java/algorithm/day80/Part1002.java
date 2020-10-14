package algorithm.day80;

import java.util.LinkedList;
import java.util.List;

/**
 * 1002. 查找常用字符
 * <p>
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 */
public class Part1002 {
    public List<String> commonChars(String[] A) {
        int[] init = getCharCount(A[0]);
        for (int i = 1; i < A.length; i++) {
            int[] item = getCharCount(A[i]);

            for (int j = 0; j < init.length; j++) {
                if (init[j] > item[j]) {
                    init[j] = item[j];
                }
            }
        }
        List<String> list = new LinkedList<>();
        for (int i = 0; i < init.length; i++) {
            String e = Character.toString((char) ('a' + i));
            for (int j = init[i]; j > 0; j--) {
                list.add(e);
            }
        }
        return list;
    }

    private int[] getCharCount(String s) {
        int[] cs = new int[26];
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        return cs;
    }
}
