package graph;

import java.util.*;

public class MaximumDepthOfBinaryTree_104 {
    private static int answer = 0;

    public static void main(String[] args) {
        System.out.println(maxDepth(makeTree(new int[]{0})));
    }

    private static TreeNode makeTree(int[] node) {
//        return new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        return new TreeNode(1, null, new TreeNode(2));
    }

    private static int maxDepth(TreeNode root) {
        dfs(root, 1);
        return answer;
    }

    private static void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (answer < depth) answer = depth;

        if (node.left != null) {
            dfs(node.left, depth + 1);
        }

        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }

    private static int bfs(TreeNode node) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            System.out.println(n == null ? "NULL" : n.val);
            if (n != null) {
                count++;
                queue.offer(n.left);
                queue.offer(n.right);
            }


        }

        return count;
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
