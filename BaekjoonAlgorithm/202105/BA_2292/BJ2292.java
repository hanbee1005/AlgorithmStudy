import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int answer = 1;

        if (num > 1) {
            int i = 1;
            int lastNum = 1;
            while (true) {
                if (num <= lastNum + (i * 6)) {
                    answer = i + 1;
                    break;
                } else {
                    lastNum += (i * 6);
                    i++;
                }
            }
        }

        System.out.println(answer);
    }
}
