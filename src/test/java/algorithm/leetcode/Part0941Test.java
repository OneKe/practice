package algorithm.leetcode;

import org.junit.Test;

public class Part0941Test {
    @Test
    public void test01() {
        Part0941 test = new Part0941();
        int[] A = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        boolean b = test.validMountainArray(A);
        System.out.println(b);
    }
}