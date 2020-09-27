package algorithm.day57;

import org.junit.Test;

import java.util.List;

public class Part0094Test {
    @Test
    public void test01() {
        Part0094 test = new Part0094();
        Part0094.TreeNode root = new Part0094.TreeNode(1);
        Part0094.TreeNode right = new Part0094.TreeNode(2);
        root.right = right;
        right.left = new Part0094.TreeNode(3);
        List<Integer> list = test.inorderTraversal(root);
        System.out.println(list);
    }
}