import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_1568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int birds = Integer.parseInt(br.readLine());
        int num = 1;
        int time = 0;

        while (birds != 0) {
            if (num > birds) {
                num = 1;
            }

            birds -= num;
            time += 1;
            num += 1;
        }

        System.out.println(time);
    }
}
