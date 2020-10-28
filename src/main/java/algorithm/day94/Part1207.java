package algorithm.day94;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Part1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int elem : arr) {
            counter.put(elem, counter.getOrDefault(elem, 0) + 1);
        }
        //判断是否有相同的出现次数
        Set<Integer> set = new HashSet<>();
        return counter.values().stream().allMatch(set::add);
    }
}
