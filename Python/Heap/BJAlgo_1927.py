from sys import stdin


class Heap:
    def __init__(self):
        self.heap = list()
        self.heap.append(None)

    def move_up(self, idx):
        if idx <= 1:
            return False

        parent_idx = idx // 2
        if self.heap[idx] < self.heap[parent_idx]:
            return True
        else:
            return False

    def move_down(self, idx):
        left_child_idx = idx * 2
        right_child_idx = idx * 2 + 1

        # Case1: 왼쪽 자식도 없을 때
        if left_child_idx >= len(self.heap):
            return False

        # Case2: 오른쪽 자식만 없을 때
        elif right_child_idx >= len(self.heap):
            if self.heap[idx] > self.heap[left_child_idx]:
                return True
            else:
                return False

        # Case3: 왼쪽, 오른쪽 자식 모두 있을 때
        else:
            if self.heap[left_child_idx] < self.heap[right_child_idx]:
                if self.heap[idx] > self.heap[left_child_idx]:
                    return True
                else:
                    return False
            else:
                if self.heap[idx] > self.heap[right_child_idx]:
                    return True
                else:
                    return False

    def insert(self, data):
        self.heap.append(data)

        idx = len(self.heap) - 1
        while self.move_up(idx):
            parent_idx = idx // 2
            self.heap[idx], self.heap[parent_idx] = self.heap[parent_idx], self.heap[idx]
            idx = parent_idx

    def pop(self):
        if len(self.heap) <= 1:
            print(0)
        else:
            print(self.heap[1])

            self.heap[1] = self.heap[-1]
            del self.heap[-1]

            idx = 1
            while self.move_down(idx):
                left_child_idx = idx * 2
                right_child_idx = idx * 2 + 1

                # Case2: 오른쪽 자식만 없을 때
                if right_child_idx >= len(self.heap):
                    if self.heap[idx] > self.heap[left_child_idx]:
                        self.heap[idx], self.heap[left_child_idx] = self.heap[left_child_idx], self.heap[idx]
                        idx = left_child_idx

                # Case3: 왼쪽, 오른쪽 자식 모두 있을 때
                else:
                    if self.heap[left_child_idx] < self.heap[right_child_idx]:
                        if self.heap[idx] > self.heap[left_child_idx]:
                            self.heap[idx], self.heap[left_child_idx] = self.heap[left_child_idx], self.heap[idx]
                            idx = left_child_idx
                    else:
                        if self.heap[idx] > self.heap[right_child_idx]:
                            self.heap[idx], self.heap[right_child_idx] = self.heap[right_child_idx], self.heap[idx]
                            idx = right_child_idx


h = Heap()
N = int(stdin.readline())
for _ in range(N):
    num = int(stdin.readline())
    if num == 0:
        h.pop()
    else:
        h.insert(num)