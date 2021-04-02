import java.util.Arrays;

public class KNumber {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;
        for (int[] command : commands) {
            int[] splitArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(splitArray);
            answer[idx] = splitArray[command[2] - 1];
            idx++;
        }

        return answer;
    }
}
