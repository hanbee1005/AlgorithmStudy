package Jun2024;

/**
 * Level 3. 스타 수열
 */
public class AStarSequence {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0}));
        System.out.println(solution(new int[]{5,2,3,3,5,3}));
        System.out.println(solution(new int[]{0,3,3,0,7,2,0,2,2,0}));
    }

    private static int solution(int[] a) {
        int answer = 0;

        int[] cnt = new int[a.length];
        for (int n : a) {
            cnt[n]++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] <= answer) continue;

            int ans = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] != a[j + 1] && (i == a[j] || i == a[j + 1])) {
                    ans++;
                    j++;
                }
            }

            answer = Math.max(answer, ans);
        }

        return answer * 2;
    }
}
