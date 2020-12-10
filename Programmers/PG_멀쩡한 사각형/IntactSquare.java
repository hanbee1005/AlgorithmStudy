public class IntactSquare {
    public static void main(String[] args) {
        System.out.println(Solution(8, 12));
    }

    private static long Solution(int w, int h) {
        long answer = 1;
        int a = Math.max(w, h);
        int b = Math.min(w, h);

        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        answer = ((long) w * (long) h) - (((long) w / a + (long) h / a - 1) * a);
        return answer;
    }
}
