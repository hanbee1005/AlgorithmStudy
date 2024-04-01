package May2023;

/**
 * 인접한 두 수의 차가 k 이하가 되도록 하는 swap 연산의 최소 횟수 구하기
 */
public class FindMinSwapCount {
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 40, 30, 20}, 20));

        answer = Integer.MAX_VALUE;

        System.out.println(solution(new int[]{3, 7, 2, 8, 6, 4, 5, 1}, 3));
    }

    private static int solution(int[] numbers, int k) {
        permutation(numbers, 0, numbers.length, 0, k);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void permutation(int[] numbers, int depth, int n, int cnt, int k) {
        if (depth == n) {
            for (int i = 1; i < n; i++) {
                if (Math.abs(numbers[i - 1] - numbers[i]) > k) {
                    return;
                }
            }

            answer = Math.min(answer, cnt);
        }

        for (int i = depth; i < n; i++) {
            swap(numbers, depth, i);

            if (depth != i) {
                permutation(numbers, depth + 1, n, cnt + 1, k);
            } else {
                permutation(numbers, depth + 1, n, cnt, k);
            }

            swap(numbers, depth, i);
        }
    }

    private static void swap(int[] arr, int depth, int i) {
        int tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;
    }
}
