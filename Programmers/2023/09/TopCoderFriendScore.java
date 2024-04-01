package Sep2023;

/**
 * Top Coder FriendScore SRM436 Div 2 Level 1
 */
public class TopCoderFriendScore {
    public static void main(String[] args) {
        System.out.println(highestScore(new String[]{"NNN", "NNN", "NNN"}));
        System.out.println(highestScore(new String[]{"NYY", "YNY", "YYN"}));
        System.out.println(highestScore(new String[]{"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"}));
    }

    private static int highestScore(String[] friends) {
        int answer = 0;

        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;

            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;  // 자기 자신은 패스

                if (friends[i].charAt(j) == 'Y') {  // i와 j가 친구인 경우
                    cnt++;
                } else {
                    for (int k = 0; k < friends.length; k++) {
                        // i와 j의 공통 친구인 k가 있는 경우
                        if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
                            cnt++;
                            break;
                        }
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
