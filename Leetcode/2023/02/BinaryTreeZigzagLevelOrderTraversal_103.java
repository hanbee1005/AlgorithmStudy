package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private static void dfs(TreeNode node, int depth) {
        if (node == null) return;

        if (result.size() <= depth) {
            result.add(new ArrayList<>(){{ add(node.val); }});
        } else {
            if (depth % 2 == 0) {
                result.get(depth).add(node.val);
            } else {
                result.get(depth).add(0, node.val);
            }
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
