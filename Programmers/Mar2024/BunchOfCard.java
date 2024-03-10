package Feb2024;

/**
 * Level 1. 카드 뭉치
 */
public class BunchOfCard {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(solution(new String[]{"a", "b", "c"}, new String[]{"d"}, new String[]{"d", "b"}));
        System.out.println(solution(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}, new String[]{"string", "or", "integer"},
                new String[]{"string", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}));
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int idx1 = 0;
        int idx2 = 0;

        for (String s : goal) {
            if (idx1 < cards1.length && cards1[idx1].equals(s)) {
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(s)) {
                idx2++;
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}