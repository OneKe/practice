package algorithm.leetcode;

/**
 * 1365. 有多少小于当前数字的数字
 * <p>
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 */
public class Part1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] hash = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            hash[i] += hash[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : hash[nums[i] - 1];
        }
        return ret;
    }
}
