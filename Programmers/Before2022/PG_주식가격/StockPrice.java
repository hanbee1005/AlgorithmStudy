import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;

                if (prices[i] > prices[j]) { // 가격이 하락한 경우
                    break;
                }
            }
        }

        return answer;
    }
}
