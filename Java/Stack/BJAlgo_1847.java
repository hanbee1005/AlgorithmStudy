import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJAlgo_1847 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List stack = new ArrayList();
        List result = new ArrayList();
        int top = 1;

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());

            while (top <= num) {
                stack.add(top);
                result.add("+");
                top += 1;
            }

            if ((int) stack.get(stack.size() - 1) == num) {
                stack.remove(stack.size() - 1);
                result.add("-");
            } else {
                result.clear();
                result.add("NO");
                break;
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
