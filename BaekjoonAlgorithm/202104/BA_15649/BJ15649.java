import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        permutation(new int[n], new boolean[n], n, m, 0);
    }

    // 순열을 구합니다.
    // (뽑힌 실제 숫자 배열, 해당 인덱스를 뽑았는지 아닌지를 결정할 배열, 전체 개수, 뽑아야하는 개수, 실제 뽑힌 개수)
    private static void permutation(int[] nums, boolean[] selected, int n, int r, int depth) {
        // 뽑아야하는 개수를 모두 뽑은 경우
        if (depth == r) {
            // 순서대로 출력하기
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(nums[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        // 처음부터 뽑아야하는 수를 확인하면서
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {  // 아직 뽑히지 않은 수인 경우
                selected[i] = true;  // 뽑고
                nums[depth] = i + 1;  // 뽑은 수를 저장하고
                permutation(nums, selected, n, r, depth + 1);  // 다음 수를 재귀적으로 확인 (하나 뽑았기 때문에 depth + 1)
                selected[i] = false;  // 해당 위치의 수를 뽑지 않은 경우
            }
        }
    }
}
