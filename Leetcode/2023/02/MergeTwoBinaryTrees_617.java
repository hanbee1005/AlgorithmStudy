package tree;

public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {
        TreeNode node1 = mergeTrees(new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2)),
                new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)))
        );

        TreeNode node2 = mergeTrees(new TreeNode(1), new TreeNode(1, new TreeNode(2), null));

        System.out.println(node1.val);
    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return makeTreeNode(root1, root2);
    }

    private static TreeNode makeTreeNode(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode leftNode = null;
        TreeNode rightNode = null;

        if (root1.left != null || root2.left != null) {
            leftNode = makeTreeNode(root1.left, root2.left);
        }

        if (root1.right != null || root2.right != null) {
            rightNode = makeTreeNode(root1.right, root2.right);
        }

        return new TreeNode(root1.val + root2.val, leftNode, rightNode);
    }
}
