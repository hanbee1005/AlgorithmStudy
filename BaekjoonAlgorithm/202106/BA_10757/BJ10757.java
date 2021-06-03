import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int maxLength = Math.max(input[0].length(), input[1].length());

        int[] a = new int[maxLength];
        int[] b = new int[maxLength];

        // A 초기화
        for (int i = 0; i < input[0].length(); i++) {
            a[i] = Character.getNumericValue(input[0].charAt(input[0].length() - (i + 1)));
        }

        // B 초기화
        for (int i = 0; i < input[1].length(); i++) {
            b[i] = Character.getNumericValue(input[1].charAt(input[1].length() - (i + 1)));
        }

        // 덧셈
        int roundingUp = 0;
        for (int i = 0; i < maxLength; i++) {
            int sum = a[i] + b[i] + roundingUp;
            a[i] = sum % 10;
            roundingUp = sum / 10;
        }

        // 숫자로 변경
        StringBuilder sb = new StringBuilder();

        if (roundingUp != 0) sb.append(1);

        for (int i = maxLength - 1; i >= 0; i--) {
            sb.append(a[i]);
        }

        System.out.println(sb);
    }
}
