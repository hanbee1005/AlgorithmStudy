package linkedlist;

public class AddTwoNumbers_2 {
    private static ListNode node = null;
    private static int pre = 0;
    public static void main(String[] args) {
        ListNode l1 = ListNode.makeLinkedList(new int[]{2, 4, 3});
        ListNode l2 = ListNode.makeLinkedList(new int[]{5, 6, 4});

        ListNode node = addTwoNumbers(l1, l2);

        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.insert(0, node.val);
            node = node.next;
        }

        System.out.println(sb);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        node = result;
        pre = (l1.val + l2.val) / 10;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            sum(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum(l1.val, 0);
            l1 = l1.next;
        }

        while (l2 != null) {
            sum(0, l2.val);
            l2 = l2.next;
        }

        if (pre != 0) {
            node.next = new ListNode(pre);
        }

        return result;
    }

    private static void sum(int v1, int v2) {
        int cur = (v1 + v2 + pre) % 10;
        pre = (v1 + v2 + pre) / 10;

        node.next = new ListNode(cur);
        node = node.next;
    }
}
