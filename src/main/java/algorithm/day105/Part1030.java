package algorithm.day105;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 1030. 距离顺序排列矩阵单元格
 *
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
 * 其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。
 * （你可以按任何满足此条件的顺序返回答案。）
 */
public class Part1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        return IntStream.range(0, R).boxed()
                .flatMap(r -> IntStream.range(0, C).mapToObj(c -> new int[]{r, c}))
                .sorted(Comparator.comparingInt(pos -> dist(pos[0], pos[1], r0, c0)))
                .toArray(int[][]::new);
    }

    private int dist(int r, int c, int r0, int c0) {
        return Math.abs(r - r0) + Math.abs(c - c0);
    }

    /**
     * 桶排序
     */
    public int[][] allCellsDistOrder0(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }
}
