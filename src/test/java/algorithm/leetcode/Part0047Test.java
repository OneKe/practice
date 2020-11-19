package algorithm.leetcode;

import org.junit.Test;

import java.util.List;

public class Part0047Test {
    @Test
    public void test01() {
        Part0047 test = new Part0047();
        int[] nums = {1, 2, 1};
        List<List<Integer>> lists = test.permuteUnique(nums);
        System.out.println(lists);
    }
}