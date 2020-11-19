package algorithm.day66;

import algorithm.leetcode.Part0617;
import org.junit.Test;

public class Part0617Test {
    @Test
    public void test01() {
        Part0617 test = new Part0617();
        Part0617.TreeNode node1 = new Part0617.TreeNode(1);
        Part0617.TreeNode nodeLeft = new Part0617.TreeNode(3);
        node1.left = nodeLeft;
        node1.right = new Part0617.TreeNode(2);
        nodeLeft.left = new Part0617.TreeNode(5);
        Part0617.TreeNode node2 = new Part0617.TreeNode(2);
        Part0617.TreeNode node2Left = new Part0617.TreeNode(1);
        Part0617.TreeNode node2Right = new Part0617.TreeNode(3);
        node2.left = node2Left;
        node2.right = node2Right;
        node2Left.right = new Part0617.TreeNode(4);
        node2Right.right = new Part0617.TreeNode(7);
        Part0617.TreeNode treeNode = test.mergeTrees(node1, node2);
        System.out.println(treeNode);
    }
}