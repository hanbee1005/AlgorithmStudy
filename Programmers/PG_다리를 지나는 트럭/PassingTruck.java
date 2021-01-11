import java.util.LinkedList;
import java.util.Queue;

public class PassingTruck {
    public static void main(String[] args) {
        int result = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;  // 걸리는 시간
        int bridge_weight = 0;  // 현재 다리 위에 올라온 트럭의 무게

        Queue<Integer> bridge = new LinkedList<>();  // 다리

        // 주어진 트럭이 모두 다리 위로 올라갈 때까지 수행
        for (int i = 0; i < truck_weights.length; i++) {
            int now = truck_weights[i];
            while (true) {
                if (bridge.isEmpty()) {  // CASE 1. 다리가 비어 있는 경우
                    bridge.add(now);  // 현재 트럭 다리 위로 올리기
                    answer += 1;  // 시간 추가
                    bridge_weight += now;  // 다리 위로 올라온 트럭 무게 증가
                    break;
                } else if (bridge.size() == bridge_length) {  // CASE 2. 다리에 올라온 트럭의 수가 다리 길이와 같은 경우
                    bridge_weight -= bridge.poll();  // 맨 처음 들어온 트럭 빼기
                } else {  // CASE 3. 위 두가지 경우가 아닌 경우 새로운 트럭을 추가하는데
                    if (now + bridge_weight > weight) {  // 다음 무게의 합이 다리 무게보다 큰 경우 (다음 트럭 추가 불가)
                        bridge.add(0);  // 임시로 0 추가
                        answer += 1;  // 시간 추가
                    } else {
                        bridge.add(now);  // 현재 트럭 다리 위로 올리기
                        answer += 1;  // 시간 추가
                        bridge_weight += now;  // 다리 위로 올라온 트럭 무게 증가
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}
