package Jun2024;

import java.util.Arrays;

/**
 * Level 3. 표현 가능한 이진 트리
 */
public class RepresentableBinaryTree {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{7, 42, 5})));
        System.out.println(Arrays.toString(solution(new long[]{63, 111, 95})));

        // 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1
        System.out.println(Arrays.toString(solution(new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 128, 129, 16512, 2147516555L})));
    }

    private static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder sb = new StringBuilder();
            long mod = numbers[i];
            while (mod > 1) {
                sb.insert(0, mod % 2);
                mod /= 2;
            }
            sb.insert(0, mod);

            if (sb.length() == 1) {
                answer[i] = Integer.parseInt(sb.toString());
                continue;
            }

            int n = 0;
            int size = 0;
            while (true) {
                size += (int) Math.pow(2, n);
                if (sb.length() <= size) break;
                n++;
            }

            sb.insert(0, "0".repeat(size - sb.length()));

            answer[i] = checkBinaryTree(sb.toString()) ? 1 : 0;
        }

        return answer;
    }

    private static boolean checkBinaryTree(String number) {
        if (!number.contains("1")) return true;

        if (number.length() == 3) {
            return number.charAt(1) != '0';
        }

        int mid = number.length() / 2;
        if (number.charAt(mid) == '0') return false;
        return checkBinaryTree(number.substring(0, mid)) && checkBinaryTree(number.substring(mid + 1));
    }
}
