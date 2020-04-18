package algorithm.day26;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class Part0011 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        for (int j = 0; j < height.length; j++) {
            for (int k = height.length - 1; k > j; k--) {
                int mini = Math.min(height[j], height[k]);
                res = Math.max((k - j) * mini, res);
            }
        }
        return res;
    }

    /**
     * 双指针方法
     */
    public int maxArea0(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int maxWater = 0;
        int min;
        while (i != j) {
            min = Math.min(array[i], array[j]);
            maxWater = Math.max(maxWater, (j - i) * min);
            //谁矮谁就移动
            if (min == array[i]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
    }
}
