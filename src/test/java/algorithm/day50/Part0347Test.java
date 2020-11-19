package algorithm.day50;

import org.junit.Test;

import java.util.Arrays;


public class Part0347Test {
    @Test
    public void test01() {
        //输入: nums = [1,1,1,2,2,3], k = 2
        //[4,1,-1,2,-1,2,3]
        //2
        Part0347 test = new Part0347();
//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] s = test.topKFrequent(nums, 2);
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int[] s = test.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(s));
    }
}