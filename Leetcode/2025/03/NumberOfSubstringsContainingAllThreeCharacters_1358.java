package string;

public class NumberOfSubstringsContainingAllThreeCharacters_1358 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
    }

    private static int numberOfSubstrings(String s) {
        int[] frequencies = new int[3];

        int answer = 0;
        int abc = 0, extraLeft = 0;

        for (int right = 0, left = 0; right < s.length(); right++) {
            int rightChar = s.charAt(right) - 'a';

            if (++frequencies[rightChar] == 1) abc++;

            while (abc == 3 && left < right && frequencies[s.charAt(left) - 'a'] > 1) {
                extraLeft++;
                frequencies[s.charAt(left) - 'a']--;
                left++;
            }

            if (abc == 3) {
                answer += (1 + extraLeft);
            }
        }

        return answer;
    }
}
