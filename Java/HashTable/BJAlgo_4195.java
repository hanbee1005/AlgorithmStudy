import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJAlgo_4195 {
    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> networks = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            parent.clear();
            networks.clear();

            int f = Integer.parseInt(br.readLine());
            for (int j = 0; j < f; j++) {
                String[] people = br.readLine().split(" ");

                if (!parent.containsKey(people[0])) {
                    parent.put(people[0], people[0]);
                    networks.put(people[0], 1);
                }

                if (!parent.containsKey(people[1])) {
                    parent.put(people[1], people[1]);
                    networks.put(people[1], 1);
                }

                union(people[0], people[1]);
                System.out.println(networks.get(find(people[0])));
            }
        }
    }

    private static String find(String p) {
        if (p.equals(parent.get(p))) {
            return p;
        }

        String par = find(parent.get(p));
        parent.put(p, par);
        return parent.get(p);
    }

    private static void union(String a, String b) {
        String parent1 = find(a);
        String parent2 = find(b);

        if (!parent1.equals(parent2)) {
            parent.put(parent2, parent1);
            networks.put(parent1, networks.get(parent1) + networks.get(parent2));
        }
    }
}
