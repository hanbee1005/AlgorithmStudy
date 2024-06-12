package linkedlist;

public class LinkedListCycle_141 {
    public static void main(String[] args) {
        ListNode head = makeLinkedList(new int[]{3, 2, 0, -4}, 1);
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    private static ListNode makeLinkedList(int[] arr, int pos) {
        ListNode head = null;
        ListNode cur = null;
        ListNode last = null;

        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);

            if (head == null) {
                head = node;
            } else {
                cur.next = node;
            }

            cur = node;

            if (i == pos) {
                last = cur;
            }
        }

        if (last != null) {
            cur.next = last;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
