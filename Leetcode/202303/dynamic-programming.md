# Dynamic Programing

### 64. Minimum Path Sum
주어진 그리드의 끝까지 가는데 지나온 칸에 적힌 수의 합이 가장 적은 경우를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202303/MinimumPathSum_64.java)
- 재귀를 통해 풀다가 시간 초과가 나서... 이중 for문을 사용하여 해결하였습니다.
- 전체 그리드에 대해서 for문을 실행합니다.
- 만약 현재 위치의 i, j 가 0보다 큰 경우는 그 전에 올 수 있던 위치들(위쪽, 왼쪽) 중 합이 더 작은 경우를 추가합니다.
- i만 0보다 크다면 현재 위치의 위쪽에서만 진입할 수 있으므로 위쪽 값을 더해줍니다.
- j만 0보다 크다면 현재 위치의 왼쪽에서만 진입할 수 있으므로 왼쪽 값을 더해줍니다.
- 마지막으로 최종 위치에 있는 값을 반환합니다.

### 121. Best Time to Buy and Sell Stock
배열이 주어졌을 때 값을 사고 팔아서 남게되는 가장 큰 값이 얼마인지를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202303/BestTimeToBuyAndSellStock_121.java)
- 주어진 가격(prices) 배열을 차례로 돌면서
- 현재 가격이 살때 가격보다 싼 경우 현재 가격을 산 가격으로 저장하고
- 현재 가격에서 살때 가격을 뺀 것과 이전에 팔아서 남은 값 중 더 큰 값을 max 값으로 저장합니다.
- 이후 가격 배열을 모두 돌고 나서 max 값을 반환합니다.

### 300. Longest Increasing Subsequence
배열이 주어졌을 때 완전하게 증가하는 가장 긴 서브 배열의 길이를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202303/LongestIncreasingSubsequence_300.java)
- 풀이...

### 53. Maximum Subarray
배열이 주어졌을 때 연속하는 수들을 더해 최대 값을 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202303/MaximumSubarray_53.java)
- 지금까지의 합이 0보다 작으면서 현재 수가 합보다 크거나 같은 경우 합을 0으로 재설정하고
- 합에 지금 수를 더한 뒤
- 기존 최댓값과 현재 합을 비교하여 최대 값을 결정합니다.
- 배열의 처음부터 끝까지 위 과정을 반복한 뒤, 최댓값을 반환합니다.