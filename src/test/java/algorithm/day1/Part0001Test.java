package algorithm.day1;

import org.junit.Test;

import java.util.Arrays;

public class Part0001Test {
    @Test
    public void test01() {
        Part0001 test = new Part0001();
        int[] nums = {9, 2, 5, 25, 17, 60, 41, 6, 13};
        int[] ints = test.twoSum(nums, 42);
        System.out.println(Arrays.toString(ints));
    }
}