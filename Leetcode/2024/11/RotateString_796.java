package string;

public class RotateString_796 {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
    }

    private static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        String str = s + s;
        return str.contains(goal);
    }
}
