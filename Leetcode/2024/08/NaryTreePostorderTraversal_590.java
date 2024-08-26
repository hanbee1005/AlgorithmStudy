package tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal_590 {
    public static void main(String[] args) {
        System.out.println(postorder(new Node(1, List.of(new Node(3, List.of(new Node(5), new Node(6))),
                new Node(2), new Node(4)))));
        System.out.println(postorder(new Node(1, List.of(
                new Node(2),
                new Node(3, List.of(new Node(6), new Node(7, List.of(new Node(11, List.of(new Node(14))))))),
                new Node(4, List.of(new Node(8, List.of(new Node(12))))),
                new Node(5, List.of(new Node(9, List.of(new Node(13))), new Node(10)))
        ))));
    }

    private static List<Integer> answer;

    public static List<Integer> postorder(Node root) {
        answer = new ArrayList<>();
        find(root);
        return answer;
    }

    private static void find(Node root){
        if(root == null) return;

        if(root.children == null){
            answer.add(root.val);
            return;
        }

        for(Node node : root.children){
            find(node);
        }
        answer.add(root.val);
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
