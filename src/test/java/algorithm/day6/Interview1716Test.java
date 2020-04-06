package algorithm.day6;

import org.junit.Test;

import static org.junit.Assert.*;

public class Interview1716Test {

    @Test
    public void massage() {
        Interview1716 in = new Interview1716();
        int[] arr = {2,1,4,5,3,1,1,3};
        int massage = in.massage(arr);
        System.out.println(massage);
    }
}