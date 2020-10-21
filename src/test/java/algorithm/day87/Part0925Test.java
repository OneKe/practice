package algorithm.day87;

import org.junit.Test;

public class Part0925Test {
    @Test
    public void test01() {
        Part0925 test = new Part0925();
        String name = "leelee";
        String typed = "lleeelee";
        boolean b = test.isLongPressedName(name, typed);
        System.out.println(b);
    }
}