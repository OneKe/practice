package algorithm.day54;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class Part0216 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, new LinkedList<>());
        return res;
    }

    private void dfs(int k, int n, int start, LinkedList<Integer> list) {
        if (0 == k || n <= 0) {
            if (0 == k && n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 9; i >= start; i--) {
            list.add(i);
            dfs(k - 1, n - i, i + 1, list);
            list.removeLast();
        }
    }
}
