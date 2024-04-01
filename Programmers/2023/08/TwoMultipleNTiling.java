package Aug2023;

/**
 * Level 2. 2 x n 타일링
 */
public class TwoMultipleNTiling {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    private static int solution(int n) {
        int[] arr = new int[n + 1];
        if (n >= 1) arr[1] = 1;
        if (n >= 2) arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] % 1000000007;
        }

        return arr[n];
    }
}
