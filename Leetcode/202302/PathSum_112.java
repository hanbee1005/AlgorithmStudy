package tree;

import java.util.Stack;

public class PathSum_112 {
    private static boolean result = false;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        );
        System.out.println(hasPathSum(treeNode, 22));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if ((root.left == null && root.right == null) && targetSum - root.val == 0) return true;

        boolean result = false;

        if (root.left != null) result = hasPathSum(root.left, targetSum - root.val);
        if (result == false && root.right != null) result = hasPathSum(root.right, targetSum - root.val);

        return result;
    }
}
