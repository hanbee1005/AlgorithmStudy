package Jan2022;

public class NextBigNumber {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    private static int solution(int n) {
        int answer = 0;

        int oneCnt = getOneCnt(n);

        int num = n + 1;
        while (true) {
            int cnt = getOneCnt(num);
            if (oneCnt == cnt) {
                answer = num;
                break;
            }
            num++;
        }

        return answer;
    }

    private static int getOneCnt(int n) {
        int result = 0;
        while (n != 0) {
            if (n % 2 == 1) result++;
            n /= 2;
        }

        return result;
    }
}
