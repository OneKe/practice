package algorithm.day84;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 */
public class Part0019 {
    /**
     * 快慢节点，快的先走n步，当快的走到尾部时，慢的就走到倒数第n个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head, pre = head;
        while (p != null) {
            if (n <= 0) {
                pre = q;
                q = q.next;
            }
            p = p.next;
            n--;
        }
        if (n == 0) {
            return head.next;
        }
        pre.next = q.next;
        return head;
    }

    public class ListNode {
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
