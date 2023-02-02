# Graph, BFS, DFS

### 104. Maximum Depth of Binary Tree
트리를 구성하는 루트 노드가 주어졌을 때 트리의 깊이(depth)를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202302/MaximumDepthOfBinaryTree_104.java)
- 최대 깊이를 구하는 문제이므로 dfs 를 사용합니다.
- 현재 노드와 현재 depth를 파라미터로 받는 재귀함수를 생성합니다.
- 노드가 null 인 경우 바로 리턴합니다.
- 그렇지 않다면 지금까지 depth(=answer)가 현재 depth보다 작은 경우 answer = depth 값을 넣습니다.
- 그리고 왼쪽 노드가 있는 경우 재귀함수를 호출하는데 이때 왼쪽 노드와 depth+1을 전달합니다.
- 마찬가지로 오른쪽도 확인을 합니다.
- 재귀함수를 모두 확인하고 최종적으로 answer를 반환합니다.