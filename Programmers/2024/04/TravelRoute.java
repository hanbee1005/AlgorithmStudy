package Apr2024;

import java.util.*;

/**
 * Level 3. 여행 경로 (DFS/BFS)
 */
public class TravelRoute {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    }

    private static String[] solution(String[][] tickets) {
        String[] answer = {};

        Map<String, List<String[]>> airports = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if (airports.containsKey(from)) {
                airports.get(from).add(new String[]{to, String.valueOf(i)});
                airports.get(from).sort(Comparator.comparing(a -> a[0]));
            } else {
                int ticketNum = i;
                airports.put(from, new ArrayList<>(){{add(new String[]{to, String.valueOf(ticketNum)});}});
            }
        }

        Queue<List<Integer>> routes = new LinkedList<>();
        routes.add(new ArrayList<>(){{add(-1);}});

        while (!routes.isEmpty()) {
            List<Integer> route = routes.poll();

            if (route.size() == tickets.length + 1) {
                List<String> result = new ArrayList<>();
                for (int i : route) {
                    if (i == -1) result.add("ICN");
                    else result.add(tickets[i][1]);
                }
                answer = result.toArray(String[]::new);
                break;
            }

            int last = route.get(route.size() - 1);
            String from = last == -1 ? "ICN" : tickets[last][1];

            if (airports.containsKey(from)) {
                for (String[] to : airports.get(from)) {
                    int cardNum = Integer.parseInt(to[1]);
                    if (!route.contains(cardNum)) {
                        List<Integer> next = new ArrayList<>(route);
                        next.add(cardNum);
                        routes.offer(next);
                    }
                }
            }
        }

        return answer;
    }
}
