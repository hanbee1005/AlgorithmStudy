package greedy;

public class BestSightseeingPair_1014 {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
        System.out.println(maxScoreSightseeingPair(new int[]{1,2}));
    }

    private static int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int m = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] - i + m > ans)
                ans = values[i] - i + m;

            if (values[i] + i > m)
                m = values[i] + i;
        }

        return ans;
    }
}
