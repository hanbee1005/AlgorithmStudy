package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII_142 {
    public static void main(String[] args) {
        ListNode head = ListNode.makeLinkedList(new int[]{3, 2, 0 , -4}, 1);
        System.out.println(detectCycle(head));
    }

    private static ListNode detectCycle(ListNode head) {
//        ListNode pos = head;
//        Set<ListNode> set = new HashSet<>();
//        set.add(head);
//
//        while (pos.next != null) {
//            pos = pos.next;
//
//            if (set.contains(pos)) {
//                return pos;
//            }
//
//            set.add(pos);
//        }
//
//        return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
