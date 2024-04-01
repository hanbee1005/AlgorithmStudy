package Mar2022;

import java.util.Arrays;

public class FindPrimeNumFromKNum {
    public static void main(String[] args) {
        System.out.println(solution(524287,2));
    }

    private static int solution(int n, int k) {
        int answer = 0;
        String[] strings = Arrays.stream(changeNum(n, k).split("0")).filter(s -> !s.equals("")).toArray(String[]::new);

        for (String str : strings) {
            if (isPrimeNum(Long.parseLong(str))) answer++;
        }

        return answer;
    }

    private static String changeNum(int n, int k) {
        StringBuilder result = new StringBuilder();

        while(n > 0) {
            result.insert(0, n % k);
            n /= k;
        }

        return result.toString();
    }

    private static boolean isPrimeNum(long num) {
        if (num == 1) return false;
        if (num == 2) return true;

        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
