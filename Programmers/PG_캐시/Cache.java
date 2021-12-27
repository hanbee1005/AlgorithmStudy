package Dec;

import java.util.*;

public class Cache {
    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
    }

    private static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        List<String> cityList = new LinkedList<>();

        for (String city : cities) {
            city = city.toUpperCase();
            if (cityList.contains(city)) {
                cityList.remove(city);
                cityList.add(city);
                answer += 1;
            } else {
                if (cityList.size() >= cacheSize) {
                    cityList.remove(0);
                }

                cityList.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}
