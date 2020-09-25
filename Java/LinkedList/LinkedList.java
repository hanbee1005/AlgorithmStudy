public class LinkedList {
    public static void main(String[] args) {
        NodeMng linkedList = new NodeMng(1);
        for (int i = 2; i < 10; i++) {
            linkedList.add(i);
        }
        linkedList.desc();

        System.out.println("--------------");

        linkedList.delete(4);
        linkedList.delete(1);
        linkedList.delete(9);
        linkedList.desc();

        System.out.println("--------------");

        linkedList.insert_after(3, 4);
        linkedList.insert_after(8, 9);
        linkedList.desc();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class NodeMng {
    Node head;

    NodeMng(int data) {
        this.head = new Node(data);
    }

    // 모든 노드 데이터 순서대로 출력하기
    void desc() {
        Node node = this.head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    // 가장 마지막에 노드 추가하기
    void add(int data) {
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = new Node(data);
    }

    // 특정 데이터 삭제하기
    void delete(int data) {
        Node node = this.head;
        if (node == null) {
            System.out.println("리스트에 데이터가 없습니다.");
            return;
        }

        while (node.next != null) {
            // 삭제하려는 데이터가 가장 앞에 있는 데이터인 경우
            if (this.head.data == data) {
                this.head = node.next;
                node.next = null;
                break;
            } else {
                if (node.next.data == data) {
                    Node tmp = node.next;
                    node.next = node.next.next;
                    tmp.next = null;
                    break;
                } else {
                    node = node.next;
                }
            }
        }
    }

    // 득정 데이터 뒤에 데이터 삽입하기
    void insert_after(int before_data, int data) {
        Node node = this.head;
        if (node == null) {
            this.head = new Node(data);
            return;
        }

        while (node.next != null) {
            if (node.data == before_data) {
                break;
            } else {
                node = node.next;
            }
        }

        Node new_data = new Node(data);
        new_data.next = node.next;
        node.next = new_data;
    }
}
