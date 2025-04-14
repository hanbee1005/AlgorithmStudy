package array;

public class CountGoodTriplets_1534 {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3,0,1,1,9,7},7,2,3));
        System.out.println(countGoodTriplets(new int[]{1,1,2,2,3},0,0,1));
    }

    private static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int answer = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c) {
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
