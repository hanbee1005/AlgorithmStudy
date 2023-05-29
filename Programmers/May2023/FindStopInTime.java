package May2023;

import java.util.*;

/**
 * k 시간 안에 정차할 수 있는 정류소 번호 목록 구하기
 */
public class FindStopInTime {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 17, new int[][]{{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}})));
        System.out.println(Arrays.toString(solution(4, 10, new int[][]{{0, 1, 2}, {0, 2, 3}})));
        System.out.println(Arrays.toString(solution(4, 11, new int[][]{{0, 1, 2}, {1, 2, 7}, {2, 3, 10}, {3, 0, 9}})));
    }

    private static int[] solution(int n, int k, int[][] roads) {
        List<Integer> answer = new LinkedList<>();

        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] road : roads) {
            List<int[]> list1 = map.getOrDefault(road[0], new ArrayList<>());
            list1.add(new int[]{road[1], road[2]});
            map.put(road[0], list1);

            List<int[]> list2 = map.getOrDefault(road[1], new ArrayList<>());
            list2.add(new int[]{road[0], road[2]});
            map.put(road[1], list2);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            if (pos[1] == k && !answer.contains(pos[0])) {
                answer.add(pos[0]);
            }

            if (pos[1] < k) {
                for (int[] next : map.get(pos[0])) {
                    int sum = pos[1] + next[1];
                    if (sum <= k) {
                        queue.offer(new int[]{next[0], sum});
                    }
                }
            }
        }

        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(i -> i).toArray();
    }
}
