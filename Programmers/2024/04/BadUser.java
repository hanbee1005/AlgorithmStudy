package Apr2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Level 3. 불량 사용자
 */
public class BadUser {
    private static List<Set<String>> bannedIds = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        bannedIds = new ArrayList<>();
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        bannedIds = new ArrayList<>();
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    private static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        List<List<String>> banned = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            String bannedId = banned_id[i];
            banned.add(i, new ArrayList<>());
            for (String userId : user_id) {
                if (isBanned(bannedId, userId)) {
                    banned.get(i).add(userId);
                }
            }
        }

        answer = findBannedList(banned, banned_id.length, 0, new HashSet<>());

        return answer;
    }

    private static boolean isBanned(String bannedId, String userId) {
        if (bannedId.length() != userId.length()) return false;
        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) == '*') continue;
            if (bannedId.charAt(i) != userId.charAt(i)) return false;
        }

        return true;
    }

    private static int findBannedList(List<List<String>> bannedId, int total, int cnt, Set<String> selectedId) {
        if (total == cnt) {
            if (bannedIds.contains(selectedId)) {
                return 0;
            } else {
                bannedIds.add(new HashSet<>(selectedId));
                return 1;
            }
        }

        int answer = 0;
        List<String> cur = bannedId.get(cnt);
        for (int i = 0; i < cur.size(); i++) {
            if (!selectedId.contains(cur.get(i))) {
                selectedId.add(cur.get(i));
                answer += findBannedList(bannedId, total, cnt + 1, selectedId);
                selectedId.remove(cur.get(i));
            }
        }

        return answer;
    }

    /** 다른 풀이
     * Set<Integer> set;
     *
     * public int solution(String[] user_id, String[] banned_id) {
     *       set = new HashSet<>();
     *
     *       go(0, user_id, banned_id, 0);
     *
     *       return set.size();
     * }
     *
     * public void go(int index, String[] user_id, String[] banned_id, int bit) {
     *
     *       if(index == banned_id.length) {
     *           set.add(bit);
     *           return;
     *       }
     *
     *       String reg = banned_id[index].replace("*", "[\\w\\d]");
     *       for(int i=0; i<user_id.length; ++i) {
     *           if((((bit>>i) & 1) == 1) || !user_id[i].matches(reg)) continue;
     *           go(index + 1, user_id, banned_id, (bit | 1<<i));
     *       }
     * }
     */
}
