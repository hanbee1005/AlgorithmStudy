package Sep2023;

/**
 * Top Coder AutoLoan SRM258 Div 2 Level 2
 */
public class TopCoderAutoLoan {
    public static void main(String[] args) {
        System.out.println(interestRate(6800, 100, 68));
        System.out.println(interestRate(2000, 510, 4));
        System.out.println(interestRate(15000, 364, 48));
    }

    private static double interestRate(double price, double monthlyPayment, int loanTerm) {
        double balance;
        double high = 100, low = 0, mid = 0;

        // 오차 판정
        while ((1e-9 < high - low) && (1e-9 < (high - low) / high)) {
            balance = price;
            mid = (high + low) / 2;

            for (int i = 0; i < loanTerm; i++) {
                balance *= mid / 1200 + 1;
                balance -= monthlyPayment;
            }

            if (0 < balance) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return mid;
    }
}
