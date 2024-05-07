package May2024;

/**
 * Level 3. 풍선 터트리기
 */
public class BurstingABalloon {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,-1,-5}));
        System.out.println(solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }

    private static int solution(int[] a) {
        int answer = 0;

        int minIdx = 0;
        for (int i = 0; i < a.length; i ++) {
            if (a[i] < a[minIdx]) {
                minIdx = i;
            }
        }

        int s = 0;
        int e = a.length - 1;

        int min = 1000000001;
        while (s < minIdx) {
            if (a[s] < min) {
                min = a[s];
                answer++;
            }

            s++;
        }

        min = 1000000001;
        while (e > minIdx) {
            if (a[e] < min) {
                min = a[e];
                answer++;
            }

            e--;
        }

        return answer + 1;
    }
}
