import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stringA = br.readLine();
        String stringB = br.readLine();
        int[][] result = new int[stringB.length() + 1][stringA.length() + 1];

        for (int i =  1; i < result.length; i++) {
            for (int j = 1; j < result[i].length; j++) {
                if (stringB.charAt(i - 1) != stringA.charAt(j - 1)) {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                } else {
                    result[i][j] = result[i - 1][j - 1] + 1;
                }
            }
        }

        System.out.println(result[stringB.length()][stringA.length()]);
    }
}
