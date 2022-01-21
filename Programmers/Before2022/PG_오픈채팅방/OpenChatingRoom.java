import java.util.*;

public class OpenChatingRoom {
    public static void main(String[] args) {
        String[] param = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(param)));
    }

    private static String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> user = new HashMap<>();
        List<String[]> order = new ArrayList<>();

        for (String r : record) {
            String[] str = r.split(" ");

            if (str[0].equals("Enter") || str[0].equals("Change")) {
                user.put(str[1], str[2]);
            }

            if (!str[0].equals("Change")) {
                order.add(new String[]{str[1], str[0]});
            }
        }

        answer = new String[order.size()];

        for (int i = 0; i < order.size(); i++) {
            String nickname = user.get(order.get(i)[0]);
            answer[i] = nickname + "님이 " + (order.get(i)[1].equals("Enter") ? "들어왔습니다." : "나갔습니다.");
        }

        return answer;
    }
}
