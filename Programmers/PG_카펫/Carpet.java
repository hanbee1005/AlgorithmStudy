package programmers;

import java.util.*;

public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8, 1)));
    }

    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        Map<Integer, Integer> divisors = getDivisor(brown + yellow);
        for (Map.Entry<Integer, Integer> divisor : divisors.entrySet()) {
            int w = divisor.getKey();
            int h = divisor.getValue();

            if ((w - 2) * (h - 2) == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }

        return answer;
    }

    private static Map<Integer, Integer> getDivisor(int num) {
        Map<Integer, Integer> divisors = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 3; i < num / 2; i++) {
            if (num % i == 0) {
                int key = Math.max(i, num / i);
                int val = Math.min(i, num / i);

                if (divisors.containsKey(key) || divisors.containsKey(val)) {
                    break;
                }

                divisors.put(key, val);
            }
        }

        return divisors;
    }
}
