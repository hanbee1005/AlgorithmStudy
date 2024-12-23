package tree;

import java.util.*;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel_2471 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new TreeNode(1,
                new TreeNode(4, new TreeNode(7), new TreeNode(6)),
                new TreeNode(3, new TreeNode(8, new TreeNode(9), null), new TreeNode(5, new TreeNode(10), null)))));

        System.out.println(minimumOperations(new TreeNode(1,
                new TreeNode(3, new TreeNode(7), new TreeNode(6)),
                new TreeNode(2, new TreeNode(5), new TreeNode(4)))));

        System.out.println(minimumOperations(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null))));
    }

    private static int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSwaps = 0;

        // Process tree level by level using BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int[] levelValues = new int[levelSize];

            // Store values of current level and add children to queue
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues[i] = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Add minimum swaps needed for current level
            totalSwaps += getMinSwaps(levelValues);
        }
        return totalSwaps;
    }

    // Calculate minimum swaps needed to sort an array
    private static int getMinSwaps(int[] original) {
        int swaps = 0;
        int[] target = original.clone();
        Arrays.sort(target);

        // Map to track current positions of values
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            pos.put(original[i], i);
        }

        // For each position, swap until correct value is placed
        for (int i = 0; i < original.length; i++) {
            if (original[i] != target[i]) {
                swaps++;

                // Update position of swapped values
                int curPos = pos.get(target[i]);
                pos.put(original[i], curPos);
                original[curPos] = original[i];
            }
        }
        return swaps;
    }

    private static class TreeNode {
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
