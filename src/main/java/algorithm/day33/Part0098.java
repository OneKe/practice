package algorithm.day33;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Part0098 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        long lastVal = Long.MIN_VALUE;

        while (!st.empty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (root.val <= lastVal) return false;
            lastVal = root.val;
            root = root.right;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
