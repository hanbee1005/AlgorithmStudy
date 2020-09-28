import java.io.*;
import java.util.*;

public class BJAlgo_1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        List result = new ArrayList();

        Map<String, String> member = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String mb = br.readLine();
            member.put(mb, mb);
        }

        for (int i = 0; i < M; i++) {
            String mb = br.readLine();
            if (member.containsKey(mb)) {
                result.add(member.get(mb));
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
