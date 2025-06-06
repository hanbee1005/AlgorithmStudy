# 문제 풀이

### 3342. Find Minimum Time to Reach Last Room II ```MEDIUM```
- n x m 배열이 주어졌을 때, (n-1, m-1) 까지 도달하는데 걸리는 최소 시간을 구하는 문제
- 상하좌우 4방향을 나타내는 DIRS 변수를 생성합니다.
- 우선 순위 큐를 다음과 같은 형태로 생성 후 초기화 합니다.
  + heap: 우선순위 큐 (min-heap), (flattened index, time, parity) 형태.
  + 초기에는 (0,0)에서 시간 0, 홀수 타이밍(1)으로 시작합니다.
- `moveTime[rr][cc] = -1;`
  + 방문 체크를 위해 -1로 마킹합니다. 방문한 셀은 다시 처리하지 않습니다 (visited set 대용).
- `int newTime = Math.max(time, moveTime[rr][cc]) + odd;`
  + 현재 시간 또는 목적지 셀의 제한 시간 중 큰 값을 고려하고, 홀짝 조정 시간(odd)을 더합니다.
  + odd 값은 1과 2를 번갈아가며 적용됩니다. 이동 시 한 번은 1, 다음은 2를 번갈아 쓰는 구조입니다.
- 전체적인 흐름을 보면 다음과 같습니다.
  + 시작점(0,0)을 큐에 삽입
  + 큐에서 가장 이른 도달 가능한 노드를 꺼냄
  + 인접한 방향을 순회
  + 아직 방문하지 않은 노드라면:
    - 도달 가능 시간(newTime)을 계산
    - 목적지라면 newTime 반환
    - 아니라면 큐에 삽입하고 해당 노드를 -1로 마킹
- 시간 복잡도: O(mn * log(mn)) (n,m <= 750)

### 2094. Finding 3-Digit Even Numbers ```EASY```
- 주어진 digits 배열에서 3개의 수를 뽑아 중복되지 않는 3자리 짝수를 만들어 오름차순으로 정렬해 반환하는 문제
- 먼저 주어진 digits에서 각 숫자별로 몇개가 나왔는지를 계산해 count 배열에 저장해둡니다.
- 그리고 3중 for 문을 돌면서 처음 for 문은 1부터 9까지 돌면서 해당 숫자의 count 가 0이 아닌 경우 하나를 감소시키고 다음 for 문을 확인합니다. 
- 2번째 for 문은 0부터 9까지 돌면서 동일하게 해당 숫자의 count가 0이 아닌 경우 하나를 감소기키고 마지막 for 문을 확인합니다.
- 마지막 for 문에서는 0부터 9까지 2씩 증가시키면서 해당 숫자의 count가 0이 아닌 경우 `i * 100 + j * 10 + k`로 숫자를 구해 저장한 뒤, for 문을 빠져나오면서 앞서 감소시킨 숫자들의 count를 다시 원복시킵니다.
- 최종적으로 구한 숫자 배열을 값이 있는 경우만 잘라서 반환하면 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n^3) (n <= 10)

### 2900. Longest Unequal Adjacent Groups Subsequence I ```EASY```
- 문자 배열과 0,1 로 이루어진 정수 배열이 주어졌을 때, 정수 배열에서 앞뒤로 겹치지 않는 최대 길이의 배열에 해당 인덱스에 해당하는 문자 배열을 반환하는 문제
- 먼저 문자의 제일 처음 값을 정답 리스트에 추가합니다.
- 이후 index 1부터 정수배열을 돌면서 해당 인덱스와 이전 인덱스를 비교해서 다르면 해당 인덱스의 문자를 정답 배열에 추가합니다.
  + 0과 1로만 이루어져 있기 때문에 이전 값과 비교해서 같다면 이전 값도 정답에 포함되지 않았다고 확신할 수 있고 정답에 포함된 마지막 인덱스는 현재 인덱스의 값이랑도 같음이 보장됩니다.
  + 또한 이전 값이 현재랑 다르다면 이전 값이 정답에 포함되었든 아니든 정답에 포함된 마지막 수는 현재랑 다를 것이기 때문에 현재값을 바로 정답 배열에 추가해도 됩니다.
- 이후 정답 배열을 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O()

### 3024. Type of Triangle ```EASY```
- 3개의 정수가 주어졌을 때 3변이 모두 같으면 "equilateral", 2변이 같고 삼각형을 만들 수 있으면 "isosceles", 3변이 모두 다른 삼각형을 만들 수 있으면 "scalene", 삼각형을 만들 수 없으면 "none"을 반환하는 문제
- 3변이 같은 경우 바로 "equilateral"를 반환합니다.
- 2변이 같고 같은 두 변의 길이의 합이 남은 한 변의 길이보다 긴 경우 "isosceles"를 반환합니다.
- 마지막으로 아무 2변의 길이의 합이 남은 한 변의 길이보다 긴 경우 "scalene"를 반환하고 위 경우에 해당하지 않는다면 "none"을 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(1)

