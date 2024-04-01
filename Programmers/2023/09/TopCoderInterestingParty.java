package Sep2023;

import java.util.HashMap;
import java.util.Map;

/**
 * Top Coder Interesting Party SRM494 Div 2 Level 1
 */
public class TopCoderInterestingParty {
    public static void main(String[] args) {
        System.out.println(bestInvitation(new String[]{"fishing", "gardening", "swimming", "fishing"}, new String[]{"hunting", "fishing", "fishing", "biting"}));
        System.out.println(bestInvitation(new String[]{"variety", "diversity", "loquacity", "courtesy"}, new String[]{"talking", "speaking", "discussion", "meeting"}));
        System.out.println(bestInvitation(new String[]{"snakes", "programming", "cobra", "monty"}, new String[]{"python", "python", "anaconda", "python"}));
    }

    private static int bestInvitation(String[] first, String[] second) {
        Map<String, Integer> numberPerInterestingTopic = new HashMap<>();

        for (int i = 0; i < first.length; i++) {
            numberPerInterestingTopic.put(first[i], numberPerInterestingTopic.getOrDefault(first[i], 0) + 1);
            numberPerInterestingTopic.put(second[i], numberPerInterestingTopic.getOrDefault(second[i], 0) + 1);
        }

        return numberPerInterestingTopic.values().stream().mapToInt(i -> i).max().orElseGet(() -> 0);
    }
}
