package common.notes;

import org.junit.Test;

public class DoTest {

    @Test
    public void test01() {
        Object o = new Object();
        System.out.println(o.equals(null));
    }

    @Test
    public void test02() {
        System.out.println(0.1 + 0.2);
        System.out.println(1.0 - 0.8);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);
        double a = 2.15d;
        double b = 1.10d;
        float c = 2.15f;
        float d = 1.10f;
        System.out.println(a - b);
        System.out.println(c - d);
        System.out.println((a - b) == (c - d));
        System.out.println(5126/100);
    }
}
