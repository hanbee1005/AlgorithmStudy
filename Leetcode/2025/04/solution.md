# 문제 풀이

### 2460. Apply Operations to an Array ```EASY```
- 배열이 주어졌을 때, nums[i] == nums[i+1]과 같을 때 nums[i] 값은 2를 곱하고 nums[i+1]은 0으로 변경한 뒤 최종적으로 0을 제일 뒤로 몬 배열을 반환하는 문제
- 먼저 배열을 돌면서 nums[i] == nums[i+1]과 같을 때 nums[i] 값은 2를 곱하고 nums[i+1]은 0으로 변경합니다.
- 그리고 정답 배열을 생성한 뒤, idx = 0을 지정하고 이전 배열을 돌면서 0이 아닌 경우 idx 위치에 넣은 뒤 idx를 증가시킵니다.
- 이후 정답 배열을 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n) (n <= 2000)

### 2873. Maximum Value of an Ordered Triplet I ```EASY```
- 정수 배열이 주어졌을 때, `(nums[i] - nums[j]) * nums[k]` (i < j < k) 의 최대값을 구하는 문제 (만약 모두 음수이면 0을 반환)
- imax: 지금까지 만난 수 중 가장 큰 수를 기억합니다. → a 후보
- dmax: 지금까지 가능한 (a - b) 값 중 최댓값을 저장합니다. → (a - b) 후보
- answer: 최종적으로 찾고자 하는 (a - b) * c 의 최댓값을 계속 갱신합니다.
- 배열을 순회하면서
  + answer = max(answer, dmax * num) → 지금까지 구한 (a - b) 최대값과 현재 값 c = num을 곱해서 (a - b) * c 값을 계산해보고, answer를 갱신합니다.
  + dmax = max(dmax, imax - num) → 현재 수를 b라고 생각하고, 이전까지 봤던 가장 큰 수 imax를 a라고 보면, (a - b) 값이 나옵니다. → 이걸 이용해서 dmax를 갱신합니다.
  + imax = max(imax, num) → 현재 값을 기준으로, 지금까지 본 수 중 가장 큰 값을 계속 갱신합니다.
- 이렇게 구한 answer를 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n) (3 <= n <= 100)

### ```EASY```

