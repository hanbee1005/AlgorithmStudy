package hashmap;

import java.util.*;

public class FirstUniqueCharacterInAString_387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }

    private static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 0);
            }
        }

        char c = map.keySet().stream().filter(key -> map.get(key) == 0).findFirst().orElse('0');
        return '0' == c ? -1 : s.indexOf(c);
    }
}
