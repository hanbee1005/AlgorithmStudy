package string;

public class MinimumNumberOfSwapsToMakeTheStringBalanced_1963 {
    public static void main(String[] args) {
        System.out.println(minSwaps("][]["));
        System.out.println(minSwaps("]]][[["));
        System.out.println(minSwaps("[]"));
    }

    private static int minSwaps(String s) {
        int opening = 0;
        int unbalanced = 0;

        for (var c : s.getBytes()) {
            if (c == '[') {
                opening++;
            } else {
                if (opening > 0)
                    opening--;
                else
                    unbalanced++;
            }
        }

        return unbalanced / 2 + unbalanced % 2;
    }
}
