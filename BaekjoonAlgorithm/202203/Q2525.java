package Mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] startTime = br.readLine().split(" ");
        int hour = Integer.parseInt(startTime[0]);
        int minute = Integer.parseInt(startTime[1]);

        int time = Integer.parseInt(br.readLine());

        hour += ((time + minute) / 60);
        minute = ((time + minute) % 60);

        if (hour < 24) {
            System.out.println(hour + " " + minute);
        } else {
            System.out.println((hour - 24) + " " + minute);
        }
    }
}
