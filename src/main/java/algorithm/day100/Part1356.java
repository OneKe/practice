package algorithm.day100;

import java.util.Arrays;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * <p>
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 */
public class Part1356 {
    public int[] sortByBits(int[] arr) {
        //解释一下为什么是左移14位，因为arr[i]<=10^4,而2^14=16384 > 10^4
        int step = 14;
        int sum = (int) (Math.pow(2, 14) - 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] += getBitCount(arr[i]) << step;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] &= sum;
        }
        return arr;
    }

    private int getBitCount(int num) {
        int count = 0;
        while (num > 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }
}
