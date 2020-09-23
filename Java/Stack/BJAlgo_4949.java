import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJAlgo_4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            List stack = new ArrayList();
            String[] text = br.readLine().split("");

            if (".".equals(text[0])) {
                break;
            }

            for (int i = 0; i < text.length; i++) {
                String s = text[i];

                if ("(".equals(s) || "[".equals(s)) {
                    stack.add(s);
                } else if (")".equals(s)) {
                    if (stack.size() > 0 && "(".equals(stack.get(stack.size() - 1))) {
                        stack.remove(stack.size() - 1);
                    } else {
                        stack.add(s);
                    }
                } else if ("]".equals(s)) {
                    if (stack.size() > 0 && "[".equals(stack.get(stack.size() - 1))) {
                        stack.remove(stack.size() - 1);
                    } else {
                        stack.add(s);
                    }
                }
            }

            if (stack.size() > 0) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
