package string;

public class CountTheNumberOfConsistentStrings_1684 {
    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"}));
        System.out.println(countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));
        System.out.println(countConsistentStrings("cad", new String[]{"cc","acd","b","ba","bac","bad","ac","d"}));
    }

    private static int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allow[c - 97] = true;
        }

        int answer = 0;

        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allow[c - 97]) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                answer++;
            }
        }

        return answer;
    }
}
