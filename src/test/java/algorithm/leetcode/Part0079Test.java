package algorithm.leetcode;

import org.junit.Test;

public class Part0079Test {
    @Test
    public void test01() {
        Part0079 test = new Part0079();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean exist = test.exist(board, word);
        System.out.println(exist);
    }
}