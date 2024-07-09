package array;

public class FindTheWinnerOfTheCircularGame_1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
        System.out.println(findTheWinner(5, 3));
    }

    private static int findTheWinner(int n, int k) {
        return josephusHelper(n,k) + 1;
    }
    public static int josephusHelper(int n,int k){
        if (n == 1) return 0;
        return (josephusHelper(n - 1, k) + k) % n;
    }
}
