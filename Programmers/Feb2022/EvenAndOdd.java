package Feb2022;

public class EvenAndOdd {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    private static String solution(int num) {
        if (num%2 == 0) return "Even";
        else return "Odd";
    }
}
