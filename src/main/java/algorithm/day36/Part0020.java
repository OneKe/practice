package algorithm.day36;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 */
public class Part0020 {
    /*很秒，如果是正括号就向栈里放反括号，学到了*/
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
