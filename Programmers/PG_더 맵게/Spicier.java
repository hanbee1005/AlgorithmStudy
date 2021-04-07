import java.util.ArrayList;

public class Spicier {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;

        MinHeap foodScoville = new MinHeap();

        for (int s : scoville) {
            foodScoville.insert(s);
        }

        while (true) {
            int first = foodScoville.delete();

            // 최소 힙이 비어있는 경우
            if (first == 0) {
                break;
            }

            // 가장 맵지 않은 음식의 스코빌 지수가 목표 스코빌 지수보다 작은 경우 (섞을 필요가 있음)
            if (first < K) {
                int second = foodScoville.delete();

                if (second == 0) {
                    return -1;
                }

                foodScoville.insert(first + (second * 2));
                answer++;
            } else {  // 모든 음식의 스코빌 지수가 목표 스코빌 지수의 이상이 된 경우 종료
                return answer;
            }
        }

        return -1;
    }

    private static class MinHeap {
        private ArrayList<Integer> minHeep;

        public MinHeap() {
            this.minHeep = new ArrayList<>();
            this.minHeep.add(0);
        }

        // 최소 힙에 숫자 추가
        public void insert(int num) {
            minHeep.add(num);  // 가장 마지막에 우선 숫자 추가
            int idx = minHeep.size() - 1;  // 가장 마지막 인덱스 구하기

            // 루트로 이동하면서 부모 노드가 자식 노드보다 작은 경우 swap
            while (idx > 1 && minHeep.get(idx / 2) > minHeep.get(idx)) {
                int tmp = minHeep.get(idx);
                minHeep.set(idx, minHeep.get(idx / 2));
                minHeep.set(idx / 2, tmp);

                idx = idx / 2;  // 부모 인덱스로 이동
            }
        }

        // 최소 힙에서 루트 삭제
        public int delete() {
            // 힙에 더이상 값이 없는 경우
            if (minHeep.size() - 1 < 1) {
                return 0;
            }

            // Heap에서 최소값 뽑기
            int popMinValue = minHeep.get(1);

            // 루트에 가장 마지막 값을 넣고 마지막 값은 삭제
            minHeep.set(1, minHeep.get(minHeep.size() - 1));
            minHeep.remove(minHeep.size() - 1);

            // 다시 최소 힙 만들기
            int idx = 1;
            while ((idx * 2) < minHeep.size()) {
                // 먼저 왼쪽 자식을 변경할 자식으로 지정
                int childIdx = idx * 2;
                int child = minHeep.get(childIdx);

                // 만약 오른쪽 자식이 존재하고 오른쪽 자식이 왼쪽 자식보다 작은 경우
                // 변경할 자식을 오른쪽 자식으로 지정
                if (childIdx + 1 < minHeep.size() && child > minHeep.get(childIdx + 1)) {
                    childIdx += 1;
                    child = minHeep.get(childIdx);
                }

                // 부모 노드가 자식 노드보다 작은 경우 종료
                if (minHeep.get(idx) < child) {
                    break;
                }

                // 부모 노드와 자식 노드 swap
                int tmp = minHeep.get(idx);
                minHeep.set(idx, child);
                minHeep.set(childIdx, tmp);

                idx = childIdx;
            }

            return popMinValue;
        }
    }
}
