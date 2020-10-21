# AlgorithmStudy
Java, Python 알고리즘 공부
- 문제는 백준 알고리즘(Baekjoon Online Judge) 문제를 주로 풀이

### Array
데이터를 나열하고, 각 데이터를 인덱스에 대응하도록 구성한 데이터 구조
- 장점
  - 빠른 접근

- 단점
  - 크기를 미리 알아야 함
  - 데이터가 가변적인 경우 추가, 삭제가 번거로움 (파이썬에서는 list 타입이 배열 기능을 제공하여 단점 해결)

- 풀이한 문제
  - Python: 10818(최소, 최대), 2562(최댓값)
  - Java: 10818(최소, 최대)

### Queue
가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 구조로 FIFO(First-In, First-Out) 또는, LILO(Last-In, Last-Out) 방식

- 알아둘 용어
  - Enqueue: 큐에 데이터를 넣는 기능
  - Dequeue: 큐에서 데이터를 꺼내는 기능

- 용도
  - 프로세스 스케줄링 구현을 위해 많이 사용됨

- 풀이한 문제
  - Python: 10845(큐), 1158(요세푸스 문제) - print 시 format 사용, 2164(카드2) - deque 라이브러리 사용
  - Java: 10845(큐), 1158(요세푸스 문제), 2164(카드2)
  
### Stack
가장 나중에 쌓은 데이터를 가장 먼저 빼낼 수 있는 데이터 구조로 LIFO(Last-In, First-Out) 또는 FILO(First-In, Last-Out) 데이터 관리 방식

- 알아둘 용어
  - push: 데이터를 스택에 넣기
  - pop: 데이터를 스택에서 꺼내기

- 장점
  - 구조가 단순해서, 구현이 쉽다.
  - 데이터 저장/읽기 속도가 빠르다.

- 단점 (일반적인 스택 구현 시)
  - 데이터 최대 갯수를 미리 정해야 한다. (파이썬의 경우 재귀 함수는 1000번까지만 호출이 가능함)
  - 저장 공간의 낭비가 발생할 수 있다. (미리 최대 갯수만큼 저장 공간을 확보해야 함)

- 풀이한 문제
  - Python: 10828(스택), 10773(제로), 9012(괄호), 4949(균형잡힌 세상), 1874(스택 수열)
  - Java: 10828(스택), 10773(제로), 9012(괄호), 4949(균형잡힌 세상), 1874(스택 수열)
  
### Hash Table
키(key)에 데이터(value)를 저장하는 데이터 구조 (파이썬에서는 딕셔너리 타입을 사용하면 됨)

- 알아둘 용어
  - 해쉬(Hash): 임의 값을 고정 길이로 변환하는 것
  - 해쉬 테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
  - 해싱 함수(Hashing Function): Key에 대해 산술 연산을 이용해 데이터 위치를 찾을 수 있는 함수
  - 해쉬 값(Hash Value) 또는 해쉬 주소(Hash Address): Key를 해싱 함수로 연산해서, 해쉬 값을 알아내고, 이를 기반으로 해쉬 테이블에서 해당 키에 대한 데이터 위치를 일관성 있게 찾을 수 있음
  - 슬롯(Slot): 한 개의 데이터를 저장할 수 있는 공간

- 장점
  - 데이터 저장/읽기 속도가 빠르다. (검색 속도가 빠르다.)
  - 해쉬는 키에 대한 데이터가 있는지(중복) 확인이 쉬움

- 단점
  - 일반적으로 저장 공간이 좀 더 많이 필요하다.
  - 여러 키에 대한 주소가 동일할 경우, 충돌을 해결하기 위한 별도의 자료구조가 필요

- 주요 용도
  - 검색이 많이 필요한 경우
  - 저장, 삭제, 읽기가 빈번한 경우
  - 캐시 구현 시 (중복 확인이 쉽기 때문)

- 풀이한 문제
  - Python: 15829(Hashing), 10928(SHA-1), 1764(듣보잡), 2002(추월)
  - Java: 1764(듣보잡), 2002(추월)
  
### Tree
Node와 Branch를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조

- 알아둘 용어
  - Node: 트리에서 데이터를 저장하는 기본 요소 (데이터와 다른 연결된 노드에 대한 Branch 정보 포함)
  - Root Node: 트리 맨 위에 있는 노드
  - Level: 최상위 노드를 Level 0으로 하였을 때, 하위 Branch로 연결된 노드의 깊이를 나타냄
  - Parent Node: 어떤 노드의 다음 레벨에 연결된 노드
  - Child Node: 어떤 노드의 상위 레벨에 연결된 노드
  - Leaf Node (Terminal Node): Child Node가 하나도 없는 노드
  - Sibling (Brother Node): 동일한 Parent Node 를 가진 노드
  - Depth: 트리에서 Node가 가질 수 있는 최대 Level

- 이진 트리: 노드의 최대 Branch가 2인 트리
- 이진 탐색 트리 (Binary Search Tree, BST): 이진 트리에 다음과 같은 추가적인 조건이 있는 트리로 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음!
  - 장점
    - 탐색 속도를 개선할 수 있음
  - 용도
    - 데이터 검색(탐색)

- 풀이한 문제
  - Python: 5639(이진 검색 트리) - 트리 생성 없이 해결한 경우, 5639_tree - 트리 생성하여 구현
  - Java: 5639(이진 검색 트리) - 트리 생성 없이 해결한 경우, 5639_tree - 트리 생성하여 구현
  
### Heap
데이터에서 최대값과 최소값을 빠르게 찾기 위해 고안된 완전 이진 트리(Complete Binary Tree)

