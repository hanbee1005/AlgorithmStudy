package hashmap;

import java.util.*;

public class IntersectionOfTwoArrays_349 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) map.put(num, false);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) map.put(num, true);
        }

        return map.keySet().stream().filter(map::get).mapToInt(Integer::new).toArray();
    }
}
