package array;

public class CheckIfArrayPairsAreDivisibleByK_1497 {
    public static void main(String[] args) {
        System.out.println(canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
        System.out.println(canArrange(new int[]{1,2,3,4,5,6}, 7));
        System.out.println(canArrange(new int[]{1,2,3,4,5,6}, 10));
    }

    private static boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];

        for (int num : arr) {
            freq[((num % k) + k) % k]++;
        }

        if (freq[0] % 2 != 0) return false;

        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) return false;
        }

        return true;
    }
}
