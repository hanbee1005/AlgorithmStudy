package queue;

import java.util.Deque;
import java.util.LinkedList;

public class DesignCircularDeque_641 {
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        System.out.println(obj.insertFront(1));
        System.out.println(obj.insertFront(2));
        System.out.println(obj.insertFront(3));
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getRear());
        System.out.println(obj.isFull());
        System.out.println(obj.deleteLast());
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getFront());
    }

    private static class MyCircularDeque {
        Deque<Integer> queue = new LinkedList<>();
        int size = 0;

        public MyCircularDeque(int k) {
            size = k;
        }

        public boolean insertFront(int value) {
            if (queue.size() == size) {
                return false;
            }

            queue.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (queue.size() == size) {
                return false;
            }

            queue.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if (queue.isEmpty()) return false;

            queue.removeFirst();
            return true;
        }

        public boolean deleteLast() {
            if (queue.isEmpty()) return false;

            queue.removeLast();
            return true;
        }

        public int getFront() {
            if (queue.isEmpty()) return -1;
            return queue.getFirst();
        }

        public int getRear() {
            if (queue.isEmpty()) return -1;
            return queue.getLast();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public boolean isFull() {
            return size == queue.size();
        }
    }
}
