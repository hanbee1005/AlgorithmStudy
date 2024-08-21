package array;

public class MakeTwoArraysEqualByReversingSubarrays_1460 {
    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1,2,3,4}, new int[]{2,4,1,3}));
        System.out.println(canBeEqual(new int[]{7}, new int[]{7}));
        System.out.println(canBeEqual(new int[]{3,7,9}, new int[]{3,7,11}));
    }

    private static boolean canBeEqual(int[] target, int[] arr) {
        return campareNums(target, arr) && campareNums(arr, target);
    }

    private static boolean campareNums(int[] target, int[] arr){
        int[] buffer = new int[1001];

        for(int num : target){
            ++buffer[num];
        }

        for (int num: arr){
            if (buffer[num] == 0) {
                return false;
            }
            --buffer[num];
        }

        return true;
    }
}
