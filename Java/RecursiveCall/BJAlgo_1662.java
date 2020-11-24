import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJAlgo_1662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split("");
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("(")) {
                stack.add(-1);
            } else if (strings[i].equals(")")) {
                int cnt = 0;
                while (true) {
                    int tmp = stack.remove(stack.size() - 1);
                    if (tmp == -1) {
                        break;
                    }
                    cnt += tmp;
                }
                stack.add(stack.remove(stack.size() - 1) * cnt);
            } else if (i < strings.length - 1 && strings[i + 1].equals("(")) {
                stack.add(Integer.parseInt(strings[i]));
            } else {
                stack.add(1);
            }
        }

        int answer = 0;
        for (int s: stack) {
            answer += s;
        }

        System.out.println(answer);
    }
}
