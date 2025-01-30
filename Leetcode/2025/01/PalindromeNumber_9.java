package math;

public class PalindromeNumber_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int n = x;
        int revNum = 0;

        while (n > 0) {
            int d = n % 10;
            revNum = revNum * 10 + d;
            n = n / 10;
        }

        return revNum == x;
    }
}
