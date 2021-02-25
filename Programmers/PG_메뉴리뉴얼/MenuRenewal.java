import java.util.*;

public class MenuRenewal {
    private static Map<String, Integer> menus;

    public static void main(String[] args) {
        String[] answer = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});

        for (String a : answer) {
            System.out.println(a);
        }
    }

    private static String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int c : course) {
            menus = new HashMap<>();
            for (String order : orders) {
                if (order.length() >= c) {
                    combi(order, new boolean[order.length()], 0, c, c);
                }
            }

            int maxNum = 2;
            ArrayList<String> tmp = new ArrayList<>();
            for (Map.Entry<String, Integer> menu : menus.entrySet()) {
                if (menu.getValue() > maxNum) {
                    tmp.clear();
                    maxNum = menu.getValue();
                    tmp.add(menu.getKey());
                } else if (menu.getValue() == maxNum) {
                    tmp.add(menu.getKey());
                }
            }

            answer.addAll(tmp);
        }

        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    private static void combi(String text, boolean[] visited, int start, int r, int cnt) {
        if(r == 0) {
            char[] selectedChar = new char[cnt];
            int idx = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    selectedChar[idx] = text.charAt(i);
                    idx += 1;
                }
            }

            Arrays.sort(selectedChar);

            String key = String.valueOf(selectedChar);
            if (menus.containsKey(key)) {
                menus.put(key, menus.get(key) + 1);
            } else {
                menus.put(key, 1);
            }
        } else {
            for(int i = start; i < visited.length; i++) {
                visited[i] = true;
                combi(text, visited, i + 1, r - 1, cnt);
                visited[i] = false;
            }
        }
    }
}
