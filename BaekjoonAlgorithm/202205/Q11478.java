package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Set<String> setS = new HashSet<>();
        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < S.length() - (i - 1); j++) {
                setS.add(S.substring(j, j + i));
            }
        }

        System.out.println(setS.size() + 1);
    }
}
