package Apr2024;

import java.util.Arrays;

/**
 * Level 3. [1차] 셔틀 버스
 */
public class AShuttleBus {
    public static void main(String[] args) {
        System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00", "09:09"}));
        System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(solution(1, 1, 1, new String[]{"23:59"}));
        System.out.println(solution(10, 60, 45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
        System.out.println(solution(3, 1, 2, new String[]{"06:00", "23:59", "05:48", "00:01", "00:01"}));
    }

    private static String solution(int n, int t, int m, String[] timetable) {
        String answer = "09:00";

        // 시간 순으로 int로 만들어 h * 60 + m 정렬
        int[] times = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] hm = timetable[i].split(":");
            times[i] = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
        }

        Arrays.sort(times);

        int departureTime = 9 * 60;
        int lastShuttleTime = departureTime + ((n - 1) * t);

        // 셔틀 마지막 시간보다 모두 늦게 오는 경우
        if (lastShuttleTime < times[0]) {
            return makeTimeString(lastShuttleTime);
        }

        // 더 이상 탈 수 있는 셔틀이 없는 경우
        if (times.length == m && lastShuttleTime > times[times.length - 1]) {
            return "00:00";
        }

        int arrivalTime = 0;
        int crew = 0;
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            while (crew < times.length) {
                // 출발 시간보다 빨리 왔고 아직 자리가 있다면
                if (times[crew] <= departureTime && seats[i] < m) {
                    seats[i]++; // 버스 탑승
                    arrivalTime = times[crew] - 1;
                    crew++;
                } else {
                    break;
                }
            }

            departureTime += t;
        }

        // 마지막 버스에 자리가 남았다면
        if (seats[n - 1] < m) {
            arrivalTime = departureTime - t;
        }

        return makeTimeString(arrivalTime);
    }

    private static String makeTimeString(int time) {
        return String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60);
    }
}
