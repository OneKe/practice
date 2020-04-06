package algorithm.day14;

/**
 * 有效括号的嵌套深度
 */
public class Part1111 {
    public int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int deep = 0;
        char c;
        int[] result = new int[seq.length()];
        for (int i = 0; i < chars.length; i++) {
            c = chars[i];
            if ('(' == c) {
                result[i] = deep % 2;
                deep++;
            } else {
                --deep;
                result[i] = deep % 2;
            }
        }
        return result;
    }
}