- 용도
  - 우선순위 큐와 같이 최대값 또는 최소값을 빠르게 찾아야 하는 자료구조 및 알고리즘 구현 등에 활용됨

- 구조
  - 힙은 최대값을 구하기 위한 구조(최대 힙, Max Heap) 와 최소값을 구하기 위한 구조(최소 힙, Min Heap) 로 분류할 수 있음
  - 힙은 다음과 같이 두 가지 조건을 가지고 있는 자료구조임
	  1. 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 크거나 같다. (최대 힙의 경우)
		    최소 힙의 경우는 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 크거나 작음
	  2. 완전 이진 트리 형태를 가짐

- 풀이한 문제
  - Python: 11279(최대 힙), 1927(최소 힙), 11286(절댓값 힙), 2220(힙 정렬), 1655(가운데를 말해요) - 최대 힙, 최소 힙 2개 사용
  - Java: 11279(최대 힙), 1927(최소 힙), 11286(절댓값 힙), 2220(힙 정렬)
  
### BubbleSort
두 인접한 데이터를 비교해서 앞에 있는 데이터가 뒤에 있는 데이터보다 크면, 자리를 바꾸는 정렬

- 구현 특징
  - 뒤에서 부터 정렬이 완성되므로 이중 for 문을 사용하여 구현 시 내부 for 문의 반복 범위가 점차 감소되도록 구현

- 시간 복잡도
  - O(n²) / 완전 정렬되어 있는 경우 O(n)

- 풀이한 문제
  - Python: 1838(버블 정렬), 11920(버블 정렬), 2750(수 정렬하기)
  - Java: 1838(버블 정렬), 11920(버블 정렬), 2750(수 정렬하기)
  
### SelectSort
주어진 리스트에서 최소값을 찾아 맨 앞 위치와 교체하고 맨 앞의 데이터를 뺀 나머지 데이터를 동일한 방법으로 반복하며 정렬

- 구현 특징
  - 각 리스트의 맨 앞 인덱스(stand)와 최소값의 인덱스(lowest) 변수를 사용

- 시간 복잡도
  - O(n²)

- 풀이한 문제
  - Python: 2750(수 정렬하기)
  - Java: 2750(수 정렬하기)
  
### InsertionSort
두 번째 인덱스부터 시작하여 앞에 있는 데이터(B)와 비교하고 기준 인덱스 데이터가 저 작으면 데이터를 서로 바꾸다가 기준 인덱스 데이터가 더 큰 경우가 되면 해당 반복을 중지하고 기준 인덱스를 원래 기준 인덱스의 다음으로 이동시키면서 정렬

- 구현 특징
  - 두 번째 인덱스부터 시작

- 시간 복잡도
  - O(n²) / 완전 정렬되어 있는 경우는 O(n)

- 풀이한 문제
  - Python: 2750(수 정렬하기)
  - Java: 2750(수 정렬하기)
  
### RecursiveCall
함수 안에서 동일한 함수를 호출하는 형태

- 구현 특징
  - 팩토리얼 문제가 대표적

- 시간 복잡도
  - O(n)

- 풀이한 문제
  - Python: 10872(팩토리얼), 10870(피보나치 수 5), 11729(하노이 탑 이동 순서), 2447(별찍기 - 10)
  - Java: 10872(팩토리얼), 10870(피보나치 수 5), 11729(하노이 탑 이동 순서), 2447(별찍기 - 10)
  
### QuickSort
기준점(pivot)을 정해서, 기준점보다 작은 데이터는 왼쪽에, 그렇지 않은 데이터는 오른쪽으로 모으는 함수를 만들고 각 왼쪽, 오른쪽 리스트는 재귀 용법을 통해 해당 함수를 반복 실행하면서 왼쪽 + [pivot] + 오른쪽 을 합친 리스트를 반환하는 정렬 

- 구현 특징
  - 기준점 pivot 을 지정 (보통 리스트의 0번째 데이터를 선정)

- 시간 복잡도
  - O(nlogn) / 최악의 경우: O(n²)

- 풀이한 문제
  - Python: 1427(소트인사이드), 11650(좌표 정렬하기), 11651(좌표 정렬하기2), 1181(단어 정렬), 10814(나이순 정렬)

### MergeSort
리스트를 절반으로 잘라서 비슷한 크기의 리스트를 만들고 각 부분 리스트를 더 이상 자를 수 없을 때까지 나눈 뒤, 하나의 정렬된 리스트로 병합하여 재귀적으로 반환하는 정렬

- 구현 특징
  - 리스트를 나누는 함수(split(data_list))와 리스트를 병합하는 함수(merge(left_list, right_list))를 구현

- 시간 복잡도
  - O(nlogn)

- 풀이한 문제
  - Python: 2751(수 정렬하기 2)

### Binary Search

### Sequential Search

### Graph

### BFS/DFS
- 너비 우선 탐색(Breadth First Search): 정점들과 같은 레벨에 있는 노드들(형제 노드들)을 먼저 탐색하는 방식
- 깊이 우선 탐색(Depth First Search): 정점의 자식들을 먼저 탐색하는 방식

- 구현 특징
  - BFS 는 2개의 Queue 를 사용 (visited, need_visit 2개의 리스트로 구현 가능)
  - DFS 는 1개의 Queue 와 1개의 Stack 을 사용 (visited - 큐, need_visit - 스택 2개의 리스트로 구현 가능)

- 시간 복잡도
  - O(V+E) (V: 정점 수, E: 간선 수)
  
- 풀이한 문제
  - python: 1260 (DFS와 BFS), 2606 (바이러스)
