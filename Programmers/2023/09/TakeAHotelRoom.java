package Sep2023;

import java.util.*;

/**
 * Level 2. 호텔 대실
 */
public class TakeAHotelRoom {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}}));
    }

    private static int solution(String[][] book_time) {
        int[] times = new int[24 * 60 + 10];

        for (String[] bookTime : book_time) {
            int start = makeMinute(bookTime[0]);
            int end = makeMinute(bookTime[1]) + 10;

            for (int i = start; i < end; i++) {
                times[i]++;
            }
        }

        return Arrays.stream(times).max().orElse(0);
    }

    private static int makeMinute(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}
