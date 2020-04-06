package algorithm.day7;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 */
public class Part0892 {
    public int surfaceArea(int[][] grid) {
        // 习惯上应该做参数检查，但题目中给出了 N >= 1 ，故可以略去
        int rows = grid.length;
        // 题目保证了输入一定是 N * N，但为了使得程序适用性更强，还是单独把 cols 做赋值
        int cols = grid[0].length;

        int sum = 0;
        // 垂直重叠
        int verticalOverlap = 0;
        // 行重叠
        int rowOverlap = 0;
        // 列重叠
        int colOverlap = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += grid[i][j];

                if (grid[i][j] > 1) {
                    verticalOverlap += (grid[i][j] - 1);
                }

                if (j > 0) {
                    rowOverlap += Math.min(grid[i][j - 1], grid[i][j]);
                }

                if (i > 0) {
                    colOverlap += Math.min(grid[i - 1][j], grid[i][j]);
                }
            }
        }
        return sum * 6 - (verticalOverlap + rowOverlap + colOverlap) * 2;
    }
}
