package algorithm.leetcode;

import org.junit.Test;

public class Part0106Test {
    @Test
    public void test01() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Part0106 test = new Part0106();
        Part0106.TreeNode tree = test.buildTree(inorder, postorder);
        System.out.println(tree);
    }
}