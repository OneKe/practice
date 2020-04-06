package algorithm.day15;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 */
public class Part0289 {
    public int[][] gameOfLife(int[][] board) {
        int[] row = {-1, 0, 1};
        int[] col = {-1, 0, 1};
        int[][] changes = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                checkChangeOrNot(board, changes, i, j, row, col);
            }
        }
        for (int i = 0; i < changes.length; i++) {
            for (int j = 0; j < changes[i].length; j++) {
                if (changes[i][j] == 1) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {//s.length表示行数
            System.out.print("{");
            for (int j = 0; j < board[i].length; j++) {//s[i].length表示列数
                System.out.print(board[i][j] + " ");
            }
            System.out.print("}");
            System.out.println();
        }
        return board;
    }

    private void checkChangeOrNot(int[][] board, int[][] changes, int i, int j, int[] row, int[] col) {
        int tempLive = 0;
        int tempDead = 0;
        for (int r : row) {
            for (int c : col) {
                if (r == 0 && c == 0) {
                    continue;
                }
                if (i + r >= 0 && i + r < board.length && j + c >= 0 && j + c < board[0].length) {
                    if (board[i][j] == 0 && board[i + r][j + c] == 1) {
                        ++tempLive;
                    }
                    if (board[i][j] == 1 && board[i + r][j + c] == 1) {
                        ++tempDead;
                    }
                }
            }
        }
        if ((board[i][j] == 0 && tempLive == 3) || (board[i][j] == 1 && (tempDead < 2 || tempDead > 3))) {
            changes[i][j] = 1;
        }

    }
}
