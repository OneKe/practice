package algorithm.day69;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Part0113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        dfs(root.left, sum - root.val, list);
        dfs(root.right, sum - root.val, list);
        list.removeLast();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
