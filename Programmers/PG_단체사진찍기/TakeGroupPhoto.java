package com.company;

import java.util.*;

public class Main {
    private static int answer = 0;
    private static final List<String[]> condition = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
    }

    private static int solution(int n, String[] data) {
        // 조건 정리하기
        for (int i = 0; i < n; i++) {
            condition.add(data[i].replaceAll("~", "").split(""));
        }

        // 전체 경우의 수 구하기
        String[] friends = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        perm(friends, new String[friends.length], new boolean[friends.length], 0, 8, 8);

        return answer;
    }

    // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    private static void perm(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            // index 별 구조 변경
            Map<String, Integer> indexes = new HashMap<>();
            for (int i = 0; i < output.length; i++) {
                indexes.put(output[i], i);
            }

            // 조건 확인하기
            if (checkValidation(indexes)) {
                answer += 1;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    private static boolean checkValidation(Map<String, Integer> order) {
        int checkCnt = condition.size();

        for (String[] cdt : condition) {
            boolean checkNext = false;

            int idxA = order.get(cdt[0]);
            int idxB = order.get(cdt[1]);

            int dist = Math.abs(idxA - idxB) - 1;

            if (("=".equals(cdt[2]) && dist == Integer.parseInt(cdt[3]))
                    || ("<".equals(cdt[2]) && dist < Integer.parseInt(cdt[3]))
                    || (">".equals(cdt[2]) && dist > Integer.parseInt(cdt[3]))) {
                checkNext = true;
                checkCnt -= 1;
            }

            if (!checkNext) {
                break;
            }
        }

        return (checkCnt == 0);
    }
}
