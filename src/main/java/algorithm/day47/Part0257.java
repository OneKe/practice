package algorithm.day47;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Part0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list, "" + root.val + "->");
        return list;
    }

    private void dfs(TreeNode root, List<String> list, String str) {
        if (root.left == null && root.right == null) {
            str = str.substring(0, str.length() - 2);
            list.add(str);
            return;
        }
        if (root.left != null) {
            dfs(root.left, list, str + root.left.val + "->");
        }
        if (root.right != null) {
            dfs(root.right, list, str + root.right.val + "->");
        }
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
