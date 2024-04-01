package Feb2022;

public class HashardNum {
    public static void main(String[] args) {
        System.out.println(solution(12));
    }

    private static boolean solution(int x) {
        int sum = 0;
        int num = x;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return x % sum == 0;
    }
}
