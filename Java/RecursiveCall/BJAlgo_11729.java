import java.io.*;

public class BJAlgo_11729 {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 3, 2);

        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoi(int num, int from, int to, int mid) {
        if (num <= 1) {
            count++;
            sb.append(from + " " + to + "\n");
            return;
        }

        hanoi(num-1, from, mid, to);
        count++;
        sb.append(from + " " + to + "\n");
        hanoi(num-1, mid, to, from);
    }
}
