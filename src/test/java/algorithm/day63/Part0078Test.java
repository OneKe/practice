package algorithm.day63;

import org.junit.Test;

import java.util.List;

public class Part0078Test {
    @Test
    public void test01() {
        Part0078 test = new Part0078();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = test.subsets(nums);
        System.out.println(lists);
    }
}