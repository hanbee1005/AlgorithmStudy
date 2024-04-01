package Feb2022;

import java.util.HashSet;
import java.util.Set;

public class Phonekemon {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
    }

    private static int solution(int[] nums) {
        int answer = nums.length / 2;

        Set<Integer> pokemon = new HashSet<>();
        for (int i : nums) {
            pokemon.add(i);
        }

        return Math.min(answer, pokemon.size());
    }
}
