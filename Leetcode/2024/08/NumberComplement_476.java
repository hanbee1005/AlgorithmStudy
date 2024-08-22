package bit;

public class NumberComplement_476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }

    private static int findComplement(int num) {
        int m = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ m;
    }
}
