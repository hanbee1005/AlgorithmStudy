package graph;

public class MinimumDepthOfBinaryTree_111 {
    private static int answer = (int) (Math.pow(10, 5) + 1);

    public static void main(String[] args) {
        System.out.println(minDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        answer = (int) (Math.pow(10, 5) + 1);
        System.out.println(minDepth(new TreeNode(2,
                null, new TreeNode(3,
                null, new TreeNode(4,
                null, new TreeNode(5,
                null, new TreeNode(6)))))));
    }

    private static int minDepth(TreeNode root) {
        dfs(root, 1);
        return answer;
    }

    private static void dfs(TreeNode node, int depth) {
        if (node == null) {
            answer = 0;
            return;
        }

        if (node.left == null && node.right == null) {
            answer = Math.min(depth, answer);
        } else {
            if (node.left != null) {
                dfs(node.left, depth + 1);
            }

            if (node.right != null) {
                dfs(node.right, depth + 1);
            }
        }
    }
}
