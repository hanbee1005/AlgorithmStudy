public class MinimumRecolorsToGetKConsecutiveBlackBlocks_2379 {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }

    private static int minimumRecolors(String blocks, int k) {
        int operation = 0, n = blocks.length();

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') operation++;
        }

        int answer = operation;

        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) != blocks.charAt(i)) {
                if (blocks.charAt(i - k) == 'W') operation--;
                else operation++;
            }

            if (answer > operation) {
                answer = operation;
                if (answer == 0) return answer;
            }
        }

        return answer;
    }
}
