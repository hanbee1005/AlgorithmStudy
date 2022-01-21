package programmers;

import java.util.Arrays;

public class SafeBoat {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }

    private static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int head = 0;
        int tail = people.length - 1;

        while (head <= tail) {
            int first = people[head];
            int last = people[tail];

            if (first + last <= limit) {
                head++;
            }

            answer++;
            tail--;
        }

        return answer;
    }
}
