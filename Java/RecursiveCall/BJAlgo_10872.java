import java.io.*;

public class BJAlgo_10872 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }

    private static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
