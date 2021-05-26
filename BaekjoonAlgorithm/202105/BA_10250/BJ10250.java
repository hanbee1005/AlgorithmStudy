import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");

            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            int floor = n % h == 0 ? h : n % h;
            int roomNum = n % h == 0 ? n / h : (n / h) + 1;

            StringBuilder sb = new StringBuilder();
            sb.append(floor);

            if (roomNum < 10) {
                sb.append("0").append(roomNum);
            } else {
                sb.append(roomNum);
            }

            System.out.println(sb);
        }
    }
}
