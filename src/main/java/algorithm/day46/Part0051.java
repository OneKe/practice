package algorithm.day46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 提示：
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class Part0051 {
    private final List<List<String>> res = new ArrayList<>();
    /**
     * 【八皇后】【回溯】
     */
    public List<List<String>> solveNQueens(int n) {
        boolean[] usedX = new boolean[n];               // 横
        boolean[] usedY = new boolean[n];               // 竖
        boolean[] usedDiff = new boolean[2 * n - 1];      // 斜
        boolean[] usedSum = new boolean[2 * n - 1];       // 斜
        char[][] tempRes = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(tempRes[i], '.');
        }
        traceBack(tempRes, 0, n, usedX, usedY, usedDiff, usedSum);
        return res;
    }

    // tempRes为暂存数组(记录数组)，layer为层数(实际就是行数)，以及used数组
    private void traceBack(char[][] tempRes, int layer, int n, boolean[] usedX, boolean[] usedY, boolean[] usedDiff, boolean[] usedSum) {
        if (layer == n) {
            res.add(transform(tempRes, n));
            return;
        }
        int i = layer;
        for (int j = 0; j < n; j++) {
            if (!usedX[i] && !usedY[j] && !usedDiff[i - j + n - 1] && !usedSum[i + j]) {
                tempRes[i][j] = 'Q';
                usedX[i] = true;
                usedY[j] = true;
                usedDiff[i - j + n - 1] = true;
                usedSum[i + j] = true;
                traceBack(tempRes, layer + 1, n, usedX, usedY, usedDiff, usedSum);
                tempRes[i][j] = '.';
                usedX[i] = false;
                usedY[j] = false;
                usedDiff[i - j + n - 1] = false;
                usedSum[i + j] = false;
                // 不要忘记手动回溯>_<
            }
        }
    }

    // 将数组char[][]转化为题目要求的List<String>
    private List<String> transform(char[][] tempRes, int n) {
        List<String> realRes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            realRes.add(new String(tempRes[i]));
        }
        return realRes;
    }
}
