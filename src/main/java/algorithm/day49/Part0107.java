package algorithm.day49;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Part0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        dfs(lists, root, 0);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= lists.size()) {
            lists.add(0, new ArrayList<>());
        }
        //这里就相当于从后往前打印了
        lists.get(lists.size() - level - 1).add(node.val);
        //当前节点访问完之后，再使用递归的方式分别访问当前节点的左右子节点
        dfs(lists, node.left, level + 1);
        dfs(lists, node.right, level + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * BFS
     *
     * @param root TreeNode
     * @return result
     */
    public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // 在索引 0 的位置加入一维数组 tmp
            // 每次新的数组进来都会被放在开始的位置
            ans.add(0, tmp);
        }
        return ans;
    }
}
