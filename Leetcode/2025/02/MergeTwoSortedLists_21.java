package linkedlist;

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        printListNode(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))));
        printListNode(mergeTwoLists(null, null));
        printListNode(mergeTwoLists(null, new ListNode(0)));
    }

    private static void printListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val).append(" ");
            listNode = listNode.next;
        }
        System.out.println(sb);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        if (list1 == null) return list2;
        else if (list2 == null) return list1;

        ListNode answer = null;
        if (list1.val <= list2.val) {
            answer = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            answer = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode head = answer;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            head = head.next;
        }

        if (list1 == null) {
            head.next = list2;
        }

        if (list2 == null) {
            head.next = list1;
        }

        return answer;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
