package algorithm.day51;

import algorithm.leetcode.Part0077;
import org.junit.Test;

import java.util.List;

public class Part0077Test {
    @Test
    public void test01() {
        Part0077 test = new Part0077();
        List<List<Integer>> combine = test.combine(4, 2);
        System.out.println(combine);
    }
}