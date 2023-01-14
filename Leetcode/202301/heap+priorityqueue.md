# Heap + Priority Queue

### 703. Kth Largest Element in a Stream
Stream에서 K 번째로 큰 수를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/KthLargestElementInAStream_703.java)
- 처음에는 배열로 직접 heap 구현을 하려고 했지만 생각해보니 이미 있는 PriorityQueue를 사용하는게 나을 것 같아서 다음과 같이 해결하였습니다.
- 우선순위 큐에 우선 값을 저장한 뒤
- 우선순위 큐의 크기가 K보다 큰 경우는 값을 하나 뺍니다. 이렇게 하면 우선순위 큐에 담긴 가장 우선 순위가 낮은 수가 뽑히게 되고 우선순위 큐 안에는 K개의 큰 수들만 남게 됩니다.
- 이때 우선순위 큐에 담긴 값 중 가장 작은 값은 확인하면 이 값이 K번째로 큰 수가 됩니다.