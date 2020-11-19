package algorithm.day85;

import algorithm.leetcode.Part0844;
import org.junit.Test;

public class Part0844Test {
    @Test
    public void test01() {
        Part0844 test = new Part0844();
        boolean b = test.backspaceCompare("ab#c", "ad#c");
        System.out.println(b);
    }
}