package array;

public class CheckIfOneStringSwapCanMakeStringsEqual_1790 {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));
        System.out.println(areAlmostEqual("kelb", "kelb"));
        System.out.println(areAlmostEqual("siyolsdcjthwsiplccjbuceoxmpjgrauocx", "siyolsdcjthwsiplccpbuceoxmjjgrauocx"));
    }

    private static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        boolean answer = false;

        char c1 = ' ', c2 = ' ';
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;

                if (cnt == 1) {
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                } else if (cnt == 2 && c1 == s2.charAt(i) && c2 == s1.charAt(i)) {
                    answer = true;
                } else if (cnt > 2) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}
