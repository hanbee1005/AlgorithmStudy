package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10815 {
    private static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(0, N - 1, nums[i])).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int start, int end, int num) {
        if (start >= end) {
            return cards[start] == num ? 1 : 0;
        }

        int answer = 0;
        int mid = (start + end) / 2;

        if (cards[mid] == num) {
            answer = 1;
        } else if (cards[mid] < num) {
            answer = binarySearch(mid + 1, end, num);
        } else if (cards[mid] > num) {
            answer = binarySearch(start, mid - 1, num);
        }

        return answer;
    }
}
