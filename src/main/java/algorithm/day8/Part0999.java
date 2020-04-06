package algorithm.day8;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
 * 另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 */
public class Part0999 {
    public int numRookCaptures(char[][] board) {
        //只有一个车
        int x = -1, y = -1;
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('R' == (board[i][j])) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if (x == -1) {
            return sum;
        }
        int[] row = {-1, 1};
        for (int value : row) {
            int p = x + value;
            int q = y + value;
            while (p >= 0 && p < 8) {
                if (board[p][y] == 'B') {
                    break;
                } else if (board[p][y] == 'p') {
                    sum++;
                    break;
                }
                p += value;
            }
            while (q >= 0 && q < 8) {
                if (board[x][q] == 'B') {
                    break;
                } else if (board[x][q] == 'p') {
                    sum++;
                    break;
                }
                q += value;
            }
        }
        return sum;
    }
}
