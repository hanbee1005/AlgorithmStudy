import java.util.*;

public class RankingSearch {
    private static Map<String, List<Integer>> allInfo;
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(
                        new String[]{
                                "java backend junior pizza 150",
                                "python frontend senior chicken 210",
                                "python frontend senior chicken 150",
                                "cpp backend senior pizza 260",
                                "java backend junior chicken 80",
                                "python backend senior chicken 50"
                        }, new String[]{
                                "java and backend and junior and pizza 100",
                                "python and frontend and senior and chicken 200",
                                "cpp and - and senior and pizza 250",
                                "- and backend and senior and - 150",
                                "- and - and - and chicken 100",
                                "- and - and - and - 150"
                        })
                )
        );
    }

    private static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 1. info의 모든 경우의 map에 저장
        allInfo = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            dfs("", 0, info[i].split(" "));
        }

        // 2. map에 저장된 점수 list 오름차순으로 정렬
        List<String> keys = new ArrayList<>(allInfo.keySet());
        for (int i = 0; i < keys.size(); i++) {
            List<Integer> values = allInfo.get(keys.get(i));
            Collections.sort(values);
        }

        // 3. 이분 탐색
        for (int i = 0; i < query.length; i++) {
            String[] qr = query[i].replaceAll(" and ", "").split(" ");
            int score = Integer.parseInt(qr[1]);

            answer[i] = search(qr[0], score);
        }

        return answer;
    }

    private static void dfs(String pos, int depth, String[] info) {
        if (depth == 4) {
            if (!allInfo.containsKey(pos)) {
                List<Integer> in = new ArrayList<>();
                in.add(Integer.parseInt(info[4]));
                allInfo.put(pos, in);
            } else {
                allInfo.get(pos).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(pos + "-", depth + 1, info);
        dfs(pos + info[depth], depth + 1, info);
    }

    private static int search(String str, int score) {
        if (!allInfo.containsKey(str)) return 0;

        List<Integer> scoreList = allInfo.get(str);
        int start = 0;
        int end = scoreList.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if (scoreList.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scoreList.size() - start;
    }
}
