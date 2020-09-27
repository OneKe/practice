package algorithm.day51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Part0077 {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || k > n) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        //个数为 1 的所有可能
        for (int i = 1; i <= n + 1 - k; i++) res.add(Collections.singletonList(i));
        //第一层循环，从 2 到 k
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            //第二层循环，遍历之前所有的结果
            for (List<Integer> list : res) {
                //第三次循环，对每个结果进行扩展
                //从最后一个元素加 1 开始，然后不是到 n ，而是和解法一的优化一样
                //(k - (i - 1） 代表当前已经有的个数，最后再加 1 是因为取了 n
                for (int m = list.get(list.size() - 1) + 1; m <= n - (k - (i - 1)) + 1; m++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(m);
                    tmp.add(newList);
                }
            }
            res = tmp;
        }
        return res;
    }
}
