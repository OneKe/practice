package algorithm.leetcode;

import org.junit.Test;

import java.util.List;

public class Part0113Test {
    @Test
    public void test01() {
        Part0113 test = new Part0113();
        Part0113.TreeNode root = new Part0113.TreeNode(5);
        Part0113.TreeNode left2 = new Part0113.TreeNode(4);
        Part0113.TreeNode right2 = new Part0113.TreeNode(8);
        root.left = left2;
        root.right = right2;
        Part0113.TreeNode left3 = new Part0113.TreeNode(11);
        left2.left = left3;
        left3.left = new Part0113.TreeNode(7);
        left3.right = new Part0113.TreeNode(2);
        Part0113.TreeNode right3 = new Part0113.TreeNode(4);
        right2.left = new Part0113.TreeNode(13);
        right2.right = right3;
        right3.left = new Part0113.TreeNode(5);
        right3.right = new Part0113.TreeNode(1);
        List<List<Integer>> lists = test.pathSum(root, 22);
        System.out.println(lists);
    }
}