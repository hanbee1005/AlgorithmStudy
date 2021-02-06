import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJAlgo_14890 {
    private static int n;
    private static int l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int path = 0;

        for (int i = 0; i < n; i++) {
            int[] tmp = map[i];
            if (findPath(tmp)) {
                path += 1;
            }

            tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = map[j][i];
            }

            if (findPath(tmp)) {
                path += 1;
            }
        }

        System.out.println(path);
    }

    private static boolean findPath(int[] map) {
        boolean answer = true;
        int last = map[0];
        int count = 1;

        int cnt = 1;
        while (cnt < n) {
            if (last == map[cnt]) {
                count += 1;
                cnt += 1;
            } else if (map[cnt] - last == 1) {
                if (count < l) {
                    answer = false;
                    break;
                }

                last = map[cnt];
                count = 1;
                cnt += 1;
            } else if (last - map[cnt] == 1) {
                if (n - cnt >= l) {
                    for (int i = cnt + 1; i < cnt + l; i++) {
                        if (map[cnt] != map[i]) {
                            answer = false;
                            break;
                        }
                    }

                    if (!answer) {
                        break;
                    }

                    cnt += l;
                    last = map[cnt - 1];
                    count = 0;
                } else {
                    answer = false;
                    break;
                }
            } else {
                answer = false;
                break;
            }
        }

        return answer;
    }

}
