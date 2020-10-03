import java.io.*;
import java.util.*;

public class BJAlgo_11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        AbsHeap absHeap = new AbsHeap();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                absHeap.pop();
            } else {
                absHeap.insert(num);
            }
        }
    }
}

class AbsHeap {
    List heap;

    AbsHeap() {
        heap = new ArrayList<>();
        heap.add(null);
    }

    boolean move_up(int idx) {
        if (idx <= 1) {
            return false;
        }

        int parent_idx = idx / 2;
        if (Math.abs((int) heap.get(idx)) < Math.abs((int) heap.get(parent_idx))
                || (Math.abs((int) heap.get(idx)) == Math.abs((int) heap.get(parent_idx)) && (int) heap.get(idx) < (int) heap.get(parent_idx))) {
            return true;
        } else {
            return false;
        }
    }

    boolean move_down(int idx) {
        int left_child_idx = idx * 2;
        int right_child_idx = idx * 2 + 1;

        // Case1: 왼쪽 자식도 없을 때
        if (left_child_idx >= heap.size()) {
            return false;
        } else if (right_child_idx >= heap.size()) { // Case2: 오른쪽 자식만 없을 때
            if (Math.abs((int) heap.get(idx)) > Math.abs((int) heap.get(left_child_idx))
                    || (Math.abs((int) heap.get(idx)) == Math.abs((int) heap.get(left_child_idx)) && (int) heap.get(idx) > (int) heap.get(left_child_idx))) {
                return true;
            } else {
                return false;
            }
        } else { // Case3: 왼쪽, 오른쪽 자식 모두 있을 때
            if (Math.abs((int) heap.get(left_child_idx)) < Math.abs((int) heap.get(right_child_idx))
                    || (Math.abs((int) heap.get(left_child_idx)) == Math.abs((int) heap.get(right_child_idx)) && (int) heap.get(left_child_idx) < (int) heap.get(right_child_idx))) {
                if (Math.abs((int) heap.get(idx)) > Math.abs((int) heap.get(left_child_idx))
                        || (Math.abs((int) heap.get(idx)) == Math.abs((int) heap.get(left_child_idx)) && (int) heap.get(idx) > (int) heap.get(left_child_idx))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (Math.abs((int) heap.get(idx)) > Math.abs((int) heap.get(right_child_idx))
                        || (Math.abs((int) heap.get(idx)) == Math.abs((int) heap.get(right_child_idx)) && (int) heap.get(idx) > (int) heap.get(right_child_idx))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    void insert(int data) {
        heap.add(data);

        int idx = heap.size() - 1;
        while (move_up(idx)) {
            int parent_idx = idx / 2;
            int tmp = (int) heap.get(idx);
            heap.set(idx, heap.get(parent_idx));
            heap.set(parent_idx, tmp);
            idx = parent_idx;
        }
    }

    void pop() {
        if (heap.size() <= 1) {
            System.out.println(0);
        } else {
            System.out.println(heap.get(1));

            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int idx = 1;
            while (move_down(idx)) {
                int left_child_idx = idx * 2;
                int right_child_idx = idx * 2 + 1;

                if (right_child_idx >= heap.size()) { // Case2: 오른쪽 자식만 없을 때
                    if (Math.abs((int) heap.get(idx)) > Math.abs((int) heap.get(left_child_idx))
                            || (Math.abs((int) heap.get(idx)) == Math.abs((int) heap.get(left_child_idx)) && (int) heap.get(idx) > (int) heap.get(left_child_idx))) {
                        int tmp = (int) heap.get(idx);
                        heap.set(idx, heap.get(left_child_idx));
                        heap.set(left_child_idx, tmp);
                        idx = left_child_idx;
                    }
                } else { // Case3: 왼쪽, 오른쪽 자식 모두 있을 때
                    if (Math.abs((int) heap.get(left_child_idx)) < Math.abs((int) heap.get(right_child_idx))
                            || (Math.abs((int) heap.get(left_child_idx)) == Math.abs((int) heap.get(right_child_idx)) && (int) heap.get(left_child_idx) < (int) heap.get(right_child_idx))) {
                        if (Math.abs((int) heap.get(idx)) > Math.abs((int) heap.get(left_child_idx))
                                || (Math.abs((int) heap.get(idx)) == Math.abs((int) heap.get(left_child_idx)) && (int) heap.get(idx) > (int) heap.get(left_child_idx))) {
                            int tmp = (int) heap.get(idx);
                            heap.set(idx, heap.get(left_child_idx));
                            heap.set(left_child_idx, tmp);
                            idx = left_child_idx;
                        }
                    } else {
                        if (Math.abs((int) heap.get(idx)) > Math.abs((int) heap.get(right_child_idx))
                                || (Math.abs((int) heap.get(idx)) == Math.abs((int) heap.get(right_child_idx)) && (int) heap.get(idx) > (int) heap.get(right_child_idx))) {
                            int tmp = (int) heap.get(idx);
                            heap.set(idx, heap.get(right_child_idx));
                            heap.set(right_child_idx, tmp);
                            idx = right_child_idx;
                        }
                    }
                }
            }
        }
    }
}
