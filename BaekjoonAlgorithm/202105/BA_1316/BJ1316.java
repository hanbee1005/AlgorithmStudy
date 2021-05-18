import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ1316 {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String word = br.readLine();
            if (checkGroupWord(word)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean checkGroupWord(String word) {
        Set<Character> alphabetSet = new HashSet<>();

        char before = ' ';
        for (char w : word.toCharArray()) {
            if (before != ' ' && before != w) {
                alphabetSet.add(before);

                if (alphabetSet.contains(w)) {
                    return false;
                }
            }

            before = w;
        }

        return true;
    }
}
