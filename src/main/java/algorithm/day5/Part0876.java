package algorithm.day5;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Part0876 {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new LinkedList<>();
        list.add(head);
        ListNode temp = head.next;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        return list.get(list.size() / 2);
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}