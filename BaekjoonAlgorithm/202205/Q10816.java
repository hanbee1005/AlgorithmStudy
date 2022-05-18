package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cards = new HashMap<>();
        for (int n : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            if (cards.containsKey(n)) {
                cards.put(n, cards.get(n) + 1);
            } else {
                cards.put(n, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int m : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            if (cards.containsKey(m)) {
                sb.append(cards.get(m)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
