# 문제 풀이

### 1122. Relative Sort Array ```EASY```
- 최대 나올 수 있는 수가 1000이므로 1001 크기의 배열을 만든 뒤
- 첫번째 배열을 돌면서 해당 수를 인덱스로 한 위치의 값을 증가시켜 해당 수가 몇개 나오는지 구합니다.
- 그런 다음 두번째 배열을 돌면서 수를 뽑아 그 수의 개수가 0보다 크다면 그 개수만큼 반복하면서 정답 배열을 채워줍니다.
- 이후 다시 수의 개수가 담긴 배열을 반복하면서 두번째 배열에는 없었지만 첫번째 배열에 존재했던 수들을 찾아 그 개수만큼 정답 배열을 채워주고 최종적으로 정답 배열을 반환합니다.
- 배열을 여러번 돌기는 하지만 최대가 1001이기 때문에 시간이 오래 걸리는 작업은 아닙니다.
- 시간 복잡도: O(N) (N <= 1001)

### 1207. Unique Number Of Occurrences ```EASY```
- 배열을 확인하면서 해당 숫자가 나온 횟수가 유일한 경우 true, 그렇지 않다면 false를 반환하는 문제
- 숫자가 음수인 경우도 존재하기 떄문에 먼저 나올 수 있는 수의 범위의 2배만큼 배열을 생성한 뒤 양수인 경우 해당 숫자의 위치를, 음수인 경우 -1을 곱하고 1000을 더한 위치의 값을 증가시켜서 나온 횟수를 구합니다.
- 그런 다음 해당 인덱스에 담긴 숫자에 해당하는 값이 나온 적이 있는지 확인하기 위해 boolean 타입의 배열을 생성하고 숫자를 확인하면서 0이 아니면서 이미 나온적이 있다면 false 를 그대로 반환하고 아닌 경우 해당 횟수의 인덱스를 true 바꾼 뒤 전체 인덱스를 확인합니다.
- 이 방법 대신 arr 배열의 크기만큼 다시 인덱스를 구해서 확인하면 더 시간을 줄일 수 있습니다.
- 시간 복잡도: O(N) (N <= 2001)

### 2037. Minimum Number Of Moves To Seat Everyone ```EASY```
- 두 배열이 주어졌을 때 첫번째 배열에 맞게 두번째 배열의 모든 값을 이동시키는 최소 이동 거리를 구하는 문제
- 두 배열에서 겹치는 숫자는 이동할 필요가 없기 때문에 겹치는 숫자를 확인하여 해당 위치의 값을 0으로 변환한 뒤
- 두 배열을 정렬하고 처음부터 확인하면서 두 배열을 같은 위치의 값의 차를 구해 모두 합하여 반환하면 문제를 해결할 수 있습니다.
- 다른 방식으로 속도를 더 개선할 수 있는데
  + 먼저 두 배열을 확인하여 위치의 최대값을 찾아 해당 크기만큼의 different 배열을 생성합니다.
  + 그리고 seats 배열을 돌면서 각 seat에 해당하는 위치의 값을 증가시키고
  + students 배열을 돌면서 각 student에 해당하는 위치의 값을 감소시킵니다.
  + different 배열을 돌면서 맞지 않는 수의 절댓값을 정답에 이동 횟수에 추가하고 맞지 않는 수는 different 값을 추가합니다.
  + 이렇게 함으로써 최소 이동거리를 구할 수 있고 이를 반환하여 문제를 효율적으로 해결할 수 있습니다.
- 시간 복잡도: O(N^2) (N <= 100)

### 645. Set Mismatch ```EASY```
- 배열이 주어졌을 때 배열의 크기만큼 1부터 n개의 수가 하나씩 들어있는데 그중 중복된 하나의 수와 나오지 않은 하나의 수를 찾아 리턴하는 문제
- 주어진 배열에서 숫자를 꺼내 해당 숫자 인덱스의 값을 증가시켜 몇번 나왔는지 확인합니다.
- 이후 해당 배열을 돌면서 2번 나온 경우 answer[0]에, 0번 나온 경우 answer[1]에 추가한 뒤 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n) (n <= 10^4)

### 169. Majority Element ```EASY```
- n 크기의 배열이 주어졌을 때, n/2번 이상 나온 수를 구하는 문제
- 이 문제는 해당 숫자들을 오름차순으로 정렬한 뒤 [n/2] 인덱스의 수를 구하면 해결되는 문제입니다.
- 시간 복잡도: O(1) (Arrays.sort 시간 제외)

### 1482. Minimum Number of Days to Make m Bouquets ```MEDIUM```
- 각 꽃 별로 며칠이 지나야 꽃이 피는지와 몇 개의 부케를 몇개의 연속된 꽃으로 만들지가 주어졌을 때, 가장 적은 일수를 구하는 문제
- 만약 꽃의 수보다 부케를 만들 때 필요한 꽃의 수가 더 큰 경우 -1을 반환합니다.
  + 이때 m * k 는 int의 범위를 넘어설 수 있어 long으로 전환하여 계산합니다.
