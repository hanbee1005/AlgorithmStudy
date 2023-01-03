package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {
        ListNode head = ListNode.makeLinkedList(new int[]{1, 1, 2, 3, 3});
        ListNode node = deleteDuplicates(head);
        List<Integer> result = new ArrayList<>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }

        System.out.println(result);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode cur = head;
        ListNode post = head.next;

        while (post != null) {
            if (cur.val == post.val) {
                cur.next = post.next;
            } else {
                cur = post;
            }

            post = post.next;
        }

        return head;
    }
}
