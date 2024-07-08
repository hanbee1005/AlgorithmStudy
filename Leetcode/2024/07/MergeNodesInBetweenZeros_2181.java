package linkedlist;

public class MergeNodesInBetweenZeros_2181 {
    public static void main(String[] args) {
        ListNode listNode = mergeNodes(makeNodes(new int[]{0, 3, 1, 0, 4, 5, 2, 0}));
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val).append(",");
            listNode = listNode.next;
        }
        System.out.println(sb);

        listNode = mergeNodes(makeNodes(new int[]{0,1,0,3,0,2,2,0}));
        sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val).append(",");
            listNode = listNode.next;
        }
        System.out.println(sb);
    }

    private static ListNode makeNodes(int[] list) {
        ListNode result = null;
        ListNode head = null;
        for (int i : list) {
            if (result == null) {
                result = new ListNode(i);
                head = result;
            } else {
                head.next = new ListNode(i);
                head = head.next;
            }
        }
        return result;
    }

    private static ListNode mergeNodes(ListNode head) {
        ListNode modify = head.next;
        ListNode nextNode = modify;
        while(nextNode != null){
            int sum = 0;
            while(nextNode.val != 0){
                sum += nextNode.val;
                nextNode = nextNode.next;
            }
            nextNode = nextNode.next;
            modify.val = sum;
            modify.next = nextNode;
            modify = modify.next;
        }
        return head.next;
    }

    private static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
