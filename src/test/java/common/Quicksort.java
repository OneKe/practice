package common;

import org.junit.Test;

import java.util.Arrays;

public class Quicksort {
    @Test
    public void quicksort() {
        int[] nums = new int[]{5, 9, 10, 30, 11, 7, 4, 2};
        partition(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void partition(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = sort(nums, start, end);
        partition(nums, start, i - 1);
        partition(nums, i + 1, end);
    }

    private int sort(int[] nums, int low, int high) {
        int p = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            /*需要注意的是，这里的j--与i++的顺序不可以调换！
32          如果调换了顺序，i会走过头，以至于将后面较大的元素交换到数组开头*/
            while (i < j && nums[j] >= p) {
                j--;
            }
            while (i < j && nums[i] <= p) {
                i++;
            }
            if (i != j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[i];
        nums[i] = p;
        return i;
    }
}
