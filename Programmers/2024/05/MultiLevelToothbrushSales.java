package May2024;

import java.util.*;

/**
 * Level 3. 다단계 칫솔 판매
 */
public class MultiLevelToothbrushSales {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10})));  // 360, 958, 108, 0, 450, 18, 180, 1080
        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"}, new int[]{2, 3, 5, 4})));  //
        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"edward", "edward"}, new int[]{2, 3})));  // 0, 45, 450, 0, 0, 0, 0, 0
    }

    private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, Integer> idx = new HashMap<>();
        Map<String, List<String>> connections = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            String e = enroll[i];
            String r = referral[i];

            List<String> newConn = new ArrayList<>();
            if (!"-".equals(r)) newConn.add(r);
            if (connections.containsKey(r)) {
                newConn.addAll(connections.get(r));
            }
            connections.put(e, newConn);

            idx.put(e, i);
        }

        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int a = amount[i] * 100;
            List<String> conn = new ArrayList<>(connections.get(s));
            conn.add(0, s);
            for (String c : conn) {
                int fee = (int) (a * 0.1);
                answer[idx.get(c)] += a - fee;

                if (fee < 1) {
                    break;
                }
                a = fee;
            }
        }

        return answer;
    }
}
