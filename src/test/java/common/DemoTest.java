package common;

import org.junit.Test;

public class DemoTest {
    public static int StrToInt(String str) {
        if (str.equals( "" ) || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int shouwei = 0;
        if (a[0] == '-')
            shouwei = 1;
        int sum = 0;
        for (int i = shouwei; i < a.length; i++) {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return shouwei == 0 ? sum : sum * -1;
    }

    @Test
    public void test01() {
        String test2 = "-213+3";
        String test1 = "12334";
//        System.out.println( Integer.valueOf( test2 ) );
        System.out.println( StrToInt( test2 ) );
    }
}
