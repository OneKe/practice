package algorithm.day95;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 129. 求根到叶子节点数字之和
 * <p>
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Part0129 {
    List<List<Integer>> res = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        dfs(root, new LinkedList<>());
        int out = 0;
        for (List<Integer> list : res) {
            int count = 0;
            for (Integer i : list) {
                count = count * 10 + i;
            }
            out += count;
        }
        return out;
    }

    private void dfs(TreeNode node, LinkedList<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }
        dfs(node.left, list);
        dfs(node.right, list);
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
