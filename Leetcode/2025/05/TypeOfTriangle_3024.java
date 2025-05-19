package math;

public class TypeOfTriangle_3024 {
    public static void main(String[] args) {
        System.out.println(triangleType(new int[]{3,3,3}));
        System.out.println(triangleType(new int[]{3,4,5}));
    }

    private static String triangleType(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }

        if ((nums[0] == nums[1] && (nums[0] + nums[1]) > nums[2])
                || (nums[1] == nums[2] && (nums[1] + nums[2]) > nums[0])
                || (nums[2] == nums[0] && (nums[0] + nums[2]) > nums[1])) {
            return "isosceles";
        }

        if ((nums[0] + nums[1]) > nums[2]
                && (nums[0] + nums[2]) > nums[1]
                && (nums[1] + nums[2]) > nums[0]
        ) {
            return "scalene";
        }

        return "none";
    }
}
