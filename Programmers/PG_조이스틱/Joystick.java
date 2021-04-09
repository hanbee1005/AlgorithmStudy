public class Joystick {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }

    private static int solution(String name) {
        int answer = 0;
        char[] chars = name.toCharArray();
        int[] matchCount = new int[name.length()];

        // 각 문자를 가장 빠르게 찾는 횟수를 저장
        for (int i = 0; i < chars.length; i++) {
            matchCount[i] = findChar(chars[i]);
        }

        int start = 0;
        while (true) {
            answer += matchCount[start];  // 현재 위치 문자를 변경하는데 필요한 조이스틱 상하 이동 횟수 추가
            matchCount[start] = 0;  // 현재 위치 문자는 변경이 완료되었으므로 변경이 필요한 횟수 0으로 수정

            int leftMove = findIdx(matchCount, start, -1);  // 왼쪽으로 이동하면서 가장 가까운 변경이 필요한 문자까지의 이동 거리 구하기
            int rightMove = findIdx(matchCount, start, 1);  // 오른쪽으로 이동하면서 가장 가까운 변경이 필요한 문자까지의 이동 거리 구하기

            // 더 이상 변경이 필요한 문자가 존재하지 않는 경우 반복 종료
            if (leftMove == 0 && rightMove == 0) {
                break;
            }

            // 왼쪽으로 이동하는 것이 더 가까운 경우
            if (leftMove < rightMove) {
                start = start - leftMove >= 0 ? start - leftMove : matchCount.length - (leftMove - start);  // 조이스틱을 왼쪽으로 이동시키고
                answer += leftMove;  // 조이스틱을 왼쪽으로 이동시킨 횟수 추가
            } else {
                start = start + rightMove < matchCount.length ? start + rightMove : rightMove - (matchCount.length - start);  // 조이스틱을 오른쪽으로 이동시키고
                answer += rightMove;  // 조이스틱을 오른쪽으로 이동시킨 횟수 추가
            }
        }

        return answer;
    }

    // 'A' 부터 원하는 문자를 찾는데까지 조이스틱을 이동한 횟수 구하기
    // 위로 이동해서 찾은 경우와 아래로 이동해서 찾은 경우 중 더 작은 수를 반환
    private static int findChar(char current) {
        return Math.min(Math.abs('A' - current), Math.abs('Z' - current) + 1);
    }

    // 현재 위치부터 왼쪽 또는 오른쪽으로 이동하면서 변경이 필요한 문자까지 이동한 거리를 반환
    // 더 이상 변경이 필요한 문자가 없는 경우 0을 리턴
    private static int findIdx(int[] cnt, int cur, int direct) {
        int count = 0;
        int idx = cur;

        while (count < cnt.length) {
            count++;  // 이동 횟수 증가
            // direct에 맞게 왼쪽 또는 오른쪽으로 이동한 다음 위치 인덱스 구하기
            idx = idx + direct < 0 ? cnt.length - 1 : (idx + direct >= cnt.length ? 0 : idx + direct);

            // 다음 위치 문자가 변경이 필요한 문자인 경우
            if (cnt[idx] != 0) {
                return count;  // 이동 횟수 반환
            }
        }

        return 0;
    }
}
