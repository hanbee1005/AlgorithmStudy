import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJAlgo_20057 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    // 왼쪽으로 이동할 때 날리는 먼지의 위치와 비율을 Rate 클래스로 저장
    private static Rate[] leftRate = {
            new Rate(-2, 0, 0.02), new Rate(2, 0, 0.02),
            new Rate(-1, -1, 0.1), new Rate(-1, 0, 0.07), new Rate(-1, 1, 0.01),
            new Rate(1, -1, 0.1), new Rate(1, 0, 0.07), new Rate(1, 1, 0.01),
            new Rate(0, -2, 0.05), new Rate(0, -1, 0)
    };

    // 아래로 이동할 때 날리는 먼지의 위치와 비율을 Rate 클래스로 저장
    private static Rate[] downRate = {
            new Rate(0, -2, 0.02), new Rate(0, 2, 0.02),
            new Rate(1, -1, 0.1), new Rate(0, -1, 0.07), new Rate(-1, -1, 0.01),
            new Rate(1, 1, 0.1), new Rate(0, 1, 0.07), new Rate(-1, 1, 0.01),
            new Rate(2, 0, 0.05), new Rate(1, 0, 0)
    };

    // 오른쪽으로 이동할 때 날리는 먼지의 위치와 비율을 Rate 클래스로 저장
    private static Rate[] rightRate = {
            new Rate(-2, 0, 0.02), new Rate(2, 0, 0.02),
            new Rate(-1, -1, 0.01), new Rate(-1, 0, 0.07), new Rate(-1, 1, 0.1),
            new Rate(1, -1, 0.01), new Rate(1, 0, 0.07), new Rate(1, 1, 0.1),
            new Rate(0, 2, 0.05), new Rate(0, 1, 0)
    };

    // 위로 이동할 때 날리는 먼지의 위치와 비율을 Rate 클래스로 저장
    private static Rate[] upRate = {
            new Rate(0, -2, 0.02), new Rate(0, 2, 0.02),
            new Rate(-1, -1, 0.1), new Rate(0, -1, 0.07), new Rate(1, -1, 0.01),
            new Rate(-1, 1, 0.1), new Rate(0, 1, 0.07), new Rate(1, 1, 0.01),
            new Rate(-2, 0, 0.05), new Rate(-1, 0, 0)
    };

    private static int n;
    private static int[][] sand;

    // 마법사 상어의 위치
    private static int sx;
    private static int sy;

    // 범위 밖으로 날린 먼지의 합
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sand = new int[n][n];
        for (int i = 0; i < n; i++) {
            sand[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        sx = n / 2;
        sy = n / 2;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                move(i, 0);
                move(i, 1);
            } else {
                move(i, 2);
                move(i, 3);
            }
        }

        System.out.println(result);
    }

    // 토네이도 형태로 이동하기
    private static void move(int count, int idx) {
        for (int i = 0; i < count + 1; i++) {
            sx += dx[idx];
            sy += dy[idx];

            // (0, 0) 지점까지 이동한 경우
            if (sx < 0 || sy < 0) {
                break;
            }

            // 각 방향에 맞게 사용할 비율 배열 전달
            switch (idx) {
                case 0:
                    tornado(leftRate);
                    break;
                case 1:
                    tornado(downRate);
                    break;
                case 2:
                    tornado(rightRate);
                    break;
                case 3:
                    tornado(upRate);
                    break;
            }

        }
    }

    // 이동한 위치를 기준으로 모래 날리기
    private static void tornado(Rate[] rates) {
        int removeSand = 0;
        for (Rate rate : rates) {
            // 모래가 날릴 위치 구하기
            int nx = sx + rate.x;
            int ny = sy + rate.y;

            int rs = 0;
            if (rate.rate == 0) {  // 알파 구역에 날릴 모래 구하기
                rs = sand[sx][sy] - removeSand;
            } else {  // 비율에 따라 날린 모래 구하기
                rs = (int) (sand[sx][sy] * rate.rate);
            }

            // 모래밭 범위 내로 먼지가 날린 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                sand[nx][ny] += rs;  // 기존 먼지 + 날린 먼지
            } else {
                result += rs;  // 밖으로 날린 먼지 추가
            }

            removeSand += rs;  // 비율에 따라 날린 먼지의 합
        }

    }

    // 먼지가 날릴 위치와 해당 위치로 날릴 먼지의 비율을 나타내는 클래스
    private static class Rate {
        int x;
        int y;
        double rate;

        public Rate(int x, int y, double rate) {
            this.x = x;
            this.y = y;
            this.rate = rate;
        }
    }
}
