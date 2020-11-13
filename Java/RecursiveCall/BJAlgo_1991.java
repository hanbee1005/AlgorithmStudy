import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJAlgo_1991 {
    static StringBuilder pre = new StringBuilder();
    static StringBuilder ino = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, String[]> binaryTree = new HashMap();

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String[] values = {inputs[1], inputs[2]};
            binaryTree.put(inputs[0], values);
        }

        preOrder(binaryTree, "A");
        inOrder(binaryTree, "A");
        postOrder(binaryTree, "A");

        System.out.println(pre);
        System.out.println(ino);
        System.out.println(post);
    }

    private static void preOrder(Map<String, String[]> tree, String startNode) {
        pre.append(startNode);

        if (!".".equals(tree.get(startNode)[0])) {
            preOrder(tree, tree.get(startNode)[0]);
        }

        if (!".".equals(tree.get(startNode)[1])) {
            preOrder(tree, tree.get(startNode)[1]);
        }
    }

    private static void inOrder(Map<String, String[]> tree, String startNode) {
        if (!".".equals(tree.get(startNode)[0])) {
            inOrder(tree, tree.get(startNode)[0]);
        }

        ino.append(startNode);

        if (!".".equals(tree.get(startNode)[1])) {
            inOrder(tree, tree.get(startNode)[1]);
        }
    }

    private static void postOrder(Map<String, String[]> tree, String startNode) {
        if (!".".equals(tree.get(startNode)[0])) {
            postOrder(tree, tree.get(startNode)[0]);
        }

        if (!".".equals(tree.get(startNode)[1])) {
            postOrder(tree, tree.get(startNode)[1]);
        }

        post.append(startNode);
    }
}
