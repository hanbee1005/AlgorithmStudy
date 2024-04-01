package Jan2022;

import java.util.*;

public class GetReportResult {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)
        ));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> personIReported = new HashMap<>();  // 내가 신고한 사람 목록
        Map<String, Set<String>> personReportedMe = new HashMap<>();  // 나를 신고한 사람 목록

        // 목록에 기본 값 설정
        for (String id : id_list) {
            personIReported.put(id, new HashSet<>());
            personReportedMe.put(id, new HashSet<>());
        }

        for (String rp : report) {
            String[] r = rp.split(" ");

            personIReported.get(r[0]).add(r[1]);  // 내가 신고한 사람 저장
            personReportedMe.get(r[1]).add(r[0]);  // 나를 신고한 사람 저장
        }

        // 신고당한 횟수가 k 이상인 사람의 목록
        Set<String> reportedPeople = new HashSet<>();

        for (String key : personReportedMe.keySet()) {
            if (personReportedMe.get(key).size() >= k) {  // 나를 신고한 사람의 수가 k 이상이면 저장
                reportedPeople.add(key);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            personIReported.get(id_list[i]).retainAll(reportedPeople);  // 교집합 구하기
            answer[i] = personIReported.get(id_list[i]).size();
        }

        return answer;
    }
}