package tree;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree_108 {
    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode.val);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        int idx = nums.length / 2;
        TreeNode root = new TreeNode(nums[idx]);

        if ((idx - 1) >= 0) {
            root.left = sortedArrayToBST(Arrays.copyOf(nums, idx));
        }

        if ((idx + 1) < nums.length) {
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, idx + 1, nums.length));
        }

        return root;
    }
}
