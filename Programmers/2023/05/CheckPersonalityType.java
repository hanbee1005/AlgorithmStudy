package May2023;

import java.util.HashMap;
import java.util.Map;

/**
 * Level 1. 성격 유형 검사하기
 */
public class CheckPersonalityType {
    private static int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }

    private static String solution(String[] survey, int[] choices) {
        Map<String, Integer> result = new HashMap<>(){{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};

        for (int i = 0; i < choices.length; i++) {
            String[] types = survey[i].split("");
            String type = choices[i] < 4 ? types[0] : types[1];
            result.put(type, result.get(type) + score[choices[i]]);
        }

        return (result.get("R") < result.get("T") ? "T" : "R")
                + (result.get("C") < result.get("F") ? "F" : "C")
                + (result.get("J") < result.get("M") ? "M" : "J")
                + (result.get("A") < result.get("N") ? "N" : "A");
    }
}
