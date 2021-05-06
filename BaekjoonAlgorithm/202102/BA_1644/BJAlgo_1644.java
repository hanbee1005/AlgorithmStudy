import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJAlgo_1644 {
    private static int[] primeNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        findPrimeNum(n);

        int low = 0, high = 0;
        int sum = primeNum[0];
        int result = 0;

        while (low <= high && high < primeNum.length - 1) {
            if (sum < n) {
                sum += primeNum[++high];
            } else if (sum == n) {
                result += 1;
                sum += primeNum[++high];
            } else if (sum > n) {
                sum -= primeNum[low++];
            }
        }

        if (primeNum[primeNum.length - 1] == n) {
            result += 1;
        }

        System.out.println(result);
    }

    private static void findPrimeNum(int n) {
        boolean[] isPrimeNum = new boolean[n + 1];
        Arrays.fill(isPrimeNum, true);

        ArrayList<Integer> primeNumList = new ArrayList<>();

        for (int i = 2; i < n + 1; i++) {
            if (isPrimeNum[i]) {
                int j = 2;
                while (i * j < n + 1) {
                    isPrimeNum[i * j] = false;
                    j += 1;
                }
                primeNumList.add(i);
            }
        }

        primeNum = primeNumList.stream().mapToInt(i -> i).toArray();
        if (primeNum.length == 0) {
            primeNum = new int[1];
        }
    }
}
