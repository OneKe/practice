package algorithm.day38;

import org.junit.Test;

import java.util.List;

/**
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
public class Part0491Test {
    @Test
    public void test01() {
        Part0491 test = new Part0491();
        int[] arr = {4, 6, 7, 7};
        List<List<Integer>> list = test.findSubsequences(arr);
        System.out.println(list);
    }

}