package algorithm.day62;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算给定二叉树的所有左叶子之和。
 */
public class Part0404 {
    public int sumOfLeftLeaves(TreeNode root) {
//        return dfs(root, false);
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (!(node.right.left == null && node.right.right == null)) {
                        queue.offer(node.right);
                    }
                }
                if (node.left == null && node.right == null) {
                    count += node.val;
                }
            }
        }
        return count;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int dfs(TreeNode node, boolean flag) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && flag) {
            return node.val;
        }
        int sumLeft = dfs(node.left, true);
        int sumRight = dfs(node.right, false);
        return sumLeft + sumRight;
    }
}
