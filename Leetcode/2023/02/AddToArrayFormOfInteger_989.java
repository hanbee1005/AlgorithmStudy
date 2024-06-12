package linkedlist;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger_989 {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1,2,0,0}, 34));
        System.out.println(addToArrayForm(new int[]{2,7,4}, 181));
        System.out.println(addToArrayForm(new int[]{2,1,5}, 806));
        System.out.println(addToArrayForm(new int[]{0}, 1000));
        System.out.println(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
        System.out.println(addToArrayForm(new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3}, 516));
    }

    private static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();

        int len = num.length - 1;
        while(len >= 0 || k > 0){
            if(len >= 0){
                k += num[len--];
            }
            res.addFirst(k % 10);
            k /= 10;
        }

        return res;
    }
}
