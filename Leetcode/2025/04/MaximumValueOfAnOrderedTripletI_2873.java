public class MaximumValueOfAnOrderedTripletI_2873 {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12,6,1,2,7}));
        System.out.println(maximumTripletValue(new int[]{1,10,3,4,19}));
        System.out.println(maximumTripletValue(new int[]{1,2,3}));
    }

    private static long maximumTripletValue(int[] nums) {
        long answer = 0;
        int imax = 0, dmax = 0;

        for (int num: nums) {
            answer = Math.max(answer, (long) dmax * num);
            dmax = Math.max(dmax, imax - num);
            imax = Math.max(imax, num);
        }

        return answer;
    }
}
