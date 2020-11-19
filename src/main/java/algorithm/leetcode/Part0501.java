package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 */
public class Part0501 {
    private TreeNode preNode = null;
    private int curCount = 1;
    private int maxCount = 1;

    public int[] findMode(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        int i = 0;
        int[] res = new int[nums.size()];
        for (int num : nums) {
            res[i++] = num;
        }
        return res;
    }

    private void dfs(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        dfs(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) {
                curCount++;
            } else {
                curCount = 1;
            }
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            nums.clear();
            nums.add(node.val);
        } else if (curCount == maxCount) {
            nums.add(node.val);
        }
        preNode = node;
        dfs(node.right, nums);
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
