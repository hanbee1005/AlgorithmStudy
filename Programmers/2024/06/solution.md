# 문제 풀이

### level 3. 외벽 점검
- 전체 외벽의 크기 n, 점검해야하는 위치 배열 weak, 동료가 움직일 수 있는 거리 배열 dist 가 주어졌을 때 모든 점검 위치를 다 채크하기 위해 필요한 최소 동료 수를 구하는 문제
- 동료들은 시계 방향과 반시계 방향 모두 이동할 수 있는데 이는 사실 중요하지 않습니다. 어느 방향이든 취약점부터 시작하게 되면 최대의 점검 효율을 낼 수 있기 때문입니다.
- 따라서 한 방향으로 쭉 간다고 생각하고 확장 배열을 만들어줍니다. 즉, 1, 5, 6, 10 뒤에 각 위치에 12(n)을 더한 13, 17, 18, 22를 붙여 어떤 취약점 위치에서 시작해도 전체를 다 확인할 수 있게 해줍니다.
- 이후 시작 위치를 바꾸면서 dfs 방식으로 친구들을 모두 위치시킵니다.
- 친구들을 위치시키는 모든 경우의 수를 구한 뒤, 이때 벽을 점검할 수 있는 친구의 수를 구해 최솟값을 갱신해줍니다.
- 친구를 확인하는 방법은 다음과 같습니다.
  + (첫 취약점 위치 + 친구가 이동할 수 있는 거리)를 pos 로 지정하고
  + 취약점 시작 위치부터 마지막 위치까지 반복하면서
  + pos가 점검해야하는 위치보다 작으면 추가로 더 친구가 필요하므로 친구 수를 증가 시키고
  + 증가된 친구의 수가 전체 친구의 수보다 크다면 점검이 불가한 것으로 판단해 확인을 종료하고 MAX 값을 반환합니다.
  + 그렇지 않은 경우 pos를 이동한 위치의 취약점 + 다음 친구의 위치로 이동시키고 위 과정을 반복한 뒤, 끝지점까지 확인했을 때 친구 수를 반환합니다.
- 이렇게 모든 경우를 확인한 뒤 최소 친구 수를 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(m^2 * n!) (m <= 15, n <= 8)

### level 3. 110 옮기기
- 1과 0으로 이루어진 문자열 배열이 주어졌을 때 각 110 단위로 움직여서 각 문자를 사전순으로 오름차순 정렬한 배열을 반환하는 문제
- 각 문자를 반복하면서 110 인 구간을 찾고 아닌 문자는 모두 붙입니다.
- 110을 제외한 문자열 중 0을 포함하고 있지 않다면 찾은 110을 모두 맨 앞에 붙이고
- 0이 존재하는 경우 마지막 0을 찾아 그 다음에 110을 붙여주면 사전순으로 오름차순 정렬이 됩니다.
- 이렇게 모든 문자를 확인한 뒤 그 결과 배열을 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(N * M) (N, M <= 1000000)

### level 3. 표현 가능한 이진 트리
- 숫자 배열이 주어졌을 때 이진 수로 나타낸 뒤 해당 이진수를 이진트리로 만들 수 있는 경우 1, 없는 경우 0을 반환하는 문제
- 주어진 숫자를 이진수로 만들어 StringBuilder에 저장하고
- 이진수의 길이가 1이라면 변경된 숫자를 그대로 반환 값으로 저장하고 다음 숫자를 확인합니다.
- 이진 수로 만든 뒤, 완전 이진 트리를 만들기 위해 크기를 계산하여 앞에 0을 채워줍니다.
- 그런 뒤 분할 정복을 통해 반으로 크기를 나눠가면서 비교하면 되는데
- 주어진 이진수가 1을 포함하고 있지 않다면 모두 더미노드로 이루어진 경우로 이진트리를 만들 수 있다고 가정해 true를 반환하고
- 이진수의 길이가 3인 경우는 가운데 수가 0인지 확인하여 0이라면 이진 트리를 만들지 못하므로 false, 그렇지 않다면 true를 반환합니다.
- 그 외 경우에는 중간 수를 구해서 중간 수가 0이면 false를 아닌 경우 양쪽을 나눠서 양쪽 모두 이진 트리를 만들 수 있는 경우에만 true를 반환하도록 재귀 메서드를 구성합니다.
- 이후 이렇게 구한 값들을 배열로 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(N * (logM)^2) (N <= 10000, M <= 10^15)

