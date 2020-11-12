import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJAlgo_2751 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // Arrays.sort(nums);
        nums = mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;

        int[] left = new int[mid];
        System.arraycopy(array, 0, left, 0, left.length);
        left = mergeSort(left);

        int[] right = new int[array.length - mid];
        System.arraycopy(array, mid, right, 0, right.length);
        right = mergeSort(right);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i += 1;
            } else {
                array[k] = right[j];
                j += 1;
            }
            k += 1;
        }

        if (i == left.length) {
            while (j < right.length) {
                array[k] = right[j];
                j += 1;
                k += 1;
            }
        } else if (j == right.length) {
            while (i < left.length) {
                array[k] = left[i];
                i += 1;
                k += 1;
            }
        }

        return array;
    }
}
