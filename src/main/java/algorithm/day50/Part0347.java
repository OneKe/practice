package algorithm.day50;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class Part0347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        int[] array = counter.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).mapToInt(Map.Entry::getKey).toArray();
        return Arrays.copyOfRange(array, 0, k);
    }
}
