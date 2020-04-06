package algorithm.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 */
public class Part0945 {
    public int minIncrementForUnique(int[] A) {
        int len = A.length;
        if (len < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int c : A) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count;
        AtomicInteger sum = new AtomicInteger(0);
        do {
            count = sum.get();
            doSomething(map, sum);

        } while (count != sum.get());
        return sum.get();
    }

    private void doSomething(Map<Integer, Integer> map, AtomicInteger sum) {
        map.entrySet().parallelStream().filter(e -> e.getValue() > 1).forEach(entry -> {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            map.put(k, v - 1);
            map.put(k + 1, map.getOrDefault(k + 1, 0) + 1);
            sum.incrementAndGet();
        });
    }

    public int minIncrementForUnique1(int[] A) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        Arrays.sort(A);
        while (true) {
            for (int i = 0; i < A.length; i++) {
                if (set.contains(A[i])) {
                    count++;
                    A[i]++;
                }
                set.add(A[i]);
            }
            if (set.size() == A.length) {
                break;
            }
            set.clear();
        }
        return count;
    }


    public int minIncrementForUnique3(int[] A) {
        Arrays.sort(A); // 先排序
        int curmax = -1; // 当前数组最大值
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= curmax) {
                int ai = curmax + 1; // 当前元素 A[i] 需要增加到 curmax + 1
                res += (ai - A[i]); // 记录自增次数
                A[i] = ai; // 增加当前元素
            }
            curmax = Math.max(curmax, A[i]);
        }
        return res;
    }

}
