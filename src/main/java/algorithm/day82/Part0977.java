package algorithm.day82;

/**
 * 977. 有序数组的平方
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class Part0977 {
    // 双指针
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int i = 0, j = A.length - 1, k = A.length - 1;
        while (i <= j) {
            if (A[i] + A[j] < 0) {
                ans[k--] = A[i] * A[i];
                i++;
            } else {
                ans[k--] = A[j] * A[j];
                j--;
            }
        }
        return ans;
    }
}
