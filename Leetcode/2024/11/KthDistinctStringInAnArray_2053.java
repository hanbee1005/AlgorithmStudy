package array;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class KthDistinctStringInAnArray_2053 {
    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d","b","c","b","c","a"}, 2));
        System.out.println(kthDistinct(new String[]{"aaa","aa","a"}, 1));
        System.out.println(kthDistinct(new String[]{"a","b","a"}, 3));
    }

    private static String kthDistinct(String[] arr, int k) {
        Set<String> distinct = new LinkedHashSet<>();
        Set<String> duplicated = new HashSet<>();

        for (String s : arr) {
            if (!distinct.contains(s) && !duplicated.contains(s)) distinct.add(s);
            else {
                distinct.remove(s);
                duplicated.add(s);
            }
        }

        if (distinct.size() < k) return "";

        int count = 1;
        for (String s : distinct) {
            if (count == k) return s;
            count++;
        }

        return "";
    }
}
