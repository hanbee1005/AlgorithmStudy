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

### 49. Group Anagrams
String 배열이 주어지는 경우 문자열을 이루는 char가 모두 같은 문자열끼리 묶인 리스트를 반환하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/GroupAnagrams_49.java)
- 먼저 주어진 문자열 배열의 길이가 0인 경우는 빈 리스트를 반환하도록 하였습니다.
- 그렇지 않은 경우 문자열 하나씩 반복하면서 
- 문자열을 이루는 문자를 정렬하여 새로운 key로 만들고
- Map에서 해당 key를 가지고 있지 않은 경우 해당 key와 새로운 리스트를 값으로 저장하고
- key에 해당하는 리스트에 원래 문자열을 저장합니다.
- 최종적으로 Map 저장된 값들을 리스트로 만들어 반환합니다.
- 문자열의 각 문자를 돌면서 확인할 필요없이 문자를 정렬하여 key로 사용함으로써 Map을 사용해 문제를 해결할 수 있었습니다.

### 349. Intersection of Two Arrays
두 정수 배열이 주어졌을 때 교집합인 수를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/IntersectionOfTwoArrays_349.java)
- 먼저 nums1 배열의 각 수를 key로 하고 값은 false로 하여 Map에 저장합니다.
- 이후 nums2 배열을 돌면서 Map이 해당 수를 key로 가지고 있다면 값을 true로 변경합니다.
- 최종적으로 Map에서 값이 true인 key만 찾아서 배열로 반환합니다.

### 929. Unique Email Addresses
이메일 문자열 배열이 주어지는 경우 중복을 제거한 유효한 이메일 개수를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/UniqueEmailAddresses_929.java)
- 이메일 목록을 순회하면서 유효성 검사를 하고(local name에 해당하는 부분에서 .을 제거하고 첫번째 등장하는 + 뒤는 무시하는 작업)
- 해당 이메일을 key로 하여 Map에 해당 key가 없으면 저장하고 있는 경우는 무시합니다.
- Set에 저장하고 Set의 size를 반환해도 됐을 것 같다는 생각듭니다.

### 387. First Unique Character in a String
문자열이 주어질 경우 문자열을 이루는 문자 중 중복이 없는 가장 빠른 문자의 인덱스를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/FirstUniqueCharacterInAString_387.java)
- 문자열을 순회하면서 각 문자가 Map에 포함되어 있는지 확인하고 Map의 key로 존재하는 경우 값을 증가시켰습니다.
- 최종적으로 Map을 돌면서 값이 0인(한번 나온 경우 0으로 설정하였습니다.) key를 구하였고 이 key가 '0'인 경우 중복이 없는 문자가 없는 것으로 간주하여 -1, key가 일반 알파벳인 경우 문자열에서 해당 문자의 인덱스를 구해 반환하도록 하였습니다.
- 반복되지 않는 문자가 여러개 나올 수 있기 때문에 Map에 저장하는 순서가 중요해서 ```LinkedHashMap```을 사용하였습니다.

### 560. Subarray Sum Equals K
배열이 주어졌을 때 subarray의 합이 K와 같은 subarray 수를 구하는 문제입니다.
[문제풀이코드](https://github.com/hanbee1005/AlgorithmStudy/blob/master/Leetcode/202301/SubarraySumEqualsK_560.java)
- 먼저 배열을 차례로 돌면서 하나씩 확인하는 방법을 사용하였지만 시간 복잡도가 O(n^3)이 나올정도로 좋지 않아서 다음과 같이 hash map을 사용하여 해결하였습니다.
- 두 인덱스까지의 누적합(0부터 현재 인덱스까지 합)이 같으면 두 인덱스 사이에 있는 요소의 합은 0입니다.
- 이 생각을 더 확장하면 두 인덱스(i, j)까지의 누적합의 차가 k이면 두 인덱스 사이에 있는 요소의 합은 k라는 의미입니다. ```sum[i] - sum[j] = k```
- 이러한 생각을 바탕으로 모든 인덱스의 누적 합과 그 합이 나온 갯수를 hashmap을 사용해 저장할 수 있습니다.
- nums 배열을 순회하면서 누적합을 먼저 구합니다. ```sum += nums[i]```
- 누적합을 key로 하여 hashmap에 저장하고 같은 key가 있는 경우 갯수를 하나 증가시킵니다. ```map.put(sum, map.getOrDefault(sum, 0) + 1)```
- 또한, 모든 누적합에 대하여 합이 k인 subarray가 등장한 횟수를 저장하고 있기 때문에 (sum - k)가 등장한 횟수를 알고 있습니다.
- 이를 확인하고 해당 횟수를 count에 그대로 더해줍니다. ```count += map.get(sum - k)``` 
- 최종적으로 count를 반환합니다.