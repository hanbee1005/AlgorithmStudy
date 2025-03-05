package math;

public class CountTotalNumberOfColoredCells_2579 {
    public static void main(String[] args) {
        System.out.println(coloredCells(1));
        System.out.println(coloredCells(2));
        System.out.println(coloredCells(3));
    }

    private static long coloredCells(int n) {
        return 1 + (long) 2 * n * (n - 1);
    }
}
