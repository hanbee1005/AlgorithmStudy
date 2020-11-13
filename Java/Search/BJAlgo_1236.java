import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJAlgo_1236 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] castle = new String[nm[0]][nm[1]];
        for (int i = 0; i < nm[0]; i++) {
            String[] tmp = br.readLine().split("");
            castle[i] = tmp;
        }

        List x = new ArrayList();
        for (int i = 0; i < nm[0]; i++) {
            x.add(i + "");
        }
        List y = new ArrayList();
        for (int i = 0; i < nm[1]; i++) {
            y.add(i + "");
        }

        for (int i = 0; i < nm[0]; i++) {
            for (int j = 0; j < nm[1]; j++) {
                if (castle[i][j].equals("X")) {
                    if (x.contains(i + "")) {
                        x.remove(i + "");
                    }

                    if (y.contains(j + "")) {
                        y.remove(j + "");
                    }
                }
            }
        }

        System.out.println(Math.max(x.size(), y.size()));
    }
}
