# 문제 풀이

### 2022. Convert 1D Array Into 2D Array ```EASY```
- 1차원 배열과 m,n 이 주어졌을 때 m * n 크기의 2차원 배열로 변환하여 반환하는 문제
- 먼저 주어진 1차원 배열과 m * n 이 다르다면 빈 배열을 반환합니다.
- 2차원 배열로 변환이 가능한 경우 m * n 만큼 반복하면서 k 를 하나씩 증가시켜 값을 찾아서 추가한 뒤 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n * m) (n * m <= 5 * 10^4)

### 1894. Find the Student that Will Replace the Chalk ```MEDIUM```
- 학생들이 사용하는 chalk의 수 배열과 전체 chalk의 수가 주어졌을 때 chalk를 다 쓰고 바꿔야 하는 학생의 인덱스를 구하는 문제
- 먼저 전체 학생이 사용할 chalk의 수를 구한 뒤 현재 chalk의 수를 전체 chalk의 수로 나눈 나머지를 구합니다.
- 이후 남아있는 chalk의 수가 현재 index의 학생이 사용하는 chalk의 수보다 작은 경우 현재 인덱스의 학생이 chalk를 다 사용하고 바꿔야 하는 것으로 간주해 해당 학생의 인덱스를 반환합니다.
- 그렇지 않은 경우 남아있는 chalk의 수에서 현재 학생이 사용한 chalk의 수만큼 뺀 뒤 계속 반복합니다.
- 시간 복잡도: O(n) (n <= 100000)

### 1945. Sum of Digits of String After Convert ```EASY```
- 알파벳 소문자로 이루어진 문자열이 주어졌을 때 이 문자열을 숫자로 바꾼 뒤 각 자리의 숫자를 k 번 더해 나오는 수를 구하는 문제
- 먼저 주어진 알파벳 소문자 문자열을 숫자로 변경한 뒤 하나의 문자로 변경합니다.
- k 번 반복하면서 숫자가 변경된 문자를 다시 하나씩 돌면서 합을 구하고 그 숫자를 다시 문자로 변경하여 저장하고 이 과정을 반복합니다.
- 그리고 나온 문자열을 숫자로 변형하여 반환하면 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n * k) (n <= 100, k <= 10)

### 874. Walking Robot Simulation ```MEDIUM```
- 움직일 방향과 이동거리에 대한 배열과 장애물의 위치가 주어졌을 때 로봇이 가장 멀리 이동한 거리를 구하는 문제
- 먼저 장애물 정보를 Set으로 x,y 형태로 저장합니다.
- 그리고 방향에 대해 {상, 우, 하, 좌} 순서대로 배열에 저장한 뒤 처음 인덱스를 0으로 지정합니다.
- 이후 command 를 확인하면서 -2인 경우 원래 인덱스 - 1 (0인 경우 3으로), -1인 경우 원래 인덱스 + 1 (3인 경우 0으로) 하여 방향을 설정합니다.
- 1부터 9 사이의 수가 나온 경우 해당 방향의 위치를 하나씩 확인하면서 장애물 여부를 확인하고 장애물이 없는 경우 갈 수 있는 최대 거리를 구한 뒤 현재 위치에 더해줍니다.
- 이어 현재 위치와 원점 사이 거리를 구한 뒤, max 값을 갱신합니다.
- 이렇게 모든 command 를 확인하고 max 값을 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n) (n <= 10000)

### 241. Different Ways to Add Parentheses ```MEDIUM```
- 숫자와 연산자(+, -, x)로 이루어진 문자열이 주어졌을 때 괄호를 추가하여 나올 수 있는 모든 결과를 리스트로 반환하는 문제
- 이 문제는 연산자를 기준으로 연산자를 만나면 왼쪽과 오른쪽을 나눠서 똑같이 다시 계산하고 왼쪽에서 나온 수들과 오른쪽에서 나온 수들을 모두 연산자에 맞게 계산해준 뒤 반환하여 문제를 해결할 수 있습니다.
- 문자열을 한글자씩 확인하면서 +, -, * 중 하나인 경우 해당 문자를 기준으로 두개의 문자열로 분리한 뒤 
- 각각의 문자열을 다시 재귀함수로 넘기고 각각의 숫자 리스트 반환 값을 돌면서 현재 수식에 맞는 계산을 해 정답 배열에 넣고
- 만약 주어진 문자열을 모두 확인한 뒤 배열이 비어있다면 현재 문자열을 숫자로 변경해 해당 배열에 넣고 반환하는 방식으로 문제를 해결할 수 있습니다.
- 시간 복잡도: O(2^n) (n <= 9)

