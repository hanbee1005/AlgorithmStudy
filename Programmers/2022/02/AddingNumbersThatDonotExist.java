package Feb2022;

public class AddingNumbersThatDonotExist {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
    }

    private static int solution(int[] numbers) {
        int answer = 0;

        boolean[] nums = new boolean[10];
        for (int i : numbers) {
            nums[i] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!nums[i]) answer += i;
        }

        return answer;
    }
}
