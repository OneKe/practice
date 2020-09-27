package algorithm.day47;

import org.junit.Test;

import java.util.List;

public class Part0257Test {
    //[1,2,3,null,5]
    @Test
    public void test01() {
        Part0257 test = new Part0257();
        Part0257.TreeNode node = new Part0257.TreeNode(1);
        Part0257.TreeNode left1 = new Part0257.TreeNode(2);
        node.left = left1;
        node.right = new Part0257.TreeNode(3);
        left1.right = new Part0257.TreeNode(5);
        List<String> list = test.binaryTreePaths(node);
        System.out.println(list);
    }
}