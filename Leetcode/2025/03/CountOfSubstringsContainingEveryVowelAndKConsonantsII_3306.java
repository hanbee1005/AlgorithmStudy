package string;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII_3306 {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aeioqq", 1));
        System.out.println(countOfSubstrings("aeiou", 0));
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(countOfSubstrings("iqeaouqi", 2));
    }

    private static long countOfSubstrings(String word, int k) {
        int[][] frequencies = new int[2][128];
        frequencies[0]['a'] = 1;
        frequencies[0]['e'] = 1;
        frequencies[0]['i'] = 1;
        frequencies[0]['o'] = 1;
        frequencies[0]['u'] = 1;

        long answer = 0;
        int currentK = 0, vowels = 0, extraLeft = 0;

        for (int right = 0, left = 0; right < word.length(); right++) {
            char rightChar = word.charAt(right);

            if (frequencies[0][rightChar] == 1) {
                if (++frequencies[1][rightChar] == 1) vowels++;
            } else {
                currentK++;
            }

            while (currentK > k) {
                char leftChar = word.charAt(left);
                if (frequencies[0][leftChar] == 1) {
                    if (--frequencies[1][leftChar] == 0) vowels--;
                } else {
                    currentK--;
                }
                left++;
                extraLeft = 0;
            }

            while (vowels == 5 && currentK == k && left < right && frequencies[0][word.charAt(left)] == 1 && frequencies[1][word.charAt(left)] > 1) {
                extraLeft++;
                frequencies[1][word.charAt(left)]--;
                left++;
            }

            if (currentK == k && vowels == 5) {
                answer += (1 + extraLeft);
            }
        }

        return answer;
    }
}
