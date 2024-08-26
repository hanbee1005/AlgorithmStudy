package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    public static void main(String[] args) {
        System.out.println(postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
        System.out.println(postorderTraversal(null));
        System.out.println(postorderTraversal(new TreeNode(1, null, null)));
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        if (null == root) return answer;

        searchPostOrder(root, answer);
        return answer;
    }

    private static void searchPostOrder(TreeNode root, List<Integer> answer) {
        if (root == null) return;

        if (root.left != null) searchPostOrder(root.left, answer);
        if (root.right != null) searchPostOrder(root.right, answer);
        answer.add(root.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
