package Feb2022;

public class WorkoutClothes {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n+1];

        for (int lostStudent : lost) {
            students[lostStudent] -= 1;
        }

        for (int reserveStudent : reserve) {
            students[reserveStudent] += 1;
        }

        for (int i = 1; i < students.length - 1; i++) {
            if (students[i] == 1) {  // 여분이 있는 경우
                // 뒷사람이 옷이 필요하다면 주기
                if (students[i+1] == -1) {
                    students[i] -= 1;
                    students[i+1] += 1;
                }
                answer++;
            } else if (students[i] == -1) {  // 도둑 맞은 경우
                // 뒷사람이 여분의 옷이 있다면 빌리기
                if (students[i+1] == 1) {
                    students[i] += 1;
                    students[i+1] -= 1;
                    answer++;
                }
            } else {
                answer++;
            }
        }

        if (students[n] >= 0) answer++;

        return answer;
    }
}
