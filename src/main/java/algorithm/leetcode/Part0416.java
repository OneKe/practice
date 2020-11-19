package algorithm.leetcode;

/**
 * 416. 分割等和子集
 * <p>
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 */
public class Part0416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum >>= 1;
        boolean[] res = new boolean[sum + 1];
        res[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                res[i] = res[i] || res[i - num];
            }
        }
        return res[sum];
    }
}
