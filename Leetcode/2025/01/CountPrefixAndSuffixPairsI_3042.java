package string;

public class CountPrefixAndSuffixPairsI_3042 {
    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs(new String[]{"a","aba","ababa","aa"}));
        System.out.println(countPrefixSuffixPairs(new String[]{"pa","papa","ma","mama"}));
        System.out.println(countPrefixSuffixPairs(new String[]{"abab","ab"}));
    }

    private static int countPrefixSuffixPairs(String[] words) {
        int answer = 0;

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) {
                    continue;
                }

                answer += isPrefixAndSuffix(words[i], words[j]) ? 1 : 0;
            }
        }

        return answer;
    }

    private static boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
