package Mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int buddhistCalendar = Integer.parseInt(br.readLine());
        System.out.println(buddhistCalendar - 544 + 1);
    }
}
