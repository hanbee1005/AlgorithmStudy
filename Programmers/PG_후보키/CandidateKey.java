import java.util.*;

public class CandidateKey {
    private static int answer;
    private static String[][] matrix;
    private static List<String> selectedIdx;

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        }));
    }

    private static int solution(String[][] relation) {
        answer = 0;
        selectedIdx = new ArrayList<>();

        matrix = new String[relation.length][relation[0].length];
        for (int i = 0; i < relation.length; i++) {
            System.arraycopy(relation[i], 0, matrix[i], 0, relation[i].length);
        }

        for (int i = 1; i <= relation[0].length; i++) {
            combination(new boolean[relation[0].length], 0, relation[0].length, i);
        }

        return answer;
    }

    private static void combination(boolean[] output, int start, int n, int r) {
        if (r == 0) {
            // 선택된 키 인덱스 확인
            List<Integer> idx = new ArrayList<>();
            for (int i = 0; i < output.length; i++) {
                if (output[i]) {
                    idx.add(i);
                }
            }

            // 선택된 인덱스를 문자열로 생성
            StringBuilder sb = new StringBuilder();
            for (int i : idx) {
                sb.append(i);
            }

            // 기존에 없던 조합만 후보키 확인
            if (sb.toString().length() == 1) {
                checkCandidateKey(idx, sb.toString());
            } else {
                boolean isSelected = false;
                for (String s : selectedIdx) {
                    int cnt = 0;
                    for (char c : s.toCharArray()) {
                        if (sb.toString().contains(String.valueOf(c))) {
                            cnt++;
                        }
                    }

                    if (cnt == s.length()) {
                        isSelected = true;
                        break;
                    }
                }

                if (!isSelected) {
                    checkCandidateKey(idx, sb.toString());
                }
            }

            return;
        }

        for (int i = start; i < n; i++) {
            output[i] = true;
            combination(output, i + 1, n, r - 1);
            output[i] = false;
        }
    }

    private static void checkCandidateKey(List<Integer> idx, String idxStr) {
        Set<String> set = new HashSet<>();
        for (String[] m : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int i : idx) {
                sb.append(m[i]);
            }
            set.add(sb.toString());
        }

        if (set.size() == matrix.length) {
            selectedIdx.add(idxStr);
            answer++;
        }
    }
}
