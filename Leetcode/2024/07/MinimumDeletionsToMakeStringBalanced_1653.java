package stack;

public class MinimumDeletionsToMakeStringBalanced_1653 {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletions("bbaaaaabb"));
    }

    private static int minimumDeletions(String s) {
        int answer = 0;
        int b = 0;

        for (char c : s.toCharArray()) {
            if ('b' == c) {
                b++;
            } else {
                if (b > 0) {
                    b--;
                    answer++;
                }
            }
        }

        return answer;
    }
}
