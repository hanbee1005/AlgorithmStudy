package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<String> S = new HashSet<>();
        for (int i = 0; i < NM[0]; i++) {
            S.add(br.readLine());
        }

        int answer = 0;

        for (int i = 0; i < NM[1]; i++) {
            if (S.contains(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
