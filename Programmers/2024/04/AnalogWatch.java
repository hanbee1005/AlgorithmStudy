package Apr2024;

/**
 * Level 2. 아날로그 시계
 */
public class AnalogWatch {
    public static void main(String[] args) {
        System.out.println(solution(0,	5,	30,	0,	7,	0));
        System.out.println(solution(12,	0,	0,	12,	0,	30));
        System.out.println(solution(0,	6,	1,	0,	6,	6));
        System.out.println(solution(11,	59,	30,	12,	0,	0));
        System.out.println(solution(11,	58,	59,	11,	59,	0));
        System.out.println(solution(1,	5,	5,	1,	5,	6));
        System.out.println(solution(0,	0,	0,	23,	59,	59));
    }

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 00:00:00 ~ 종료 시간까지 울린 알람 수 - 00:00:00 ~ 시작 시간까지 울린 알람 수 + 시작 시간이 알람시간인 경우(+1)
        int t1 = hmsToSec(h1, m1, s1), t2 = hmsToSec(h2, m2, s2);
        return countAlram(t2) - countAlram(t1) + (alramNow(t1) ? 1 : 0);
    }

    private static int hmsToSec(int h, int m, int s) {
        m += h * 60;
        s += m * 60;
        return s;
    }

    private static int countAlram(int time) {
        // 시침은 12시간(43200초)에 한바퀴를 돌며, 같은시간에 초침은 720바퀴를 돈다
        // -> 시-초 알람은 43200초 동안 719번 울리며, 43200/719 초마다 1회 울린다
        int h_alram = time * 719 / 43200;
        // 분침은 1시간(3600초)에 한바퀴, 같은시간에 초침은 60바퀴를 돈다
        // -> 분-초 알람은 3600초 동안 59번 울리며, 3600/59 초마다 1회 울린다
        int m_alram = time * 59 / 3600;
        // 00시 및 12시 정각에는 시-초 / 분-초 알람이 동시에 울려 1회 페널티
        int penalty = 43200 <= time ? 2 : 1;

        return h_alram + m_alram - penalty;
    }

    private static boolean alramNow(int time) {
        return time * 719 % 43200 == 0 || time * 59 % 3600 == 0;
    }
}
