package algorithm.day42;

/**
 * easy：给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Part0557 {
    /**
     * 示例：
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * 先反转整个字符串，然后倒排放入新的字符串
     */
    public String reverseWords(String s) {
        String str = new StringBuilder(s).reverse().toString();
        String[] split = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            builder.append(split[i]).append(" ");
        }
        if (builder.toString().endsWith(" ")) {
            return builder.substring(0, builder.length() - 1);
        }
        return builder.toString();
    }
}
