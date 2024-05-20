package May2024;

import java.util.Stack;

/**
 * Level 3. 표 편집
 */
public class EditTable {
    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));  // OOOOXOOO
        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));  // OOXOXOOO
    }

    private static String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));

        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }

        next[n - 1] = -1;

        for (int i = 0; i < cmd.length; i++) {
            String[] input = cmd[i].split(" ");

            if ("D".equals(input[0])) {
                int count = Integer.parseInt(input[1]);
                while (count-- > 0) {
                    k = next[k];
                }
            } else if ("U".equals(input[0])) {
                int count = Integer.parseInt(input[1]);
                while (count-- > 0) {
                    k = pre[k];
                }
            } else if ("C".equals(input[0])) {
                stack.push(new Node(pre[k], k, next[k])); // 삭제되는 이전 노드와 다음노드를 저장
                sb.setCharAt(k, 'X');

                if (next[k] == -1) { // 맨 끝에 있는 경우
                    next[pre[k]] = -1;
                } else if (pre[k] == -1) { // 앞에 있는 경우
                    pre[next[k]] = -1;
                } else {
                    next[pre[k]] = next[k];
                    pre[next[k]] = pre[k];
                }

                if (next[k] == -1) { // 맨 끝에 있는 경우만 이전으로 가고
                    k = pre[k];
                } else { // 아닌 경우는 뒤로 간다.
                    k = next[k];
                }
            } else if ("Z".equals(input[0])) {
                Node node = stack.pop();
                sb.setCharAt(node.cur, 'O'); // 다시 살려기

                if (node.next == -1) { // 맨 끝
                    next[node.pre] = node.cur;
                } else if (node.pre == -1) { // 맨 앞
                    pre[node.next] = node.cur;
                } else { // 걍 중간
                    next[node.pre] = node.cur;
                    pre[node.next] = node.cur;
                }
            }
        }

        return sb.toString();
    }

    static class Node {
        int pre;
        int cur;
        int next;

        Node(int pre, int cur, int next) {
            this.pre = pre;
            this.cur = cur;
            this.next = next;
        }
    }
}
