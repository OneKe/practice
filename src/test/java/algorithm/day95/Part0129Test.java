package algorithm.day95;

import org.junit.Test;

public class Part0129Test {
    @Test
    public void test01() {
        Part0129 tset = new Part0129();
        Part0129.TreeNode root = new Part0129.TreeNode(4);
        Part0129.TreeNode left = new Part0129.TreeNode(9);
        root.left = left;
        root.right = new Part0129.TreeNode(0);
        left.left = new Part0129.TreeNode(5);
        left.right = new Part0129.TreeNode(1);
        int i = tset.sumNumbers(root);
        System.out.println(i);
    }
}