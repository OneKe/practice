package algorithm.day48;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 */
public class Part0060 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int currUnitCount = 1;
        k--;
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
            currUnitCount = currUnitCount * (n - i);
        }
        for (int i = 0; i < n; i++) {
            currUnitCount = currUnitCount / (n - i);
            sb.append(nums.remove(k / currUnitCount));
            k = k % currUnitCount;
        }
        return sb.toString();
    }
}
