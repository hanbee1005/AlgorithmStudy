package string;

public class CircularSentence_2490 {
    public static void main(String[] args) {
        System.out.println(isCircularSentence("leetcode exercises sound delightful"));
        System.out.println(isCircularSentence("eetcode"));
        System.out.println(isCircularSentence("Leetcode is cool"));
    }

    private static boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length()-1)) {
            return false;
        }

        int k = sentence.indexOf(" ");
        if (k == -1) return true;

        while (k != -1) {
            if (sentence.charAt(k-1) != sentence.charAt(k + 1)){
                return false;
            }

            k = sentence.indexOf(" ",k + 1);
        }

        return true;
    }
}
