import java.io.*;
import java.util.*;

public class BJAlgo_1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Queue<int[]> queue = new LinkedList();

            int[] priority = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int index = 0; index < nm[0]; index++) {
                int[] tmp = new int[2];
                tmp[0] = priority[index];
                tmp[1] = index;
                queue.offer(tmp);
            }

            int count = 0;
            while (true) {
                if (queue.peek()[0] == queue.stream().max((a, b) -> a[0] - b[0]).orElse(new int[1])[0]) {
                    count++;
                    if (queue.peek()[1] == nm[1]) {
                        System.out.println(count);
                        break;
                    } else {
                        queue.remove();
                    }
                } else {
                    queue.add(queue.remove());
                }
            }
        }
    }
}
