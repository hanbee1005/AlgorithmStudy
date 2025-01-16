package bit;

public class BitwiseXOROfAllPairings_2425 {
    public static void main(String[] args) {
        System.out.println(xorAllNums(new int[]{2,1,3}, new int[]{10,2,5,0}));
        System.out.println(xorAllNums(new int[]{1,2}, new int[]{3,4}));
    }

    private static int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int answer = 0;

        if (n % 2 != 0) {
            for (int num : nums2) {
                answer ^= num;
            }
        }

        if (m % 2 != 0) {
            for (int num : nums1) {
                answer ^= num;
            }
        }

        return answer;
    }
}
