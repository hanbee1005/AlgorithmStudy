package array;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone_2037 {
    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[]{3,1,5}, new int[]{2,7,4}));
        System.out.println(minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6}));
        System.out.println(minMovesToSeat(new int[]{2,2,6,6}, new int[]{1,3,2,6}));
    }

    private static int minMovesToSeat(int[] seats, int[] students) {
        int answer = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if (seats[i] == students[j]) {
                    seats[i] = 0;
                    students[j] = 0;
                    break;
                }
            }
        }

        int[] seatList = Arrays.stream(seats).sorted().toArray();
        int[] studentList = Arrays.stream(students).sorted().toArray();

        for (int i = 0; i < seatList.length; i++) {
            if (seatList[i] != 0) answer += Math.abs(seatList[i] - studentList[i]);
        }

        return answer;
    }
}
