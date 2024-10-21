package backtracking;

import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings_1593 {
    static int res = -1;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("ababccc"));
        init();
        System.out.println(maxUniqueSplit("aba"));
        init();
        System.out.println(maxUniqueSplit("aa"));
    }

    private static void init() {
        res = -1;
        set = new HashSet<>();
    }

    private static int maxUniqueSplit(String s) {
        backtrace(0, s);
        return res;
    }

    private static void backtrace(int startIndex, String s) {
        if (startIndex == s.length()){
            res = Math.max(res, set.size());
            return;
        }

        for (int i = startIndex; i < s.length(); i++){
            if(s.length() - 1 - i + set.size() < res){
                break;
            }

            String cur = s.substring(startIndex, i + 1);
            if(!set.contains(cur)) {
                set.add(cur);
                backtrace(i + 1, s);
                set.remove(cur);
            }
        }
    }
}
