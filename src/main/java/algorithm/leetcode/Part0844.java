package algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 844. 比较含退格的字符串
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
public class Part0844 {
    public boolean backspaceCompare(String S, String T) {
        if (Objects.equals(S, T)) {
            return true;
        }
        Deque<Character> q1 = new ArrayDeque<>();
        Deque<Character> q2 = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if ('#' == c) {
                if (!q1.isEmpty()) {
                    q1.pop();
                }
            } else {
                q1.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if ('#' == c) {
                if (!q2.isEmpty()) {
                    q2.pop();
                }
            } else {
                q2.push(c);
            }
        }
        return q1.toString().equals(q2.toString());
    }
}
