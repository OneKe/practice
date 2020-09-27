package algorithm.day49;

import org.junit.Test;

import java.util.List;

public class Part0107Test {
    @Test
    public void test01() {
        //[3,9,20,null,null,15,7]
        Part0107 test = new Part0107();
        Part0107.TreeNode head = new Part0107.TreeNode(3);
        head.left = new Part0107.TreeNode(9);
        Part0107.TreeNode right = new Part0107.TreeNode(20);
        head.right = right;
        right.left = new Part0107.TreeNode(15);
        right.right = new Part0107.TreeNode(7);
        List<List<Integer>> lists = test.levelOrderBottom(head);
        System.out.println(lists);
    }

}