### 73. Set Matrix Zeroes ```MEDIUM```
- 2차원 행렬 matrix에서 0이 하나라도 존재하는 행(row)과 열(column)을 통째로 0으로 바꾸는 문제
- 초기 변수 지정
  + n, m : 행렬의 행 개수와 열 개수
  +  col0 : 첫 번째 열을 모두 0으로 바꿀지 여부를 저장하는 플래그 (초기값 1, 0이면 나중에 첫 번째 열 전체를 0으로 설정)
- 첫 행·첫 열을 마커로 설정
  + 전체 matrix를 순회하면서 0을 발견하면
  + 그 행(i)의 첫 열(matrix[i][0])을 0으로 표시
  + 그 열(j)의 첫 행(matrix[0][j])을 0으로 표시
  + 만약 0이 첫 열에 있다면 col0 = 0으로 표시
- 첫 행과 첫 열을 제외한 모든 칸에 대해
  + 같은 행의 첫 칸 혹은 같은 열의 첫 칸이 0이면
  + 해당 칸도 0으로 설정
- 첫 번째 행 전체 0 처리
  + matrix[0][0]이 0이라면, 첫 행 전체를 0으로
- 첫 번째 열 전체 0 처리
  + col0 플래그가 0이라면, 첫 열 전체를 0으로
- 시간 복잡도: O(n * m) (n,m <= 200)

### 3362. Zero Array Transformation III ```MEDIUM```
- queries는 [l, r] 형태이며, nums[l] ~ nums[r] 범위에서 각 인덱스 값을 1씩 줄일 수 있는 연산으로 nums[i]의 각 요소는 일정한 횟수만큼 줄여서 0으로 만들면서, 사용하지 않고 남겨둘 수 있는 쿼리의 개수를 최대로 만드는 문제
- 쿼리 정렬
  + 쿼리를 시작 인덱스(l) 기준으로 오름차순 정렬합니다. 인덱스별로 빠르게 쿼리를 적용하기 위함입니다.
- 변화량 추적용 배열 delta
  + 차이 배열(difference array)입니다.
  + delta[i]++와 delta[r + 1]--를 통해 구간 [i, r]에 +1 적용.
- 우선순위 큐 활용 (끝 위치가 큰 쿼리를 우선 적용)
  + 현재 인덱스 i에서 적용 가능한 모든 쿼리 중, 끝 범위가 가장 넓은 쿼리를 우선 사용합니다.
  + 이유는 뒤에 더 많은 인덱스를 커버할 수 있으므로 더 유리하기 때문입니다.
- 메인 루프
  + 현재 위치 i에서:
    - 누적 감소값 delta[i]를 계산합니다.
    - 실제 남은 값 v = nums[i] - delta[i].
    - queries[j][0] == i인 모든 쿼리를 pq에 추가합니다.
    - v > 0이면 pq에서 쿼리를 꺼내며 delta를 수정해 해당 범위 감소를 반영합니다.
- 종료 조건
  + pq가 비어있는데도 v > 0이라면 더 이상 줄일 수 없으므로 -1 리턴.
  + 최종적으로 pq에 남은 쿼리 수가 사용하지 않은 쿼리 수이며, 그 수를 반환.
- 시간 복잡도: O(m log m + N log m) (m <= 100000, N = sum(nums))

### 2942. Find Words Containing Character ```EASY```
- 문자열 배열 words 와 x 문자가 주어졌을 때, words 에서 x 를 포함한 문자열의 인덱스를 찾아 리스트로 반환하는 문제
- words 를 돌면서 하나의 word 에서 x 문자의 인덱스가 0 이상인 경우 문자열이 포함된 것으로 판단해 정답 list에 추가하고
- 모든 문자를 이렇게 확인한 뒤 해당 리스트를 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n) (n <= 50)

### 2894. Divisible and Non-divisible Sums Difference ```EASY```
- 정수 n과 m 이 주어졌을 때 1부터 n 사이의 수 중 m 으로 나누어 떨어지지 않는 수들의 합과 m 으로 나누어 떨어지는 수들의 합의 차이를 구하는 문제
- 1부터 n까지 돌면서 m으로 나누어지지 않는 수라면 num1에 합하고 나누어 떨어지면 num2에 더한 뒤 결과적으로 num1 - num2 를 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n) (n <= 1000)

### 1920. Build Array from Permutation ```EASY```
- 정수 배열이 주어졌을 때, nums[nums[i]] 의 배열을 반환하는 문제
- nums 길이의 배열 answer 을 만들고 nums 를 돌면서 nums[nums[i]]를 answer[i] 에 저장한 뒤 최종적으로 answer 을 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n) (n <= 1000)

### ```EASY```
