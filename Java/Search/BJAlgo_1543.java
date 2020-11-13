import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_1543 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        String word = br.readLine();

        int count = 0;
        int findIdx = 0;

        while (string.length() - word.length() >= findIdx) {
            if (string.substring(findIdx, findIdx + word.length()).equals(word)) {
                count += 1;
                findIdx += word.length();
            } else {
                findIdx += 1;
            }
        }

        System.out.println(count);
    }
}
