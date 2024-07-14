package array;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals_1481 {
    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{5,5,4}, 1));
        System.out.println(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }

    private static int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Step 1: Count the frequency of each integer in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Collect and sort the frequencies in ascending order
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies);

        // Step 3: Remove the least frequent integers first, until exactly k elements are removed
        int uniqueCount = frequencies.size();
        for (int freq : frequencies) {
            if (k >= freq) {
                k -= freq;
                uniqueCount--;
            } else {
                break;
            }
        }

        // Step 4: Return the number of unique integers remaining
        return uniqueCount;
    }
}
