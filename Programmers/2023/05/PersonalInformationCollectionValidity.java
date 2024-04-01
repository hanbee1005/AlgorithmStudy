package May2023;

import java.util.*;

/**
 * Level 1. 개인정보 수집 유효기간
 */
public class PersonalInformationCollectionValidity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
        System.out.println(Arrays.toString(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }

    private static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        int todayNum = calculateDateNum(today);

        Map<String, Integer> termDate = new HashMap<>();

        for (String term : terms) {
            String[] t = term.split(" ");
            termDate.put(t[0], todayNum - (Integer.parseInt(t[1]) * 28));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");

            if (calculateDateNum(p[0]) <= termDate.get(p[1])) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static int calculateDateNum(String date) {
        String[] d = date.split("\\.");
        return (Integer.parseInt(d[0].substring(2)) * 28 * 12) + (Integer.parseInt(d[1]) * 28) + Integer.parseInt(d[2]);
    }
}
