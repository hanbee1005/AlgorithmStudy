package Feb2022;

public class MakePrimeNumber {
    private static int answer = 0;
    private static boolean[] prime = new boolean[2999]; // 소수이면 false 아니면 true

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,7,6,4}));
    }

    private static int solution(int[] nums) {
        // 소수 구하기
        makePrimeNumber();

        // 숫자 3개 뽑기
        combination(nums, new boolean[nums.length], nums.length, 0, 3);

        return answer;
    }

    private static void makePrimeNumber() {
        // 소수가 아닌 초기 값 true
        prime[0] = prime[1] = true;

        for (int i = 2; i*i < prime.length; i++) {
            // i가 소수가 아닌지 판단되지 않은 경우
            if (!prime[i]) {
                for (int j = i*i; j < prime.length; j+=i) {
                    prime[j] = true;  // 소수가 아님 처리
                }
            }
        }
    }

    private static void combination(int[] nums, boolean[] visited, int n, int start, int r) {
        if (r == 0) {
            // 3개 숫자를 모두 뽑은 경우
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) sum += nums[i];
            }
            if (!prime[sum]) answer++;
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;  // i번 숫자를 뽑은 경우
            combination(nums, visited, n, i + 1, r - 1);
            visited[i] = false;  // i번 숫자를 뽑지 않은 경우
        }
    }
}
