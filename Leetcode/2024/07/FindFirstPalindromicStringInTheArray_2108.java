package array;

public class FindFirstPalindromicStringInTheArray_2108 {
    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));
        System.out.println(firstPalindrome(new String[]{"notapalindrome","racecar"}));
        System.out.println(firstPalindrome(new String[]{"def","ghi"}));
    }

    private static String firstPalindrome(String[] words) {
        for (String word : words) {
            int start = 0;
            int end = word.length() - 1;

            boolean isPalindromic = true;
            while (start <= end) {
                if (word.charAt(start) != word.charAt(end)) {
                    isPalindromic = false;
                    break;
                }
                start++;
                end--;
            }

            if (isPalindromic) return word;
        }

        return "";
    }
}