### 214. Shortest Palindrome ```HARD```
- 문자열이 주어졌을 때 앞에 문자를 붙여 가장 짧은 회문(팰린드롬) 문자를 반환하는 문제
- 이 문제는 주어진 문자열의 앞부분에서 회문의 가장 큰 부분을 찾고 나머지 부분에 대한 문자를 앞에 붙여 주어 해결할 수 있습니다.
- 먼저 문자열을 뒤집어 #을 기준으로 원래 문자열의 앞에 붙인 뒤
- 합쳐진 문자의 길이만큼 배열을 만든 뒤, 처음부터 비교 하면서 처음 원본 문자열에서 가장 긴 접두사의 길이를 구합니다. 이를 통해 추가할 필요가 없는 원본 문자열의 부분을 알 수 있습니다.
- pi[i] 배열은 newString에서 0번부터 i번까지의 문자열에서 가장 긴 접두사와 접미사가 일치하는 길이를 저장합니다. 두 포인터 i와 k를 사용해 문자열을 순회하며 일치하는 접두사와 접미사를 찾습니다.
- i는 현재 탐색 중인 문자열의 위치를 나타내고 k는 일치하는 접두사의 길이를 나타냅니다.
- i번째 문자와 k번째 문자가 일치할 경우: 현재 문자(newString.charAt(i))와 접두사 끝의 문자(newString.charAt(k))가 같으면, 접두사 길이를 하나 증가시키고 (k++), pi[i]에 그 값을 저장합니다.
- 일치하지 않을 경우 k 값을 줄이면서, 이미 일치한 접두사 길이에 따라 비교를 다시 시도합니다.
- 최종적으로 pi[newString.length() - 1] 값을 반환하는데, 이는 patt와 txt에서 일치하는 가장 긴 접미사와 접두사의 길이를 나타냅니다.
- 마지막으로 원본 문자열 앞에 최소한으로 필요한 문자를 붙여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n) (n <= 5 * 10^4)

### 2707. Extra Characters in a String ```MEDIUM```
- 문자열 s와 여러 단어 목록 dictionary가 주어졌을 때 dictonary에 포함된 단어로 s를 나눠서 포함되지 않은 s의 최소 길이를 구하는 문제
- 먼저 dictionary에 포함되는지를 확인하기 위해 Set으로 변경합니다.
- 그리고 dp 배열을 만들어 dp[i]에는 부분 문자열 s[i:]에서 남은 최소한의 문자를 저장하도록 합니다.
- dp 배열을 오른쪽에서부터 채우는데 기본적으로 이전에 남은 최소 문자 + 1을 저장합니다.
- 문자를 하나씩 늘려가면서 사전 Set에 포함이 되어 있는지 확인하고 포함되어 있다면 현재 dp 배열 위치의 값과 끝 문자 위치에 저장된 dp 배열의 값 중 작은 값으로 변경합니다.
- 이는 해당 문자로 나눈 이후에 남아 있는 가장 작은 단어를 나타내기 때문입니다.
- 해당 문제는 Trie 알고리즘으로 더 효율적으로 해결할 수 있다고 합니다.
- ```
  class Node{
      public Node[] child;
      public boolean isEnd;
      public Node(){
          child = new Node[26];
          isEnd = false;
      }
  }

  class Solution {

      public int minExtraChar(String s, String[] dictionary) {
          Node root = new Node();
          for(String str: dictionary){
              insert(str, root);
          }
          int n = s.length();
          int[] dp = new int[n+1];
          for(int i = 0; i < n+1; i++){
              dp[i] = i;
          }
  
          for(int i = 0; i < n; i++){
              search(s, root, i, dp);
              dp[i+1] = Math.min(dp[i+1], dp[i]+1);
          }
          return dp[n];
      }

      public void insert(String s, Node root){
          for(int i = 0; i < s.length(); i++){
              int path = s.charAt(i) - 'a';
              if(root.child[path] == null){
                  Node node = new Node();
                  root.child[path] = node;
              }
              root = root.child[path];
          }
          root.isEnd = true;
      }

      public void search(String s, Node root, int idx, int[] dp){
          for(int i = idx; i < s.length(); i++){
              int path = s.charAt(i) - 'a';
              if(root.child[path] != null){
                  root = root.child[path];
                  if(root.isEnd){
                      dp[i+1] = Math.min(dp[i+1], dp[idx]);
                  }
              } else {
                  return;
              }
          }
      }
  }
  ```
- 시간 복잡도: O(n^2) (n <= 50)

### 3043. Find the Length of the Longest Common Prefix ```MEDIUM```
- 숫자 배열 2개가 주어졌을 때, 각 배열의 숫자를 쌍을 이뤄 두 수의 가장 긴 prefix 길이를 구하는 문제 (일치하는 prefix가 없는 경우 0 반환)
- 먼저 arr1 배열에 있는 숫자를 모두 돌면서 10으로 나눠 몫을 Set 형태로 저장합니다.
- arr2에 있는 숫자를 하나씩 돌며 set에 포함이 되어 있는 경우 해당 수의 길이를 log10(num) + 1 로 찾아 최대값을 구한 뒤 다음 수를 확인하고
- 포함되어 있지 않은 경우는 10으로 나눠 몫을 계속 찾음으로써 prefix를 계속 비교하여 찾습니다.
- 최종적으로 최대 prefix 길이인 answer를 반환하여 문제를 해결할 수 있습니다. 
- 시간 복잡도: O(N * M) (N < 5 * 10^4, M < 10^8)

### 2220. Minimum Bit Flips to Convert Number ```EASY```
- start와 goal 숫자가 주어졌을 때 start의 비트를 변경하여 goal을 만드는 최소 수를 구하는 문제
- 비트를 변경하는 것이기 때문에 start 와 goal 각 위치의 비트가 다른 개수를 구하면 해결할 수 있는 문제입니다.
- XOR 연산을 통해 두 숫자의 각 비트 위치가 서로 다르면 1이 됩니다.
- XOR 값이 0이 될 때까지 가장 오른쪽 비트가 1과 같다면 answer을 증가시키고 아니면 그대로 두는 연산을 합니다.
- 그리고 오른쪽으로 시프트 연산을 사용하여 하나씩 밀면서 1의 개수를 구해 최종적으로 이를 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(1)

### ```EASY```



