package Sep2023;

/**
 * Top Coder ThePalindrome SRM428 Div 2 Level 1
 */
public class TopCoderThePalindrome {
    public static void main(String[] args) {
        System.out.println(find("abab"));
        System.out.println(find("abacaba"));
        System.out.println(find("qwerty"));
        System.out.println(find("abdfhdyrbdbsdfghjkllkjhgfds"));
    }

    private static int find(String s) {
        for (int i = s.length(); ; i++) {
            boolean isPalindrome = true;

            for (int j = 0; j < s.length(); j++) {
                if ((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) return i;
        }
    }
}
