package algorithm.day64;

import algorithm.leetcode.Part0538;
import org.junit.Test;

public class Part0538Test {
    @Test
    public void test01() {
        Part0538 test = new Part0538();
        Part0538.TreeNode node = new Part0538.TreeNode(5);
        Part0538.TreeNode left = new Part0538.TreeNode(2);
        node.left = left;
        left.right = new Part0538.TreeNode(3);
        node.right = new Part0538.TreeNode(13);
        Part0538.TreeNode treeNode = test.convertBST(node);
        System.out.println(treeNode);
    }
}