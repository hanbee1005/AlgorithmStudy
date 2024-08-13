package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, answer, new ArrayList<>());
        return answer;
    }
    private static void findCombinations(int idx, int[] candidates, int target, List<List<Integer>> answer, List<Integer> ds) {
        if (target == 0) {
            answer.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;

            ds.add(candidates[i]);
            findCombinations(i + 1, candidates, target - candidates[i], answer, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
