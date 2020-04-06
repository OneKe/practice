package algorithm.day3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 */
public class Part0365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n + x <= x + y && set.add(n + x)) {
                q.offer(n + x);
            }
            if (n + y <= x + y && set.add(n + y)) {
                q.offer(n + y);
            }
            if (n - x >= 0 && set.add(n - x)) {
                q.offer(n - x);
            }
            if (n - y >= 0 && set.add(n - y)) {
                q.offer(n - y);
            }
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }

    public boolean answer(int x, int y, int z) {
        if (z == 0 || z == x || z == y || z == x + y) {
            return true;
        }
        int sum = x + y;
        if (sum < z || x == y) {
            return false;
        }
        if (x % 2 == 0 && y % 2 == 0) {
            return z % 2 == 0;
        }
        int difference = y - x;
        if (difference < 0) {
            difference = -difference;
        }
        if (x % difference != 0 && y % difference != 0) {
            return true;
        }
        return z % x == 0 || z % y == 0 || z % difference == 0;
    }
}
