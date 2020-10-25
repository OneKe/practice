package algorithm.day91;

/**
 * 845. 数组中的最长山脉
 * <p>
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * ·B.length >= 3
 * ·存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 */
public class Part0845 {
    public int longestMountain(int[] A) {
        int ans = 0, n = A.length;

        int i = 0;
        while (i < n) {
            int up = 0, down = 0;
            while (i < n - 1 && A[i] < A[i + 1]) {
                i++;
                up++;
            }
            if (up > 0) {
                while (i < n - 1 && A[i] > A[i + 1]) {
                    i++;
                    down++;
                }
            }
            // 找到山脉（同时成功完成爬坡和下坡），更新答案
            if (up > 0 && down > 0) {
                ans = Math.max(ans, up + down + 1);
            }
            // 爬坡失败，需要往前移动一个位置
            if (up == 0) {
                i++;
            }
        }
        return ans;
    }
}
