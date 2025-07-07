package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended_1353 {
    public static void main(String[] args) {
        System.out.println(maxEvents(new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(maxEvents(new int[][]{{1,2},{2,3},{3,4},{1,2}}));
    }

    private static int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);  // 행사들이 끝나는 마지막 날 계산
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 끝나는 날이 작은 순(최소 힙)
        Arrays.sort(events, (a, b) -> a[0] - b[0]);         // 시작일 기준 오름차순 정렬
        int ans = 0;
        for (int i = 1, j = 0; i <= maxDay; i++) {
            // ① 오늘(day) 시작 가능한 행사 모두 힙에 삽입
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);  // 끝나는 날 저장
                j++;
            }
            // ② 이미 종료된 행사(끝나는 날 < 오늘)는 제거
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            // ③ 아직 참석 가능한 행사 중, 가장 빨리 끝나는 행사 선택
            if (!pq.isEmpty()) {
                pq.poll();  // 오늘 하루를 소비해 참석
                ans++;
            }
        }

        return ans;
    }
}
