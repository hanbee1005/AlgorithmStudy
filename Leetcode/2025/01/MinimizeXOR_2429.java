package bit;

public class MinimizeXOR_2429 {
    public static void main(String[] args) {
        System.out.println(minimizeXor(3, 5));
        System.out.println(minimizeXor(1, 12));
    }

    private static int minimizeXor(int num1, int num2) {
        int a = Integer.bitCount(num1);
        int b = Integer.bitCount(num2);

        int answer = num1;
        for (int i = 0; i < 32; i++) {
            if (a > b && ((1 << i) & num1) > 0) {
                answer ^= 1 << i;
                a--;
            }
            if (a < b && ((1 << i) & num1) == 0) {
                answer ^= 1 << i;
                a++;
            }
        }

        return answer;
    }
}
