# LinkedList

### 141. Linked List Cycle
ListNode인 head가 주어졌을 때 Cycle이 존재하는지 확인하는 문제입니다. 
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/LinkedListCycle_141.java)
- 토끼와 거북이 알고리즘을 응용하면 됩니다.
- 주어진 노드를 `fast`와 `slow`에 옮겨 담습니다.
- `fast` 노드는 2씩 움직이고 `slow` 노드는 1씩 움직입니다.
- 싸이클이 존재한다면 `fast`와 `slow`는 싸이클에 빠져서 무한히 반복되고, `fast` 노드가 `slow` 노드보다 1씩 빠르기 때문에 거리가 1씩 줄어들어 언젠가는 만나게 됩니다. (리턴 `true`)
- 만약 앞서 나가던 `fast` 노드가 (`null`이 되거나) `null`을 마주친다면 싸이클이 존재하지 않아 `false`를 리턴하게 됩니다.