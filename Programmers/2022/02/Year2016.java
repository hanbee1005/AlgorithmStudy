package Feb2022;

public class Year2016 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    private static String solution(int a, int b) {
        String answer = "";

        int[] days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int totalDay = 0;

        for (int i = 0; i < a - 1; i++) {
            totalDay += days[i];
        }

        totalDay += b;

        answer = day[totalDay % 7];

        return answer;
    }
}
