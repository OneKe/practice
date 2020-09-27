package algorithm.day61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class Part0047 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, visited, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                break;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, list);
            visited[i] = false;
            list.removeLast();
        }
    }
}
