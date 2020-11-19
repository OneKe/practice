package algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Part0349Test {
    @Test
    public void test01() {
        Part0349 test = new Part0349();
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = test.intersection(num1, num2);
        System.out.println(Arrays.toString(res));
    }
}