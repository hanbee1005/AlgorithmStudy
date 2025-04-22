package bit;

public class SumOfAllSubsetXORTotals_1863 {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1,3}));
        System.out.println(subsetXORSum(new int[]{5,1,6}));
        System.out.println(subsetXORSum(new int[]{3,4,5,6,7,8}));
    }

    private static int subsetXORSum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total |= num;  // Step 1: Compute bitwise OR of all numbers
        }
        return total * (1 << (nums.length - 1));  // Step 2: Multiply by 2^(n-1)
    }
}
