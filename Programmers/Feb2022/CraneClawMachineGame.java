package Feb2022;

import java.util.*;

public class CraneClawMachineGame {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 1; i <= board.length; i++) {
            map.put(i, new LinkedList<>());
        }

        for (int[] b : board) {
            for (int j = 0; j < b.length; j++) {
                if (b[j] != 0) {
                    map.get(j + 1).add(b[j]);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();

        for (int pos : moves) {
            if (!map.get(pos).isEmpty()) {
                int character = map.get(pos).poll();
                if (!stack.isEmpty() && stack.peek() == character) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(character);
                }
            }
        }

        return answer;
    }
}
