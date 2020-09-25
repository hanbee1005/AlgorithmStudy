public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleNodeMng doubleLinkedList = new DoubleNodeMng(1);
        for (int i = 2; i < 10; i++) {
            doubleLinkedList.add(i);
        }
        doubleLinkedList.desc();

        System.out.println("-------------");

        doubleLinkedList.searchFromHead(4);
        doubleLinkedList.searchFromTail(7);

        System.out.println("-------------");

        doubleLinkedList.delete(5);
        doubleLinkedList.delete(1);
        doubleLinkedList.delete(9);
        doubleLinkedList.desc();

        System.out.println("-------------");

        doubleLinkedList.insertBefore(2, 1);
        doubleLinkedList.insertBefore(6, 5);
        doubleLinkedList.desc();

        System.out.println("-------------");

        doubleLinkedList.insertAfter(8, 9);
        doubleLinkedList.desc();
    }
}

class DoubleNode {
    int data;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoubleNodeMng {
    DoubleNode head;
    DoubleNode tail;

    DoubleNodeMng(int data) {
        this.head = new DoubleNode(data);
        this.tail = this.head;
    }

    // 리스트 데이터 순서대로 출력하기
    void desc() {
        DoubleNode node = this.head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    // 리스트 마지막에 데이터 추가하기
    void add(int data) {
        DoubleNode node = this.head;
        if (node == null) {
            this.head = new DoubleNode(data);
            this.tail = new DoubleNode(data);
            return;
        }

        while (node.next != null) {
            node = node.next;
        }

        DoubleNode new_data = new DoubleNode(data);
        node.next = new_data;
        new_data.prev = node;
        this.tail = node.next;
    }

    // 특정 데이터 앞에서부터 찾기
    void searchFromHead(int data) {
        int index = 0;
        DoubleNode node = this.head;
        if (node == null) {
            System.out.println("리스트에 데이터가 없습니다.");
            return;
        }

        while (node != null) {
            if (node.data == data) {
                System.out.println("index: " + index + ", data: " +node.data);
                break;
            } else {
                node = node.next;
                index++;
            }
        }
    }

    // 특정 데이터 뒤에서부터 찾기
    void searchFromTail(int data) {
        int index = -1;
        DoubleNode node = this.tail;
        if (node == null) {
            System.out.println("리스트에 데이터가 없습니다.");
            return;
        }

        while (node != null) {
            if (node.data == data) {
                System.out.println("index: " + index + ", data: " +node.data);
                break;
            } else {
                node = node.prev;
                index -= 1;
            }
        }
    }

    // 특정 데이터 삭제하기 (앞에서부터 찾기)
    void delete(int data) {
        DoubleNode node = this.head;
        if (node == null) {
            System.out.println("리스트에 데이터가 없습니다.");
            return;
        }

        while (node != null) {
            if (this.head.data == data) {
                this.head = node.next;
                node.next.prev = null;
                node.next = null;
                break;
            } else {
                if (node.data == data) {
                    if (node.data == this.tail.data) {
                        this.tail = node.prev;
                        node.prev.next = null;
                        node.prev = null;
                    } else {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                        node.prev = null;
                        node.next = null;
                    }
                    break;
                } else {
                    node = node.next;
                }
            }
        }
    }

    // 특정 데이터 앞에 데이터 삽입하기 (앞에서부터 찾기)
    void insertBefore(int after_data, int data) {
        DoubleNode node = this.head;
        if (node == null) {
            System.out.println("리스트에 데이터가 없습니다.");
            return;
        }

        while (node != null) {
            if (this.head.data == after_data) {
                DoubleNode new_data = new DoubleNode(data);
                this.head = new_data;
                new_data.next = node;
                node.prev = new_data;
                break;
            } else {
                if (node.data == after_data) {
                    DoubleNode new_data = new DoubleNode(data);
                    new_data.prev = node.prev;
                    node.prev.next = new_data;
                    new_data.next = node;
                    node.prev = new_data;
                    break;
                } else {
                    node = node.next;
                }
            }
        }
    }

    // 특정 데이터 뒤에 데이터 삽입하기 (뒤에서부터 찾기)
    void insertAfter(int before_data, int data) {
        DoubleNode node = this.tail;
        if (node == null) {
            this.head = new DoubleNode(data);
            this.tail = this.head;
            return;
        }

        while (node != null) {
            if (this.tail.data == before_data) {
                DoubleNode new_data = new DoubleNode(data);
                this.tail = new_data;
                node.next = new_data;
                new_data.prev = node;
                break;
            } else {
                if (node.data == data) {
                    DoubleNode new_data = new DoubleNode(data);
                    new_data.next = node.next;
                    node.next.prev = new_data;
                    new_data.prev = node;
                    node.next = new_data;
                    break;
                } else {
                    node = node.prev;
                }
            }
        }
    }

}
