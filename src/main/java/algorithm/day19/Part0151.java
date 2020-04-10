package algorithm.day19;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class Part0151 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder builder = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if ("".equals(strings[i])) {
                continue;
            }
            builder.append(strings[i].trim()).append(" ");
        }
        String result = builder.toString();
        if (result.endsWith(" ")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
