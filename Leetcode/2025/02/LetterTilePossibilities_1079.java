package backtracking;

public class LetterTilePossibilities_1079 {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
        System.out.println(numTilePossibilities("V"));
    }

    private static int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        return permute(0, arr);
    }

    public static int permute(int start, char[] arr) {
        if(start == arr.length) return 0;

        int answer = 0;
        for (int i = start; i < arr.length; i++) {
            if (!isPermutedBefore(start, i - 1, arr[i], arr)) {
                swap(start, i, arr);
                answer += 1 + permute(start + 1, arr);
                swap(start, i, arr);
            }
        }

        return answer;
    }

    public static boolean isPermutedBefore(int i, int j, char ch, char[] arr) {
        while (i <= j) {
            if (arr[i++] == ch) return true;
        }

        return false;
    }

    public static void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
