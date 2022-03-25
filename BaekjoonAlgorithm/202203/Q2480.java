package Mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (dice[0] == dice[1] && dice[1] == dice[2]) {
            System.out.println(10000 + dice[0] * 1000);
        } else if (dice[0] == dice[1] || dice[1] == dice[2] || dice[0] == dice[2]) {
            int same = dice[0] == dice[1] ? dice[0] : dice[1] == dice[2] ? dice[1] : dice[2];
            System.out.println(1000 + same * 100);
        } else {
            int max = Math.max(dice[0], Math.max(dice[1], dice[2]));
            System.out.println(max * 100);
        }
    }
}
