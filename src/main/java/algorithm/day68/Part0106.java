package algorithm.day68;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class Part0106 {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int count;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        count = postorder.length - 1;
        int index = 0;
        for (int i : inorder) {
            map.put(i, index++);
        }
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        int value = postorder[count];
        TreeNode node = new TreeNode(value);
        --count;
        int index = map.get(value);
        node.right = helper(inorder, postorder, index + 1, in_right);
        node.left = helper(inorder, postorder, in_left, index - 1);
        return node;
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
