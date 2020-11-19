package algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 * <p>
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 */
public class Part0973 {
    public int[][] kClosest(int[][] points, int K) {
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            // 如果堆中不足 K 个，直接将当前 point 加入即可
            // 否则，判断当前点的距离是否小于堆中的最大距离，若是，则将堆中最大距离poll出，将当前点加入堆中。
            if (pq.size() < K) {
                pq.offer(point);

            } else if (pq.comparator().compare(point, pq.peek()) > 0) {
                pq.poll();
                pq.offer(point);
            }
        }
        // 返回堆中的元素
        int[][] res = new int[pq.size()][2];
        int idx = 0;
        for (int[] point : pq) {
            res[idx++] = point;
        }
        return res;
    }

    public int[][] kClosest0(int[][] points, int K) {
        return Arrays.stream(points).sorted(Comparator.comparingInt(x -> (x[0] * x[0] + x[1] * x[1]))).limit(K).toArray(int[][]::new);
    }
}
