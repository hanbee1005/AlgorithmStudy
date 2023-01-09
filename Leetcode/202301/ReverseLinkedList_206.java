package stack;

import java.util.Stack;

public class ReverseLinkedList_206 {
    public static void main(String[] args) {
        ListNode head = ListNode.makeLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode node = reverseList(head);

        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(" ");
            node = node.next;
        }

        System.out.println(sb);
    }

    private static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.isEmpty()) {
            return null;
        } else {
            ListNode top = stack.pop();
            head = top;

            while (!stack.isEmpty()) {
                top.next = stack.pop();
                top = top.next;
            }

            top.next = null;

            return head;
        }
    }
}
