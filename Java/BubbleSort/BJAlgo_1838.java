import java.io.*;

public class BJAlgo_1838 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < data.length - 1; i++) {
            boolean swap = false;
            for (int index = 0; index < (data.length - 1) - i; index++) {
                if (data[index] > data[index+1]) {
                    int tmp = data[index];
                    data[index] = data[index+1];
                    data[index+1] = tmp;
                    swap = true;
                }
            }

            if (!swap) {
                System.out.println(i);
                break;
            }
        }
    }
}
