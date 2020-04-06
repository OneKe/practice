package algorithm.day9;

import java.util.*;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * <p>
 * 仅当你可选的 X >= 2 时返回 true。
 */
public class Part0914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int value : deck) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        if (set.size() >= 2) {
            Iterator<Integer> iterator = set.iterator();
            int temp = iterator.next();
            while (iterator.hasNext()) {
                temp = maxNumber(iterator.next(), temp);
                if (temp == 1) {
                    break;
                }
            }
            return temp > 1;
        }
        return true;
    }

    private int maxNumber(int m, int n) {
        int temp;
        if (n > m) {
            temp = n;
            n = m;
            m = temp;
        }
        if (m % n == 0) {
            return n;
        }
        return maxNumber(n, m % n);
    }

}
