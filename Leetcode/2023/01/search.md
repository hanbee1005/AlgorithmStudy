# Search

### 35. Search Insert Position
배열과 target이 주어졌을 때 target이 들어갈 위치(인덱스)를 반환하는 문제
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/SearchInsertPosition.java)
- target이 배열의 첫번째 수보다 작은 경우 0, 마지막 수보다 큰 경우는 nums.length를 반환하도록 하였습니다.
- 그렇지 않은 경우는 l,r 두가지 위치를 가지고 중간 인덱스를 찾아서 중간 인덱스의 값과 target이 같으면 중간 인덱스를 반환하고
- 중간 인덱스의 값보다 작은 경우 r을 (중간 인덱스 - 1)로 큰 경우는 l을 (중간 인덱스 + 1)로 이동시켜서 절반만 다시 비교할 수 있도록 하였습니다.
- 이를 반복한 뒤 l이 r과 같거나 l이 더 커지는 경우 l 인덱스의 값과 target을 비교해서 l 인덱스의 값이 더 작거나 같은 경우는 l을 그렇지 않은 경우 l+1을 반환할 수 있도록 하였습니다. 