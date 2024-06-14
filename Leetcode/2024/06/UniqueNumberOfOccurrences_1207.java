package array;

public class UniqueNumberOfOccurrences_1207 {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[]{1,2}));
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];

        for (int num : arr) {
            int idx = num < 0 ? (num * -1) + 1000 : num;
            freq[idx]++;
        }

        boolean[] result = new boolean[freq.length];
        for (int count : freq) {
            if (count != 0 && result[count]) return false;
            result[count] = true;
        }

        return true;
    }
}
