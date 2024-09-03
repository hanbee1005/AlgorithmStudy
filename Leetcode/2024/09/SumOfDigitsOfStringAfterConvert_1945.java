package string;

public class SumOfDigitsOfStringAfterConvert_1945 {
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
        System.out.println(getLucky("leetcode", 2));
        System.out.println(getLucky("zbax", 2));
    }

    private static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 96);
        }

        String answer = sb.toString();

        for (int i = 0; i < k; i++) {
            int sum = 0;

            for (char c : answer.toCharArray()) {
                sum += (c - '0');
            }

            answer = String.valueOf(sum);
        }

        return Integer.parseInt(answer);
    }
}
