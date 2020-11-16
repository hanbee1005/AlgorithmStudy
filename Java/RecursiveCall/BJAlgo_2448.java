import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_2448 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] stars = {"  *  ", " * * ", "*****"};

        int k = 0;
        n = n / 3;
        while (n != 1) {
            n = n / 2;
            k += 1;
        }

        for (int i = 0; i < k; i++) {
            stars = makeStar(stars);
        }

        for (String s : stars) {
            System.out.println(s);
        }
    }

    private static String[] makeStar(String[] star) {
        String[] matrix = new String[star.length * 2];
        for (int i = 0; i < matrix.length; i++) {
            if (i < star.length) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < star.length; j++) {
                    sb.append(" ");
                }
                matrix[i] = sb.toString() + star[i % star.length] + sb.toString();
            } else {
                matrix[i] = star[i % star.length] + " " +star[i % star.length];
            }
        }
        return matrix;
    }
}
