package algorithm.day28;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 */
public class Part1248 {
    /*不成熟的错误答案*/
    public int numberOfSubArrays(int[] nums, int k) {
        int before = 0;
        int single = 0;
        int after = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                ++single;
            }
            if (single == 0) {
                ++before;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 == 1) {
                break;
            }
            ++after;
        }
        if (single != k) {
            return 0;
        }
        return (before + 1) * (after + 1);
    }

    /*滑动窗口*/
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        int feed = 0;
        int[] arr = new int[len + 2];
        for (int i = 0; i < len; i++) {
            // if it is odd
            if ((nums[i] & 1) == 1) {
                arr[++feed] = i;
            }
        }
        // left border
        arr[0] = -1;
        // right border
        arr[feed + 1] = len;
        for (int i = 1; i + k < feed + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }
}
