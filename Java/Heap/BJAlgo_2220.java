import java.io.*;

public class BJAlgo_2220 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] heap = new int[N+1];

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 1; j /= 2) {
                heap[j] = heap[j/2];
            }
            heap[1] = i + 1;
        }
        heap[N] = 1;

        for (int i = 1; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
