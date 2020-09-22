import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJAlgo_10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List que = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            String[] comm = br.readLine().split(" ");

            switch (comm[0]){
                case "push":
                    que.add(Integer.parseInt(comm[1]));
                    break;
                case "pop":
                    if (que.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        int data = (int) que.get(0);
                        que.remove(que.get(0));
                        System.out.println(data);
                    }
                    break;
                case "size":
                    System.out.println(que.size());
                    break;
                case "empty":
                    if (que.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (que.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(que.get(0));
                    }
                    break;
                case "back":
                    if (que.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(que.get(que.size() - 1));
                    }
                    break;
            }
        }
    }
}
