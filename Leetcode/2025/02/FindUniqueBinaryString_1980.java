package backtracking;

public class FindUniqueBinaryString_1980 {
    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"01","10"}));
        System.out.println(findDifferentBinaryString(new String[]{"00","01"}));
        System.out.println(findDifferentBinaryString(new String[]{"111","011","001"}));
    }

    private static String findDifferentBinaryString(String[] nums) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < nums.length; i++){
            answer.append(nums[i].charAt(i) == '0' ? '1' :'0');
        }

        return answer.toString();
    }
}
