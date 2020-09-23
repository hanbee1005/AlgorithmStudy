import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJAlgo_10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List stack = new ArrayList();

        for(int i = 0; i < count; i++) {
            String[] comm = br.readLine().split(" ");

            switch (comm[0]) {
                case "push":
                    stack.add(Integer.parseInt(comm[1]));
                    break;
                case "pop":
                    if (stack.size() > 0) {
                        int data = (int) stack.get(stack.size() - 1);
                        stack.remove(stack.size() - 1);
                        System.out.println(data);
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if (stack.size() > 0) {
                        System.out.println(stack.get(stack.size() - 1));
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
