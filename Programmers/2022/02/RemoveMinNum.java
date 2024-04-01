package Feb2022;

import java.util.Arrays;

public class RemoveMinNum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1})));
    }

    private static int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[idx]) idx = i;
        }

        int finalIdx = idx;
        int[] answer = Arrays.stream(arr).filter(num -> num != arr[finalIdx]).toArray();

        return answer;
    }
}
