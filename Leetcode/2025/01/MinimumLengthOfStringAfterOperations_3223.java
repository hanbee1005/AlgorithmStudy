package hashmap;

public class MinimumLengthOfStringAfterOperations_3223 {
    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
        System.out.println(minimumLength("aa"));
    }

    private static int minimumLength(String s) {
        int[] freq = new int[26];
        for (Character c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int sum = 0;
        for (int val : freq) {
            sum += val <= 2 ? val : val % 2 == 0 ? 2 : 1;
        }

        return sum;
    }
}
