package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortThePeople_2418 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortPeople(new String[]{"Mary","John","Emma"}, new int[]{180,165,170})));
        System.out.println(Arrays.toString(sortPeople(new String[]{"Alice","Bob","Bob"}, new int[]{155,185,150})));
    }

    private static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new HashMap<>();

        for(int i = 0; i < names.length; i++){
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] answer = new String[heights.length];
        int j = 0;
        for(int i = heights.length - 1; i >= 0; i--){
            answer[j] = map.get(heights[i]);
            j++;
        }

        return answer;
    }
}
