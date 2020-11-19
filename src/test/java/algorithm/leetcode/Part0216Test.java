package algorithm.leetcode;

import org.junit.Test;

import java.util.List;

public class Part0216Test {
    @Test
    public void test01() {
        Part0216 test = new Part0216();
        //k = 3, n = 9
        List<List<Integer>> lists = test.combinationSum3(3, 9);
        System.out.println(lists);
    }
}