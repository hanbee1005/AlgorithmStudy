# 문제 풀이

### 1455. Check if a Word Occurs as a Prefix of Any Word in a Sentence ```EASY```
- 문자열이 주어졌을 때 빈문자로 나눈 각 단어 중 searchWord로 시작하는 단어가 몇번째 단어인지 구하는 문제 (여러 개인 경우 더 앞에 나온 문자 위치를, 없는 경우 -1 반환)
- 주어진 문자열을 빈문자로 분리하고 앞에서부터 startsWith으로 확인하면서 seatchWord로 시작하는 경우 해당 문자 인덱스 + 1을 반환하고
- 모든 문자를 확인해도 없는 경우 -1을 반환하여 문제를 해결할 수 있습니다.
- 시간 복잡도: O(n)(n <= 50)

### ```EASY```