### level 3. 스타 수열
- 수열이 주어졌을 때 스타 수열의 최대 길이를 구하는 문제
- 먼저 수열에 포함될 수 있는 수의 개수를 구합니다. 주어진 수열을 돌면서 수열의 각 수의 개수를 구합니다.
- 그런 다음 각 수열의 수의 개수를 확인하면서 만약 현재 수의 개수가 스타 수열의 길이보다 작거나 같은 경우는 다음으로 넘어갑니다.
- 현재 수(i)가 나온 횟수가 스타 수열의 최대 길이보다 큰 경우에는 기존 수열을 확인하면서 현재 수(j)와 뒤의 수(j+1)가 서로 같지 않고 현재 수(j) 또는 뒤의 수(j+1)가 현재 수(i)와 같은 경우 i가 수열에 포함될 수 있는 개수를 증가시킵니다.
- 이렇게 수열을 끝까지 확인한 뒤, 수열의 최대 길이와 현재 수(i)가 수열에 포함될 개수 중 더 큰 수를 수열의 최대 길이로 저장합니다.
- 최종적으로 수열의 최대 길이는 어떤 수가 수열에 포함된 개수였기 때문에 2를 곱해 최종 길이를 반환하여 문제를 해결할 수 있습니다.
- 해당 문제는 별도 풀이를 참고하였습니다. (https://cvillain.tistory.com/18) 
- 시간 복잡도: O(N^2) (N <= 500000)

### level 3. N으로 표현하기
- 숫자 N을 가지고 사칙 연산을 통해 number를 만들 때 사용하는 N의 최소 개수를 구하는 문제
- dp 를 사용하여 해결할 수 있는 문제입니다.
- 먼저 N과 number가 같다면 N 1개를 통해 number를 구할 수 있기 때문에 바로 1을 반환합니다.
- N을 i개 사용해서 만들 수 있는 수들을 중복되지 않게 list에 저장하고 x개를 사용해서 만들 수 있는 수는 (N을 j개 사용해서 만들 수)와 (N을 i-j개 사용해서 만든 수)를 사칙연산 해서 나오는 수를 저장해두는 방식으로 문제를 해결하는 방식입니다.
- 먼저 N 1개를 가지고 만들 수 있는 수는 N 뿐이므로 해당 수를 추가한 뒤
- 2개부터 8개까지 사용해서 만들 수 있는 수를 사칙 연산을 통해 구한 다음
- 현재 개수를 통해 구한 수 중에 number가 포함되어 있다면 해당 개수를 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(4^N) (N <= 8)

### level 3. 등산 코스 정하기
- 총 노드의 수 n, 노드들의 연결 정보, 시작점, 정상이 배열로 주어졌을 때 가장 낮은 intensity를 가지고 정상에 다녀올 수 있는 경우를 구하는 문제
- 간선의 가중치가 낮은순으로 먼저 살피며 BFS를 순회하면 됩니다.
- BFS에서의 방문지점 체크를 간선의 가중치(intensity)로 기록해두고 탐색을 하며 산봉우리에 도착을 했는지를 확인하면 됩니다.
- 이때 산봉우리에 도착했다고 바로 종료하면 안되고 같은 가중치를 가진 다른 봉우리도 끝까지 탐색해야 합니다.
- 먼저 출발지와 도착지를 각각 HashSet으로 중복없이 저장하고
- 출발이나 도착에 포함되지 않은 노드들의 연결 정보를 List에 List 형태로 저장합니다.
- 그런 다음 탐색을 시작하면 되는데 먼저 시작점에 연결된 모든 노드들을 Queue에 저장합니다.
- 그리고 큐에서 노드들을 하나씩 꺼내 현재 노드의 가중치가 최대 가중치보다 작은 경우 현재 노드의 도착점의 가중치를 현재 노드의 가중치로 저장한 뒤
- 현재 노드의 도착점이 정상 set에 포함되어 있다면 각 노드의 가중치를 확인하여 가중치의 최대값을 구하고 정상의 위치와 가중치를 갱신합니다.
- 그리고 현재 노드의 다음 위치와 연결된 노드들을 확인하면서 아직 해당 지점을 방문하지 않았다면 큐에 저장합니다.
- 이런 방식으로 모든 연결된 노드들을 확인한 뒤, 정상 위치와 최소 intensity를 배열 형태로 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(N + ElogE) (N <= 50000, E <= 200000)
- 참고: https://velog.io/@hyeokkr/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4%EB%93%B1%EC%82%B0%EC%BD%94%EC%8A%A4-%EC%A0%95%ED%95%98%EA%B8%B0-with-Java

### level 3. 선입 선출 스케줄링
- 전체 작업의 개수와 한 코어가 작업을 처리하는데 걸리는 시간이 배열로 주어졌을 때 마지막 작업을 처리하는 코어의 번호를 반환하는 문제
- 이 문제는 우선 순위 큐를 도입하여 해결하려고 했지만 시간 초과로 인해 다른 풀이를 참고하여 해결하였습니다.
- 작업 시간을 기준으로 이분 탐색을 진행하면서 기준 시간 동안 처리할 수 있는 작업의 수를 구해 n이랑 같거나 더 크다면 high를 mid - 1로 옮겨 더 적은 시간 안에 처리가 가능한지 확인하고 그렇지 않다면 low를 mid + 1로 옮겨 확인합니다.
- 이렇게 확인한 뒤, 작업이 모두 처리되는 최소 시간을 구하고 n번째 작업을 수행할 core를 찾아줍니다.
- core의 index를 찾기 위해서는 최소 시간에 처리되는 작업의 양에서 먼저 n개를 제거하고 코어의 마지막부터 하나씩 줄여가면서 해당 시간에 처리를 할 수 있는 코어이고 작업의 수가 0이라면 해당 작업의 index를 반환하고 아닌 경우 작업 하나를 처리한 것으로 하고 계속 반복합니다.
- 시간 복잡도: O(MLogT) (M <= 10,000, T <= 10000 * 50000)
- 참고: https://stritegdc.tistory.com/312

### level 3. 블록 이동하기 
- board 판의 정보가 배열로 주어졌을 때 로봇을 종료 지점까지 옮기는 최소 시간을 구하는 문제
- 문제를 확인했을 때 BFS로 최단 거리를 구해야겠다고 생각했지만 고려할 사항들이 많았습니다.
- 이 문제의 경우 위치를 나타내는 Point 객체를 만들어 (r, c) 좌표를 가질 수 있게 하였고 로봇을 만들어 로봇의 현재 위치 2개와 지금까지 시간, 방향을 가질 수 있도록 하였습니다.
- 그런 다음 초기 로봇을 생성하여 큐에 넣고 하나씩 꺼냅니다.
- 꺼냈을 때 두 점 중 하나라도 board를 벗어난 경우 continue
- 두 점 중 하나라도 해당 위치가 1이면 벽이므로 continue
- 두 점 중 하나라도 해당 점을 해당 방향에서 방문했던 경우 continue
- 그리고 두 점 중 하나하고 종료 지점에 도달한 경우는 해당 로봇이 가진 시간을 바로 return 합니다.
- 그리고 현재 로봇의 두 점의 위치를 현재 방향으로 방문한 것으로 처리하고
- 두 점 모두를 같이 상하좌우로 이동시키면서 큐에 저장합니다.
- 이후 조건에 맞게 회전을 시키는데 현재 로봇의 방향이 수직인지 수평인지에 따라 구분해서 구합니다.
- 현재 방향이 수직인 경우 좌우 2칸을 확인하게 됩니다. 좌측부터 두 위치 모두 0이어야 회전이 가능하기 때문에 왼쪽칸이 board 안에 있으면서 로봇의 두 위치의 왼쪽칸이 모두 0이면 이동 가능한 것으로 판단해 두 위치 모두 로봇을 만들어 큐에 넣습니다.
- 위와 같은 방식으로 수직인 경우 좌우 2칸, 수평인 경우 상하 2칸을 확인해여 큐에 저장합니다.
- 이렇게 큐의 모든 위치를 확인하면서 끝 점에 도달할 때 시간을 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(N ^ 2) (N <= 100)

### level 3. 



