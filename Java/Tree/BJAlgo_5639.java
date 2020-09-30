import java.io.*;
import java.util.*;

public class BJAlgo_5639 {
    static List post = new ArrayList();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        while ((s = br.readLine()) != null && (s.length() != 0)) {
            int num = Integer.parseInt(s);
            post.add(num);
        }

        if (post.size() > 0) {
            postOrder(0, post.size() - 1);
        }
    }

    static void postOrder(int start, int end) {
        if (start > end) {
            return;
        }

        int division = end + 1;
        for (int i = start + 1; i < end + 1; i++) {
            if ((int) post.get(start) < (int) post.get(i)) {
                division = i;
                break;
            }
        }

        postOrder(start + 1, division - 1);
        postOrder(division, end);
        System.out.println(post.get(start));
    }
}
