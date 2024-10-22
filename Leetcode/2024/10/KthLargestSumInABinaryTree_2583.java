package tree;

import java.util.*;

public class KthLargestSumInABinaryTree_2583 {
    public static void main(String[] args) {
        System.out.println(kthLargestLevelSum(new TreeNode(5,
                new TreeNode(8, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(1)),
                new TreeNode(9, new TreeNode(3), new TreeNode(7))), 2));
        System.out.println(kthLargestLevelSum(new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null), 1));
    }

    private static long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                sum += curr.val;
            }

            if (pq.size() < k) {
                pq.offer(sum);
            } else {
                if (pq.peek() < sum) {
                    pq.poll();
                    pq.offer(sum);
                }
            }
        }

        if (pq.size() < k) return -1;
        return pq.peek();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
