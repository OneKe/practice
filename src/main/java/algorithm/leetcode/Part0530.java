package algorithm.leetcode;

/**
 * 530. 二叉搜索树的最小绝对差
 * <p>
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class Part0530 {
    private int preNodeValue = -1;
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (preNodeValue != -1) {
            result = Integer.min(node.val - preNodeValue, result);
        }
        preNodeValue = node.val;
        dfs(node.right);
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
