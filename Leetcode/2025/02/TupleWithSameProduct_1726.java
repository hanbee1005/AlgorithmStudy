package hashmap;

import java.util.HashMap;

public class TupleWithSameProduct_1726 {
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2,3,4,6}));
        System.out.println(tupleSameProduct(new int[]{1,2,4,5,10}));
    }

    private static int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int count=0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++){
                int product = nums[i] * nums[j];
                count += (map.getOrDefault(product,0) * 8);
                map.merge(product, 1, Integer::sum);
            }
        }

        return count;
    }
}
