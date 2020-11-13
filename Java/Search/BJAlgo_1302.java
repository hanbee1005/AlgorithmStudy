import jdk.dynalink.linker.ConversionComparator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_1302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();

            if (books.containsKey(book)) {
                books.put(book, books.get(book) + 1);
            } else {
                books.put(book, 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList =  new ArrayList<>(books.entrySet());
        Collections.sort(entryList, (o1, o2) -> {
            if (o1.getValue().compareTo(o2.getValue()) == 0) {
                return o2.getKey().compareTo(o1.getKey());
            } else {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println(entryList.get(entryList.size() - 1).getKey());

    }
}
