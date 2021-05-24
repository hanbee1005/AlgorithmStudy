import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        if (count == 1) {
            System.out.println("1/1");
        } else {
            int c = 1;
            int i = 2;
            while (true) {
                if (count <= c + i) {
                    int a = (c + i) - count + 1;
                    int b = (i + 1) - a;

                    if (i % 2 == 0) {
                        System.out.println(b + "/" + a);
                    } else {
                        System.out.println(a + "/" + b);
                    }

                    break;
                } else {
                    c += i;
                    i++;
                }
            }
        }
    }
}
