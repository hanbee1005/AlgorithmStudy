import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NewsClustering {
    public static void main(String[] args) {
        System.out.println(solution("A+C", "DEF"));
    }

    private static int solution(String str1, String str2) {
        List<String> A = makeMatrix(removeSpace(str1));
        List<String> B = makeMatrix(removeSpace(str2));

        boolean shortA = Math.min(A.size(), B.size()) == A.size();

        List<List<String>> collections = getCollections(shortA ? A : B, shortA ? B : A);
        List<String> intersection = new ArrayList<>(collections.get(0));
        List<String> union = new ArrayList<>(collections.get(1));

        // 자카드 유사도 구하기
        if (intersection.size() == 0 && union.size() == 0) {
            return 65536;
        } else if (intersection.size() == 0) {
            return 0;
        }

        return (int) (((double) intersection.size() / union.size()) * 65536);
    }

    private static String removeSpace(String str) {
        if (str.contains(" ")) {
            return str.replaceAll(" ", "+");
        }

        return str;
    }

    private static List<String> makeMatrix(String str) {
        System.out.println(str);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String substring = str.substring(i, i + 2);
            if (substring.matches("[a-zA-Z]*")) {
                result.add(str.substring(i, i + 2).toUpperCase());
            }
        }

        return result;
    }

    private static List<List<String>> getCollections(List<String> shortList, List<String> longList) {
        Queue<String> shortQueue = new PriorityQueue<>();
        Queue<String> longQueue = new PriorityQueue<>();

        shortQueue.addAll(shortList);
        longQueue.addAll(longList);

        List<String> intersec = new ArrayList<>();
        List<String> union  = new ArrayList<>();

        while (true) {
            if (shortQueue.isEmpty()) {
                union.addAll(longQueue);
                break;
            }

            if (longQueue.isEmpty()) {
                union.addAll(shortQueue);
                break;
            }

            String a = shortQueue.peek();
            String b = longQueue.peek();

            if (a.equals(b)) {
                shortQueue.poll();
                longQueue.poll();

                intersec.add(a);
                union.add(a);
            } else {
                if (a.compareTo(b) < 0) {  // a가 작은 경우
                    shortQueue.poll();
                    union.add(a);
                } else {
                    longQueue.poll();
                    union.add(b);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        result.add(intersec);
        result.add(union);

        return result;
    }
}
