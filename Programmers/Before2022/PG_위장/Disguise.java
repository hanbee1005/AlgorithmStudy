import java.util.HashMap;
import java.util.Map;

public class Disguise {
    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    private static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }

        for (int cnt : clothesMap.values()) {
            answer *= (cnt + 1);
        }

        return answer - 1;
    }
}
