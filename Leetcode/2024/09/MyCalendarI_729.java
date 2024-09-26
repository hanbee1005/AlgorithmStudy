package search;

public class MyCalendarI_729 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }

    private static class MyCalendar {
        static class Node {
            int start;
            int end;

            Node left, right;

            public Node(int start,int end){
                this.start = start;
                this.end = end;
            }
        }

        Node root;

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            if(root == null){
                root = new Node(start,end);
                return true;
            }

            Node curr = root;

            while(true) {
                if(end <= curr.start) {
                    if(curr.left == null){
                        curr.left = new Node(start,end);
                        return true;
                    }
                    curr = curr.left;
                } else if(start >= curr.end) {
                    if(curr.right == null){
                        curr.right = new Node(start,end);
                        return true;
                    }
                    curr = curr.right;
                } else {
                    return false;
                }
            }
        }
    }
}
