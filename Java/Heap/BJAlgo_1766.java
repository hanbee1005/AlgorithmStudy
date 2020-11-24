import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BJAlgo_1766 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<ArrayList<Integer>> array = new ArrayList<>();
        for (int i = 0; i < nm[0] + 1; i++) {
            array.add(new ArrayList<>());
        }
        int[] indegree = new int[nm[0] + 1];

        for (int i = 0; i < nm[1]; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            array.get(xy[0]).add(xy[1]);
            indegree[xy[1]] += 1;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 1; i < nm[0] + 1; i++) {
            if (indegree[i] == 0) {
                heap.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!heap.isEmpty()) {
            int data = heap.poll();
            result.append(data).append(" ");

            for (int n : array.get(data)) {
                indegree[n] -= 1;
                if (indegree[n] == 0) {
                    heap.add(n);
                }
            }
        }

        System.out.println(result);
    }
}
