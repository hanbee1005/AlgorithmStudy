package hashmap;

public class MaxSumOfAPairWithEqualSumOfDigits_2342 {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18,43,36,13,7}));
        System.out.println(maximumSum(new int[]{10,12,19,14}));
        System.out.println(maximumSum(new int[]{229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401}));
    }

    private static int maximumSum(int[] nums) {
        int[] max = new int[100];
        int answer = -1;

        for (int x : nums) {
            int dsum = 0;
            int temp = x;

            while(temp != 0){
                dsum += temp % 10;
                temp /= 10;
            }

            if(max[dsum] != 0) answer = Math.max(answer, x + max[dsum]);
            max[dsum] = Math.max(max[dsum], x);
        }

        return answer;
    }
}
