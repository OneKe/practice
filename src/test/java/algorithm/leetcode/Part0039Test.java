package algorithm.leetcode;

import org.junit.Test;

import java.util.List;

public class Part0039Test {
    @Test
    public void test01() {
        Part0039 test = new Part0039();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = test.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }
}