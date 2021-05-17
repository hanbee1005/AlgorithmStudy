import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2941 {
    public static void main(String[] args) throws IOException {
        String[] croatia = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;

        while (input.length() != 0) {
            boolean startWithCroatiaAlphabet = false;

            for (String croAlpha : croatia) {
                if (input.startsWith(croAlpha)) {
                    input = input.substring(croAlpha.length());
                    startWithCroatiaAlphabet = true;
                    break;
                }
            }

            if (!startWithCroatiaAlphabet) {
                input = input.substring(1);
            }

            answer++;
        }

        System.out.println(answer);
    }
}
