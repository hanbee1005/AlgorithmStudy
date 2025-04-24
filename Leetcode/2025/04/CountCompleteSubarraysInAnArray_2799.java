package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarraysInAnArray_2799 {
    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{1,3,1,2,2}));
        System.out.println(countCompleteSubarrays(new int[]{5,5,5,5}));
    }

    private static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }

        int k = set.size();
        int i = 0;
        int j = 0;

        int answer = 0;

        Map<Integer,Integer> map = new HashMap<>();

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j],0) + 1);
            while (map.size() == k) {
                answer += (nums.length - j);
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return answer;
    }
}
