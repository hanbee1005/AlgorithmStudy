import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findPrimeNumber {
    private static final Set<Integer> selectedCombi = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    private static int solution(String numbers) {
        int answer = 0;
        int[] nums = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < nums.length; i++) {
            selectedCombi.clear();
            permutation(nums, new int[nums.length], new boolean[nums.length], 0, nums.length, i + 1);
            for (int num : selectedCombi) {
                // 소수인지 확인하고 소수이면 answer 증가
                if (isPrimeNumber(num)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: permutation(arr, output, visited, 0, n, 3);
    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int[] result = Arrays.copyOfRange(output, 0, depth);
            // 숫자 만들기
            int newNum = makeNum(result);
            if (newNum >= Math.pow(10, depth - 1) && newNum < Math.pow(10, depth)) {
                selectedCombi.add(newNum);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;;
            }
        }
    }

    private static int makeNum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i] * Math.pow(10, nums.length - (i + 1));
        }

        return result;
    }

    private static boolean isPrimeNumber(int num) {
        if (0 == num || 1 == num) {
            return false;
        }

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
