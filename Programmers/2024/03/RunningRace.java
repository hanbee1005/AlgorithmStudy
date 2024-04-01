package Mar2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RunningRace {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"})));
    }

    private static String[] solution(String[] players, String[] callings) {
        String[] answer = players;

        Map<String, Integer> playersMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playersMap.put(players[i], i);
        }

        for (String calling : callings) {
            int curIndex = playersMap.get(calling);
            String beforePlayer = answer[curIndex - 1];

            playersMap.put(calling, playersMap.get(beforePlayer));
            playersMap.put(beforePlayer, curIndex);

            answer[curIndex - 1] = calling;
            answer[curIndex] = beforePlayer;
        }

        return answer;
    }
}
