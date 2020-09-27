package algorithm.day44;

import org.junit.Test;

public class Part0486Test {
    @Test
    public void test01() {
        Part0486 test = new Part0486();
        int[] arr = {1, 5, 2};
        boolean b = test.PredictTheWinner(arr);
        System.out.println(b);
    }
}