package algorithm.day2;

import org.junit.Test;

import java.util.Arrays;

public class Part0040Test {

    @Test
    public void getLeastNumbers() {
        Part0040 part0040 = new Part0040();
        int[] arr = {3,2,1};
        int k = 2;
        int[] ints = part0040.getNumber(arr, k);
        System.out.println(Arrays.toString(ints));
    }
}