package string;

public class CountingWordsWithAGivenPrefix_2185 {
    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
        System.out.println(prefixCount(new String[]{"leetcode","win","loops","success"}, "code"));
    }

    private static int prefixCount(String[] words, String pref) {
        int answer = 0;

        for (String word : words) {
            if (word.startsWith(pref)) {
                answer++;
            }
        }

        return answer;
    }
}
