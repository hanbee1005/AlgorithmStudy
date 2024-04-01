package Feb2022;

import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2,1,2,4,2,4,3,3})));
    }

    private static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Map<Integer, Double> failureRate = new HashMap<>();

        int[] pass = new int[N+1];
        int[] current = new int[N+2];

        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j < stages[i]; j++) {
                pass[j]++;  // 이전 단계까지 통과
            }

            current[stages[i]]++;   // 현재 머무르고 있는 단계
        }

        for (int i = 1; i < N+1; i++) {
            if (pass[i - 1] == 0) failureRate.put(i, 0.0);
            else failureRate.put(i, current[i] / (double) pass[i - 1]);
        }

        // 실패율이 높은 순으로 정렬
        List<Integer> keySetList = new ArrayList<>(failureRate.keySet());
        Collections.sort(keySetList, (o1, o2) -> (failureRate.get(o2).compareTo(failureRate.get(o1))));

        int i = 0;
        for(Integer key : keySetList) {
            answer[i] = key;
            i++;
        }

        return answer;
    }
}
