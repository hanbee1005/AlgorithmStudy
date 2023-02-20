# Tree, BST

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

### 111. Minimum Depth of Binary Tree
트리를 구성하는 루트 노드가 주어졌을 때 루트로부터 가장 가까운 leaf 노드의 depth를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202302/MinimumDepthOfBinaryTree_111.java)
- 깊이를 구하는 문제이므로 dfs 를 사용합니다.
- 현재 노드와 현재 depth를 파라미터로 받는 재귀함수를 생성합니다.
- 노드가 null 인 경우 최종 answer 값을 0으로 정하고 리턴합니다.
- 현재 노드가 leaf 노드인지 확인하고 leaf 노드인 경우 현재 depth가 최종 answer보다 작은 경우 answer = depth 값을 넣습니다.
- 그렇지 않다면 다음 노드가 있는지 확인하고 재귀함수를 호출할 때 depth+1 을 전달합니다.
- 재귀함수를 모두 확인하고 최종적으로 answer를 반환합니다.

### 617. Merge Two Binary Trees
두 개의 TreeNode가 주어졌을 때 각 자리 수를 합친 새로운 TreeNode를 반환하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202302/MergeTwoBinaryTrees_617.java)
- 주어진 두 개의 TreeNode가 모두 null인 경우는 null을 반환하고
- 둘 중 하나의 TreeNode가 null이라면 null이 아닌 TreeNode를 반환합니다.
- 둘 다 null이 아닌 경우에는 먼저 각각의 왼쪽 노드를 확인하여 하나라도 null이 아니면 재귀함수에 각각의 왼쪽 노드를 전달하고 여기서 나온 반환 값을 왼쪽 노드로 저장합니다.
- 다음으로 각각의 오른쪽 노드를 확인하여 하나라도 null이 아니면 재귀함수에 각각의 오른쪽 노드를 전달하고 여기서 나온 반환 값을 오른쪽 노드로 저장합니다.
- 최종적으로 새로운 TreeNode를 생성하는데 현재 주어진 두 노드의 값을 더해서 현재 값으로 하고 위에서 구한 왼쪽 노드, 오른쪽 노드를 각각 세팅해줍니다.
- 작은 트리들을 먼저 생성하고 그 트리들을 합쳐 다시 큰 트리를 생성하는 방식입니다.

### 108. Convert Sorted Array to Binary Search Tree
정렬된 배열이 주어졌을 때 각 서브트리의 깊이가 2이상 차이나지 않는 height-balanced 트리를 생성하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202302/ConvertSortedArrayToBinarySearchTree_108)
- 정렬된 배열에서 중간 값을 가지고 먼저 새 TreeNode를 생성합니다.
- 이후 배열에서 중간 기준으로 왼쪽에 값들이 있다면 이 배열을 왼쪽만 다시 재귀 함수로 전달하고 그 반환 값을 새로 생성한 TreeNode의 왼쪽 노드로 저장합니다.
- 마찬가지로 배열에서 중간 기준으로 오른쪽에 값들이 있다면 이 배열을 오른쪽만 다시 재귀 함수로 전달하고 그 반환 값을 새로 생성한 TreeNode의 오른쪽 노드로 저장합니다.
- 최종적으로 재귀 함수에서 이렇게 생성한 새 TreeNode를 반환합니다.
- 이 문제 또한 작은 트리를 생성하고 이를 합쳐 더 큰 트리를 만드는 방식으로 해결하였습니다.
