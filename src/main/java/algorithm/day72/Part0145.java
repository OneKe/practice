package algorithm.day72;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class Part0145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> q1 = new ArrayDeque<>();
        Deque<TreeNode> q2 = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q1.push(root);
        while (!q1.isEmpty()) {
            TreeNode node = q1.pop();
            q2.push(node);
            if (node.left != null) {
                q1.push(node.left);
            }
            if (node.right != null) {
                q1.push(node.right);
            }
        }
        while (!q2.isEmpty()) {
            res.add(q2.pop().val);
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
