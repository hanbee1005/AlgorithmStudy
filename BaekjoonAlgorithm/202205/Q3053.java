package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());

        System.out.println(Math.PI * (R * R));
        System.out.println(Math.pow(R, 2) * 2);
    }
}
