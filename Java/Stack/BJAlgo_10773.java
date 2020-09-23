import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJAlgo_10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List stack = new ArrayList();
        int sum = 0;

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(num);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            sum += Integer.parseInt(String.valueOf(stack.get(i)));
        }

        System.out.println(sum);
    }
}
