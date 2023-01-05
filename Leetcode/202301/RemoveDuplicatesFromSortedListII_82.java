package linkedlist;

import java.util.List;

public class RemoveDuplicatesFromSortedListII_82 {
    public static void main(String[] args) {
        ListNode head = ListNode.makeLinkedList(new int[]{1, 1, 2, 2});
        ListNode node = deleteDuplicates(head);
        if (node != null) node.print();
        else System.out.println(List.of());
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = new ListNode(-101, head);
        ListNode cur = head;
        head = null;

        while (cur != null) {
            if (cur.next != null) {
                if (cur.val != cur.next.val) {
                    if (pre.next == cur) {
                        pre = cur;
                    } else {
                        pre.next = cur.next;
                    }

                    cur = cur.next;

                    if (head == null) {
                        head = pre;
                    }
                } else {
                    cur = cur.next;
                }
            } else {
                pre.next = pre.next == cur ? cur : null;
                cur = null;
            }
        }

        if (head != null && head.val == -101) {
            head = head.next;
        }

        return head;
    }
}
