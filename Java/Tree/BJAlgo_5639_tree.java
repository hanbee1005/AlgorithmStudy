import java.io.*;

public class BJAlgo_5639_tree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NodeMng bst = new NodeMng();

        String s = "";
        while ((s = br.readLine()) != null && s.length() != 0) {
            bst.add(Integer.parseInt(s));
        }

        bst.printValue(bst.head);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class NodeMng {
    Node head;

    NodeMng() {
        this.head = null;
    }

    void add(int value) {
        if (this.head == null) {
            this.head = new Node(value);
            return;
        }

        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value > value) {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = new Node(value);
                    break;
                }
            } else {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = new Node(value);
                    break;
                }
            }
        }
    }

    void printValue(Node node) {
        if (node.left != null) {
            printValue(node.left);
        }

        if (node.right != null) {
            printValue(node.right);
        }

        System.out.println(node.value);
    }
}
