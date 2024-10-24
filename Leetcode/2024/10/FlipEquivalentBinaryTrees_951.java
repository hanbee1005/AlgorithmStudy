package tree;

public class FlipEquivalentBinaryTrees_951 {
    public static void main(String[] args) {
        System.out.println(flipEquiv(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))),
                new TreeNode(3, new TreeNode(6), null)),
                new TreeNode(1, new TreeNode(3, null, new TreeNode(6)),
                        new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(7))))));
        System.out.println(flipEquiv(new TreeNode(), new TreeNode()));
        System.out.println(flipEquiv(new TreeNode(), new TreeNode(1)));
    }

    private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return checker(root1, root2);
    }

    private static boolean checker(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return (checker(node1.left, node2.left) || checker(node1.left, node2.right)) &&
                (checker(node1.right, node2.right) || checker(node1.right, node2.left));
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
