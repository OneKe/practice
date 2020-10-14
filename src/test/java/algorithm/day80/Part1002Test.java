package algorithm.day80;

import org.junit.Test;

import java.util.List;

public class Part1002Test {
    @Test
    public void test01() {
        Part1002 test = new Part1002();
        String[] A = {"cool", "lock", "cook"};
        List<String> list = test.commonChars(A);
        System.out.println(list);
    }
}