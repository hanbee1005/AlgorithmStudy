package array;

public class MaximumCountOfPositiveIntegerAndNegativeInteger_2529 {
    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-2,-1,-1,1,2,3}));
        System.out.println(maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
        System.out.println(maximumCount(new int[]{5,20,66,1314}));
        System.out.println(maximumCount(new int[]{-1924,-1910,-1840,-1797,-1714,-1640,-1638,-1567,-1564,-1409,-1141,-1115,-1068,-658,-465,-447,-434,-386,-321,-191,-186,-127,-63,69,186,253,334,401,482,805,809,812,833,913,955,991,1113,1128,1133,1178,1204,1570,1616,1725,1729,1787,1853,1943,1980,1980}));
    }

    private static int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num < 0) neg++;
            else if (num > 0) pos++;
        }

        return Math.max(pos, neg);
    }
}
