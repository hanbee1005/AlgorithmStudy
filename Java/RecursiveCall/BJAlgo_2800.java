import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_2800 {
    static ArrayList<ArrayList<Integer[]>> combi = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] equation = br.readLine().split("");

        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer[]> brackets = new ArrayList<>();

        Set<String> answer = new HashSet<>();

        for (int i = 0; i < equation.length; i++) {
            if (equation[i].equals("(")) {
                equation[i] = "";
                stack.add(i);
            } else if (equation[i].equals(")")) {
                equation[i] = "";
                brackets.add(new Integer[]{stack.remove(stack.size() - 1), i});
            }
        }

        for (int i = 0; i < brackets.size(); i++) {
            combi.clear();
            combination(brackets, new boolean[brackets.size()], 0, i);

            for (ArrayList<Integer[]> b : combi) {
                String[] result = new String[equation.length];
                System.arraycopy(equation, 0, result, 0, result.length);
                StringBuilder s = new StringBuilder();
                for (Integer[] idx : b) {
                    result[idx[0]] = "(";
                    result[idx[1]] = ")";
                }
                for (String r : result) {
                    s.append(r);
                }
                answer.add(s.toString());
            }
        }

        List<String> answerList = new ArrayList(answer);
        Collections.sort(answerList);
        for (String a : answerList) {
            System.out.println(a);
        }
    }

    static void combination(ArrayList<Integer[]> arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            ArrayList<Integer[]> tmp = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if (visited[i]) {
                    tmp.add(arr.get(i));
                }
            }
            combi.add(tmp);
            return;
        } else {
            for(int i = start; i < arr.size(); i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}
