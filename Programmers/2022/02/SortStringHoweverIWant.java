package Feb2022;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringHoweverIWant {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
    }

    private static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int nSort = o1.charAt(n) - o2.charAt(n);
                return nSort == 0 ? o1.compareTo(o2) : nSort;
            }
        });

        return strings;
    }
}
