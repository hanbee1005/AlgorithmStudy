package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTreeII_2641 {
    public static void main(String[] args) {
        System.out.println(replaceValueInTree(new TreeNode(5,
                new TreeNode(4, new TreeNode(1), new TreeNode(10)), new TreeNode(9, null, new TreeNode(7)))));
        System.out.println(replaceValueInTree(new TreeNode(3, new TreeNode(1), new TreeNode(2))));
    }

    private static TreeNode replaceValueInTree(TreeNode root) {
        int curLvlSum = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        root.val *= -1;

        while (!q.isEmpty()) {
            int sz = q.size();
            int newLvlSum = 0;

            for (int i = 0; i < sz; ++i) {
                TreeNode cur = q.poll();
                int childSum = 0;
                if (cur.left != null) childSum += cur.left.val;
                if (cur.right != null) childSum += cur.right.val;
                newLvlSum += childSum;

                if (cur.left != null) cur.left.val = -childSum;
                if (cur.right != null) cur.right.val = -childSum;
                cur.val += curLvlSum;

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }

            curLvlSum = newLvlSum;
        }

        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
