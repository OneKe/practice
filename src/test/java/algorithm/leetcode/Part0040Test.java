package algorithm.leetcode;

import org.junit.Test;

import java.util.List;

public class Part0040Test {
    @Test
    public void test01() {
        //candidates = [10,1,2,7,6,1,5], target = 8,
        Part0040 test = new Part0040();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = test.combinationSum2(candidates, 8);
        System.out.println(lists);
    }
}