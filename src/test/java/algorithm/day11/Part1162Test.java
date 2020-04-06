package algorithm.day11;

import org.junit.Test;

public class Part1162Test {

    @Test
    public void maxDistance() {
        int[][] arr = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] arr1 = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        Part1162 test = new Part1162();
        int i = test.maxDistance(arr);
        System.out.println(i);
    }
}