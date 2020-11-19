package algorithm.leetcode;

/**
 * 234. 回文链表
 * <p>
 * 请判断一个链表是否为回文链表。
 */
public class Part0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            //链表反转
            pre.next = prepre;
            prepre = pre;
        }
        //如果不是null，证明链表长度是奇数，中间位不参与回文比较
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
