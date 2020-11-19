package algorithm.leetcode;

import org.junit.Test;

public class Part0416Test {
    @Test
    public void test01() {
        Part0416 test = new Part0416();
        int[] nums = {1, 5, 11, 5};
        boolean result = test.canPartition(nums);
        System.out.println(result);
    }
}