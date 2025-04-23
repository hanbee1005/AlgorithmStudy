package hashmap;

public class CountLargestGroup_1399 {
    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
        System.out.println(countLargestGroup(2));
    }

    private static int countLargestGroup(int n) {
        int[] count = new int[40];
        int answer = 0, max = 0;

        for (int i = 1; i <= n; ++i) {
            int sum = 0;
            for (int x = i; x > 0; x /= 10) {
                sum += x % 10;
            }

            ++count[sum];

            if (max < count[sum]) {
                max = count[sum];
                answer = 1;
            } else if (max == count[sum]) {
                ++answer;
            }
        }

        return answer;
    }
}
