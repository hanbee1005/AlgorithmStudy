package greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
    }

    private static List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int farRight = 0;

        for (int i = 0; i < s.length(); i++) {
            farRight = Math.max(farRight, lastIndex[s.charAt(i) - 'a']);

            if (farRight == i) {
                result.add(farRight - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
