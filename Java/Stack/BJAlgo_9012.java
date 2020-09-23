import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJAlgo_9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            List stack = new ArrayList();
            String[] ps = br.readLine().split("");

            for (int j = 0; j < ps.length; j++) {
                String item = String.valueOf(ps[j]);

                if ("(".equals(item)) {
                    stack.add(item);
                } else if (")".equals(item)) {
                    if (stack.size() > 0 && "(".equals(stack.get(stack.size() - 1))) {
                        stack.remove(stack.size() - 1);
                    } else {
                        stack.add(item);
                    }
                }
            }

            if (stack.size() > 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
