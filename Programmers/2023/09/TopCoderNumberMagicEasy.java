package Sep2023;

/**
 * Top Coder NumberMagicEasy SRM484 Div 2 Level 1
 */
public class TopCoderNumberMagicEasy {
    public static void main(String[] args) {
        System.out.println(theNumber("YNYY"));
        System.out.println(theNumber("YNNN"));
        System.out.println(theNumber("NNNN"));
        System.out.println(theNumber("YYYY"));
        System.out.println(theNumber("NYNY"));
    }

    private static int theNumber(String answer) {
        String[] cards = {
                "YYYY",
                "YYYN",
                "YYNY",
                "YYNN",
                "YNYY",
                "YNYN",
                "YNNY",
                "YNNN",
                "NYYY",
                "NYYN",
                "NYNY",
                "NYNN",
                "NNYY",
                "NNYN",
                "NNNY",
                "NNNN"
        };

        for (int i = 0; i < cards.length; i++) {
            if (answer.equals(cards[i])) {
                return i + 1;
            }
        }

        return 0;
    }
}
