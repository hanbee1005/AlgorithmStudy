import java.io.*;
import java.util.PriorityQueue;

public class BJAlgo_11920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        String[] inputs = br.readLine().split(" ");

        /**
         * 우선 순위 큐에 K개 원소 유지
         * K개 보다 더 많은 원소가 들어오면
         * 가장 작은 값 바로 poll
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(inputs[i]));

            if (i >= K) {
                bw.write(pq.poll() + " ");
            }
        }

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + " ");
        }
        bw.flush();
    }
}
