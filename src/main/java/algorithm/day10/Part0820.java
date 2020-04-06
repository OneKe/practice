package algorithm.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 */
public class Part0820 {

    public int minimumLengthEncoding(String[] words) {
        int len = words.length;
        if (len == 0) {
            return len;
        }
        if (len == 1) {
            return words[0].length() + 1;
        }
        //去重很重要
        List<String> list = Stream.of(words).distinct().collect(Collectors.toList());
        Set<String> set = new HashSet<>();
        int result = 0;
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(j).endsWith(list.get(i)) && i != j) {
                    set.add(list.get(i));
                }
            }
        }
        for (String s : list) {
            if (!set.contains(s)) {
                result = result + s.length() + 1;
            }
        }
        if (result == 0) {
            result = list.get(0).length() + 1;
        }
        return result;
    }
}
