import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1065 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(oneStep(num));
    }

    private static int oneStep(int num) {
        int count = 99;

        if (num < 100) {
            return num;
        }

        for (int n = 100; n < num + 1; n++) {
            int a = n;

            List<Integer> oneNums = new ArrayList<>();
            while (a != 0) {
                int val = a / 10;
                int remain = a % 10;
                oneNums.add(remain);
                a = val;
            }

            boolean result = true;
            int gap = oneNums.get(1) - oneNums.get(0);
            for (int i = 1; i < oneNums.size() - 1; i++) {
                int before = oneNums.get(i);
                int after = oneNums.get(i + 1);

                if (after - before == gap) {
                    gap = after - before;
                } else {
                    result = false;
                    break;
                }
            }

            if (result) {
                count++;
            }
        }

        return count;
    }
}
