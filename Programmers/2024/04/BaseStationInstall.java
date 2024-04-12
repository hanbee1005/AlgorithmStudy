package Apr2024;

/**
 * Level 3. 기지국 설치
 */
public class BaseStationInstall {
    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1));
        System.out.println(solution(16, new int[]{9}, 2));
    }

    private static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int round = w * 2 + 1;
        int min = 1;
        for (int station : stations) {
            if (min < station - w) {
                int cnt = station - w - min;
                answer += (cnt / round) + (cnt % round != 0 ? 1 : 0);
            }
            min = station + w + 1;
        }

        if (min <= n) {
            int cnt = n - min + 1;
            answer += (cnt / round) + (cnt % round != 0 ? 1 : 0);
        }

        return answer;
    }
}
