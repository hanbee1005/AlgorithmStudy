import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJAlgo_1158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        List memberList = new ArrayList();
        List result = new ArrayList();
        int popNum = 0;

        for(int i = 0; i < N; i++) {
            memberList.add(i + 1);
        }

        while (memberList.size() > 0) {
            popNum = (popNum + (K - 1)) % memberList.size();
            String data = String.valueOf(memberList.get(popNum));
            memberList.remove(popNum);
            result.add(data);
        }

        System.out.println("<" + String.join(", ", result) + ">");
    }
}
