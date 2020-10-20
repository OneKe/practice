package algorithm.day86;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 143. 重排链表
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Part0143 {
    /**
     * 双向队列，不过性能还是不行。
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Deque<ListNode> queue = new ArrayDeque<>();
        for (ListNode node = head; node != null; node = node.next) {
            queue.offer(node);
        }
        if (!queue.isEmpty()) {
            head = queue.pollFirst();
        }
        while (!queue.isEmpty()) {
            head.next = queue.pollLast();
            if (!queue.isEmpty()) {
                head.next.next = queue.pollFirst();
            }
            head = head.next.next;
        }
        head.next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
