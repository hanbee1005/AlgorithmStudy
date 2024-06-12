# Heap + Priority Queue

### 703. Kth Largest Element in a Stream
Stream에서 K 번째로 큰 수를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/KthLargestElementInAStream_703.java)
- 처음에는 배열로 직접 heap 구현을 하려고 했지만 생각해보니 이미 있는 PriorityQueue를 사용하는게 나을 것 같아서 다음과 같이 해결하였습니다.
- 우선순위 큐에 우선 값을 저장한 뒤
- 우선순위 큐의 크기가 K보다 큰 경우는 값을 하나 뺍니다. 이렇게 하면 우선순위 큐에 담긴 가장 우선 순위가 낮은 수가 뽑히게 되고 우선순위 큐 안에는 K개의 큰 수들만 남게 됩니다.
- 이때 우선순위 큐에 담긴 값 중 가장 작은 값은 확인하면 이 값이 K번째로 큰 수가 됩니다.

### 347. Top K Frequent Elements
배열에서 자주 반복된 K 개의 수를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/TopKFrequentElements_347.java)
- 주어진 배열의 길이와 k의 길이가 같은 경우 그대로 배열을 반환합니다.
- 그렇지 않은 경우 주어진 배열에서 같은 수가 몇번 반복되는지 map으로 구성합니다. key는 숫자, value는 해당 숫자가 반복된 수를 저장합니다.
- 이후 Priority Queue로 최소 힙을 구성합니다. 큐에는 위에서 만든 map의 key 를 넣고 우선순위 정렬 시 key를 가지고 값을 찾아 비교할 수 있도록 합니다.
- 큐에 key를 하나 넣은 뒤 큐의 크기가 k보다 큰 경우 key를 하나 뺍니다. 이때 빠지는 키는 반복 횟수가 가장 적은 키가 빠지게 됩니다.
- 최종적으로 큐에 있던 key들을 배열로 만들어서 반환합니다. 배열로 만들 때는 가장 반복이 많은 key가 젤 앞에 올 수 있도록 역순으로 저장해줍니다.