package algorithm.day71;

import org.junit.Test;

public class Part0117Test {
    @Test
    public void test01() {
        Part0117 test = new Part0117();
        Part0117.Node root = new Part0117.Node(1);
        Part0117.Node left = new Part0117.Node(2);
        Part0117.Node right = new Part0117.Node(3);
        root.left = left;
        root.right = right;
        left.left = new Part0117.Node(4);
        left.right = new Part0117.Node(5);
        right.right = new Part0117.Node(7);
        Part0117.Node node = test.connect0(root);
        System.out.println(node);
    }
}