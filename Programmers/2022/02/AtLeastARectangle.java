package Feb2022;

public class AtLeastARectangle {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }

    private static int solution(int[][] sizes) {
        int answer = 0;

        int mostBig = 0;
        int mostSmall = 0;

        for (int i = 0; i < sizes.length; i++) {
            int big = sizes[i][0];
            int small = sizes[i][1];

            if (big < small) {
                int tmp = big;
                big = small;
                small = tmp;
            }

            if (mostBig < big) mostBig = big;  // 큰 것들 중 가장 큰 수
            if (mostSmall < small) mostSmall = small;  // 작은 것들 중 가장 작은 수
        }

        answer = mostBig * mostSmall;

        return answer;
    }
}
