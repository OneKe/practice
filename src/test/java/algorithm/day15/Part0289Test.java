package algorithm.day15;

import org.junit.Test;

public class Part0289Test {

    @Test
    public void gameOfLife() {
        Part0289 test = new Part0289();
        int[][] arr = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        test.gameOfLife(arr);
    }
}