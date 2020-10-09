import java.io.*;
import java.util.*;

public class BJAlgo_2447 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List stars = new ArrayList();
        stars.add("***");
        stars.add("* *");
        stars.add("***");

        int k = 0;
        while (N != 3) {
            N = N / 3;
            k++;
        }

        for (int i = 0; i < k; i++) {
            stars = star(stars);
        }

        for (int i = 0; i < stars.size(); i++) {
            System.out.println(stars.get(i));
        }

    }

    private static List star(List list) {
        List tmp = new ArrayList();
        for (int i = 0; i < 3 * list.size(); i++) {
            StringBuilder sb = new StringBuilder();
            if (i / list.size() == 1) {
                for (int j = 0; j < list.size(); j++) {
                    sb.append(" ");
                }
                tmp.add(list.get(i % list.size()) + "" + sb + list.get(i % list.size()));
            } else {
                for (int j = 0; j < 3; j++) {
                    sb.append(list.get(i % list.size()));
                }
                tmp.add(sb);
            }
        }

        return tmp;
    }
}
