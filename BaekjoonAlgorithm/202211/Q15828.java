package Nov2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> buffer = new LinkedList<>();

        while (true) {
            int packet = Integer.parseInt(br.readLine());

            if (-1 == packet) {
                break;
            } else if (0 == packet) {
                buffer.poll();
            } else {
                if (buffer.size() < N) {
                    buffer.add(packet);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (buffer.isEmpty()) {
            sb.append("empty");
        } else {
            buffer.forEach(p -> sb.append(p).append(" "));
        }

        System.out.println(sb);
    }
}
