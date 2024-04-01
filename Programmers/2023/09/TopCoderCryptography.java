package Sep2023;

/**
 * Top Coder Cryptography SRM480 Div 2 Level 1
 */
public class TopCoderCryptography {
    public static void main(String[] args) {
        System.out.println(encrypt(new int[]{1, 2, 3}));
        System.out.println(encrypt(new int[]{1, 3, 2, 1, 1, 3}));
        System.out.println(encrypt(new int[]{1000, 999, 998, 997, 996, 995}));
        System.out.println(encrypt(new int[]{1, 1, 1, 1}));
    }

    private static long encrypt(int[] numbers) {
        long answer = 1;
        long init = 1;

        for (int number : numbers) {
            init *= number;
        }

        for (int number : numbers) {
            answer = Math.max(answer, (init / number) * (number + 1));
        }

        // 가장 작은 수에 1을 더하는 것도 해결 방법!
        // int i = Arrays.stream(numbers).min().orElseGet(() -> 1);
        // answer = (answer / i) * (i + i);

        return answer;
    }
}
