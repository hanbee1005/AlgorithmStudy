package hashmap;

import java.util.HashSet;
import java.util.Set;

public class FindTheLengthOfTheLongestCommonPrefix_3043 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{1,10,100}, new int[]{1000}));
        System.out.println(longestCommonPrefix(new int[]{1,2,3}, new int[]{4,4,4}));
        System.out.println(longestCommonPrefix(new int[]{13,27,45}, new int[]{21,27,48}));
    }

    private static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for (int a1 : arr1) {
            while (a1 >= 10) {
                set.add(a1);
                a1 /= 10;
            }
            set.add(a1);
        }

        for (int a2 : arr2) {
            while (a2 >= 10) {
                if (set.contains(a2)) {
                    answer = Math.max(answer, (int) Math.log10(a2) + 1);
                    break;
                }

                a2 /= 10;
            }

            if (a2 < 10 && set.contains(a2)) {
                answer = Math.max(answer, (int) Math.log10(a2) + 1);
            }
        }

        return answer;
    }
}
