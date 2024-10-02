package array;

import java.util.*;

public class RankTransformOfAnArray_1331 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{40, 10, 20, 30})));
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{100,100,100})));
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
    }

    private static int[] arrayRankTransform(int[] arr) {
        int[] answer = new int [arr.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int val: arr) {
            max = Math.max(val, max);
            min = Math.min(val, min);
        }

        if (max - min > 200 && arr.length < 10) {
            int [] tmp = arr.clone();
            Arrays.sort(arr);
            int index = 1;
            boolean isRepeat = false;
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                isRepeat = false;
                for (int j = 0; j < tmp.length; j++) {
                    if (tmp[j] == val) {
                        if (isRepeat) {
                            i++;
                        }
                        answer[j] = index;
                        isRepeat = true;
                    }
                }
                index++;
            }
            return answer;

        } else {
            int[] nums = new int [max - min + 1];
            for (int j : arr) {
                nums[j - min] = 1;
            }

            int rank = 1;
            for (int i = 0; i < max - min + 1; i++) {
                if (nums[i] == 1) {
                    nums[i] = rank;
                    rank++;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                answer[i] = nums[arr[i] - min];
            }

            return answer;
        }
    }
}
