package Feb2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PickTwoAndAddThem {
    private static Set<Integer> addNumbers = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
    }

    private static int[] solution(int[] numbers) {
        // 2개 뽑아서 더하기
        combination(numbers, new boolean[numbers.length], numbers.length, 0, 2);

        Integer[] answerTmp = new Integer[addNumbers.size()];
        addNumbers.toArray(answerTmp);
        int[] answer = Arrays.stream(answerTmp).mapToInt(Integer::intValue).toArray();

        Arrays.sort(answer);

        return answer;
    }

    private static void combination(int[] nums, boolean[] visited, int n, int start, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) sum += nums[i];
            }

            addNumbers.add(sum);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(nums, visited, n, i + 1, r - 1);
            visited[i] = false;
        }
    }
}
