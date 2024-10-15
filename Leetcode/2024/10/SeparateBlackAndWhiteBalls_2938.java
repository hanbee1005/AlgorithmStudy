package string;

public class SeparateBlackAndWhiteBalls_2938 {
    public static void main(String[] args) {
        System.out.println(minimumSteps("101"));
        System.out.println(minimumSteps("100"));
        System.out.println(minimumSteps("0111"));
        System.out.println(minimumSteps("11000111"));
    }

    private static long minimumSteps(String s) {
        long swap = 0;
        int black = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                swap += black;
            else
                black++;
        }
        return swap;
    }
}
