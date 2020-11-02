package algorithm.day97;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Part0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> ans = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                ans.add(n);
            }
        }
        int[] ints = new int[ans.size()];
        int index = 0;
        for (Integer an : ans) {
            ints[index++] = an;
        }
        return ints;
    }
}
