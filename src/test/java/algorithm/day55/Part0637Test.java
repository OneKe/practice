package algorithm.day55;

import algorithm.leetcode.Part0637;
import org.junit.Test;

import java.util.List;

public class Part0637Test {
    @Test
    public void test01() {
        Part0637 test = new Part0637();
        Part0637.TreeNode root = new Part0637.TreeNode(3);
        Part0637.TreeNode right = new Part0637.TreeNode(20);
        root.left = new Part0637.TreeNode(9);
        root.right = right;
        right.left = new Part0637.TreeNode(15);
        right.right = new Part0637.TreeNode(7);
        List<Double> doubles = test.averageOfLevels(root);
        System.out.println(doubles);
    }
}