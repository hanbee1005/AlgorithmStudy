package May2024;

/**
 * Level 3. 광고 삽입
 */
public class InsertAds {
    public static void main(String[] args) {
        System.out.println(solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
        System.out.println(solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
        System.out.println(solution("50:00:00", "50:00:00", new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
    }

    private static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playTime = convertStringToTime(play_time);
        int advTime = convertStringToTime(adv_time);

        if (playTime == advTime) {
            return "00:00:00";
        }

        int[] times = new int[360001];
        for (String log : logs) {
            String[] t = log.split("-");
            int start = convertStringToTime(t[0]);
            int end = convertStringToTime(t[1]);

            times[start] += 1;
            times[end] -= 1;
        }

        for (int t = 1; t < times.length; t++) {
            times[t] += times[t-1];
        }

        long max = 0;
        long current = max;
        int start = 0;
        for (int t = 0; t <= playTime - advTime; t++) {
            current += times[t + advTime] - times[t];
            if (max < current) {
                max = current;
                start = t+1;
            }
        }

        answer = convertTimeToString(start);
        return answer;
    }

    private static int convertStringToTime(String time) {
        String[] ts = time.split(":");
        return Integer.parseInt(ts[0]) * 3600 + Integer.parseInt(ts[1]) * 60 +Integer.parseInt(ts[2]);
    }

    private static String convertTimeToString(int time) {
        long h = time / 3600;
        long m = (time % 3600) / 60;
        long s = (time % 3600) % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
