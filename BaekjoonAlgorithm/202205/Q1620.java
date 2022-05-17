package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] arr = new String[NM[0] + 1];
        Map<String, Integer> dogam = new HashMap<>();

        for (int i = 1; i < NM[0] + 1; i++) {
            String pocketmon = br.readLine();
            arr[i] = pocketmon;
            dogam.put(pocketmon, i);
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < NM[1]; i++) {
            String pocketmon = br.readLine();
            if (isNumber(pocketmon)) {
                sb.append(arr[Integer.parseInt(pocketmon)]).append("\n");
            } else {
                sb.append(dogam.get(pocketmon)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isNumber(String str) {
        for (Character c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }
}
