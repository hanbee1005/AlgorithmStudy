import java.io.*;

public class BJAlgo_2750 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] bs = new int[N];
        for (int i = 0; i < N; i++) {
            bs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < bs.length - 1; i++) {
            boolean swap = false;
            for (int index = 0; index < bs.length - i - 1; index++) {
                if (bs[index] > bs[index+1]) {
                    int tmp = bs[index];
                    bs[index] = bs[index+1];
                    bs[index+1] = tmp;
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }

        for (int i = 0; i < bs.length; i++) {
            System.out.println(bs[i]);
        }
    }
}
