import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJAlgo_9466 {
    private static int[] student;

    private static boolean[] visited;  // 각 학생 인덱스를 방문했는지 확인
    private static boolean[] finished;  // 이미 사이클을 확인하고 끝난 인덱스인지 확인

    private static int count; // 사이클을 생성한 인덱스의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            student = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < n + 1; j++) {
                dfs(j);
            }

            System.out.println(n - count);  // 전체 학생 수에서 사이클을 이룬 학생(팀원이 있는 학생) 수 빼기
        }
    }

    private static void dfs(int now) {
        if (visited[now]) {  // 이미 현재 위치를 확인한 경우
            return;  // 종료
        }

        visited[now] = true;  // 현재 위치를 방문한 것으로 처리
        int next = student[now];  // 다음 위치 구하기

        if (!visited[next]) {  // 다음 위치를 방문하지 않은 경우
            dfs(next);  // 다음 위치 방문
        } else {  // 다음 위치를 이미 방문한 경우 (사이클이 생김)
            if (!finished[next]) {  // 다음 위치와 연관된 사이클을 아직 확인하지 않은 경우
                count++;  // 현 위치도 사이클을 구성하므로 + 1
                for (int i = next; i != now; i = student[i]) {
                    count++;  // 사이클을 구성하는 학생 수만큼 + 1
                }
            }
        }

        // 현재 학생과 연관된 학생을 모두 확인하고 사이클까지 확인했으므로 더 이상 현 위치 확인 필요 x
        finished[now] = true;
    }
}
