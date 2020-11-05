import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_2798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[] cards = new int[N];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(inputs[i]);
        }

        int result = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M && sum > result) {
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
