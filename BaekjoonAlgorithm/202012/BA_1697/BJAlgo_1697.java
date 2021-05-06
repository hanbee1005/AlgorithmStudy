import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BJAlgo_1697 {
    static int MAX = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array = new int[MAX];

        System.out.println(bfs(nk, array));
    }

    private static int bfs(int[] nk, int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(nk[0]);

        while (!deque.isEmpty()) {
            int nowPos = deque.pollFirst();
            if (nowPos == nk[1]) {
                return arr[nowPos];
            }

            int[] tmp = {nowPos - 1, nowPos + 1, nowPos * 2};
            for (int nextPos : tmp) {
                if ((nextPos >= 0 && nextPos < MAX) && arr[nextPos] == 0) {
                    arr[nextPos] = arr[nowPos] + 1;
                    deque.add(nextPos);
                }
            }
        }

        return 0;
    }
}
