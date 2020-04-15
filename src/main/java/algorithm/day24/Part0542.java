package algorithm.day24;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 */
public class Part0542 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int[][] res = new int[matrix.length][matrix[0].length];
        int[] col = {1, -1, 0, 0};
        int[] row = {0, 0, 1, -1};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    continue;
                }
                bfs(matrix, res, i, j, col, row);
            }
        }
        return res;
    }

    /**
     * 错误的，题理解错了
     */
    private void bfs(int[][] matrix, int[][] res, int x, int y, int[] col, int[] row) {
        boolean flag = true;
        int temp = 1;
        while (flag) {
            for (int i = 0; i < 4; i++) {
                int p = x + col[i] * temp;
                int q = y + row[i] * temp;
                if (p >= matrix.length || p < 0 || q >= matrix[x].length || q < 0) {
                    continue;
                }
                if (matrix[p][q] == 0) {
                    res[x][y] = temp;
                    flag = false;
                    break;
                }
            }
            ++temp;
        }
    }

    /**
     * 正确答案
     */
    public int[][] updateMatrix0(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];//结果集
        boolean[][] visited = new boolean[m][n];//记录已经计算过的位置
        Queue<int[]> queue = new LinkedList<>();//广搜队列
        //遍历，将等于0的位置计入结果集并入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //四个方向广搜
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//上下左右
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            //四个方向上找 1
            for (int k = 0; k < 4; k++) {
                int di = i + direction[k][0], dj = j + direction[k][1];
                //没有计算过的地方一定是 1
                if (di >= 0 && di < m && dj >= 0 && dj < n && !visited[di][dj]) {
                    res[di][dj] = res[i][j] + 1;
                    visited[di][dj] = true;
                    queue.offer(new int[]{di, dj});
                }
            }
        }
        return res;
    }
}
