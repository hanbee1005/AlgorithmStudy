import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }

    private static int[] solution(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        String[] divideStr = s.split("(},)");

        for (String str : divideStr) {
            if (!str.equals(" ")) {
                int[] digit = Arrays.stream(
                        str.replace("{", "").replace("}", "").split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                List<Integer> tmp = new ArrayList<>();
                for (int d : digit) {
                    tmp.add(d);
                }

                map.put(digit.length, tmp);
            }
        }

        for (int i = 1; i <= map.size(); i++) {
            List<Integer> list = map.get(i);
            for (int n : list) {
                if (!result.contains(n)) {
                    result.add(n);
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
