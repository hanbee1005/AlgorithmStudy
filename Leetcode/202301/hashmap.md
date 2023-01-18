# HashMap

### 1. Two Sum
배열과 target이 주어졌을 때 배열의 두 수를 더해서 target과 같은 두 수의 index를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/TwoSum_1.java)
- 처음에는 단순하게 이중 for 문을 돌면서 모든 수를 확인하면서 target과 같은지 확인하고 같을 때 바로 반환하는 방법으로 구현하였습니다. 이 경우 시간 복잡도는 O(n*n)이 됩니다.
- 해당 문제의 카테고리가 hashmap이라 이를 사용하여 구현한 방법도 알아보았습니다.
- HashMap을 하나 만들고 배열을 처음부터 돌면서 target에서 현재 위치의 수를 빼서 그 값이 HashMap에 key로 존재하는지 확인합니다.
- 존재하는 경우는 이미 이전에 현재 수와 더해서 target이 될 수 있는 수가 있었다는 의미로 이때 현재 인덱스와 HashMap에 담긴 value를 반환합니다.
- 존재하지 않는 경우는 현재 위치의 수를 key로 현재 위치(인덱스)를 value로 해서 HashMap에 저장합니다.
- 계속 배열을 반복하며 위 과정을 확인하므로 시간 복잡도는 O(n)입니다.