- 개화 시기 최대, 최소 일수를 먼저 구한 다음 이분 탐색으로 일수를 계산합니다.
- 최소값이 최대값보다 작거나 같을 동안 중간 일수를 구해 해당 중간 일수가 지났을 때 개화한 꽃을 모아 부케를 만들 수 있다면 더 작은 일수로 구할 수 있는지 확인해야 하기 때문에 max = mid - 1 값으로 갱신합니다.
- 중간 일수가 지났을 때 개화한 꽃을 모아 부케를 만들 수 없다면 일수가 더 지나야하기 때문에 min = mid + 1 값으로 갱신합니다.
- 중간 일수가 지났을 때 개화한 꽃을 모아 부케를 만들 수 있는지 없는지 판단하는 과정은 다음과 같습니다.
  + 꽃이 개화하는 시기를 담은 배열을 순회하면서 해당 일수보다 꽃이 개화하는 일수가 작거나 같다면 개화한 꽃의 개수를 증가시키고 개화한 꽃의 개수가 연달아 필요한 꽃의 개수와 같은 경우 만든 부케의 개수를 증가시키고 개화한 꽃의 개수를 0으로 초기화 합니다.
  + 만약 해당 일수보다 꽃이 개화하는 일수가 크다면 아직 꽃이 피지 않았기 때문에 연달아 개화한 꽃의 개수를 0으로 초기화 합니다.
  + 마지막으로 부케의 개수가 만들어야하는 수보다 크거나 같은 경우 true를 반환하고 아닌 경우 모든 꽃의 개화 시키를 확인한 뒤, false를 반환합니다.
- 이렇게 이분 분할 탐색으로 계산한 일수 중 min 값을 찾아 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(NLog(max-min)) (1 <= min <= max <= 10^9)

### 1552. Magnetic Force Between Two Balls ```MEDIUM```
- 바구니의 위치가 들어있는 배열과 공의 수가 주어졌을 때 공들의 간격이 가장 작을 수 있는 값들 중 가장 큰 경우를 구하는 문제
- 이 문제 또한 거리를 기준으로 공 사이의 거리가 mid 일 때 공을 놓을 수 있으면 더 넓은 거리에도 넣을 수 있기 때문에 low를 mid + 1 갱신하고 놓을 수 없으면 high를 mid - 1로 설정하여 이분 탐색을 진행하면 됩니다.
- 최종적으로는 작은 거리 중 최대를 구하는 것이기 때문에 high 값을 반환하여 문제를 해결할 수 있습니다.
- 공을 해당 mid 거리만큼 두고 놓을 수 있는지 확인하는 방법은 공을 하나씩 돌면서 마지막 공을 둔 위치와 현재 위치 사이의 거리가 mid 보다 큰 경우 공을 둔 것으로 간주하여 둔 공의 수를 증가 시키고 마지막 위치를 현재 위치로 갱신시켜 모든 바구니 위치를 확인한 뒤, 놓은 공의 수가 m 보다 크거나 같으면 해당 mid 거리를 두고 공을 놓을 수 있는 것으로 간주합니다.
- 시간 복잡도: O(NLog(max-min)) (1 <= min <= max <= 10^9)

### 1052. Grumpy Bookstore Owner ```MEDIUM```
- 손님이 들어와서 나가는 시간이 담기 배열과 주인이 짜증내는 시간이 담긴 배열이 있고 짜증내지 않는 지속 시간이 주어졌을 때 가장 많은 손님이 만족하는 시간을 구하는 문제
- 이 문제는 우선 주인이 짜증내는 시간 딱 그 당시에 들어온 손님만 불만족한다는 것이다. 손님이 들어와 있는 중간에 짜증을 내는 것은 타격 x
- 이 문제는 윈도우 탐색으로 하나씩 이동하면서 확인할 수 있는데
- 먼저 하나씩 확인하면서 짜증이 났을 때 들어온 손님의 시간을 더합니다. 그리고 최대 불만족도와 비교하여 최대 불만족도를 계산합니다. 
- 그리고 나서 짜증을 내지 않는 시간을 지나면 이전에 짜증낼 때 들어왔던 고객의 시간을 현재 시간에서 빼줍니다.
- 이렇게 윈도우 안에 있는 불만족한 사람의 최대 시간을 구하면 해당 사람들은 사실 짜증을 받지 않은 만족한 사람들이 되기 때문에 이렇게 구한 다음
- 다시 처음부터 돌면서 처음부터 만족이었던 사람들의 시간을 더해 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(N) (N <= 20000)

### 1791. Find Center of Star Graph ```EASY```
- 배열이 주어졌을 때 모든 노드와 연결된 중앙 노드의 숫자를 구하는 문제
- 이 문제는 1부터 n 개의 노드가 있고 간선의 개수도 n-1 이므로 처음 2개의 배열만 확인해 둘 모두에 포함된 숫자가 답이 됩니다.
- 시간 복잡도: O(1)


