package algorithm.day30;

import org.junit.Test;

import java.util.List;

public class Part0046Test {

    @Test
    public void permute() {
        Part0046 test = new Part0046();
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = test.permute(arr);
        System.out.println(lists);
    }
}