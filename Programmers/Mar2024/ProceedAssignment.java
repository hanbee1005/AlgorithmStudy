package Mar2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Level 2. 과제 진행하기
 */
public class ProceedAssignment {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"a","09:00","30"},{"b","09:10","20"},{"c","09:15","20"},{"d","09:55","10"},{"e","10:50","5"}})));
    }

    private static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        // 시간 순으로 정렬하기
        String[][] timeline = Arrays.stream(plans).sorted((p1, p2) -> calculateTime(p1[1]) - calculateTime(p2[1]))
                .toArray(String[][]::new);

        int currentTime = calculateTime(timeline[0][1]) + Integer.parseInt(timeline[0][2]);
        String currentSubject = timeline[0][0];
        Stack<String[]> restPlans = new Stack<>();

        for (int i = 1; i < timeline.length; i++) {
            String[] next = timeline[i];
            int start = calculateTime(next[1]);

            while (currentTime <= start) {
                answer.add(currentSubject);

                if (restPlans.isEmpty()) {
                    break;
                }

                String[] rest = restPlans.pop();
                currentTime += Integer.parseInt(rest[1]);
                currentSubject = rest[0];
            }

            if (currentTime > start) {
                restPlans.push(new String[]{currentSubject, String.valueOf(currentTime - start)});
            }

            currentTime = start + Integer.parseInt(next[2]);
            currentSubject = next[0];
        }

        answer.add(currentSubject);

        while (!restPlans.isEmpty()) {
            answer.add(restPlans.pop()[0]);
        }

        return answer.toArray(String[]::new);
    }

    private static int calculateTime(String time) {
        int[] t = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return t[0] * 60 + t[1];
    }
}
