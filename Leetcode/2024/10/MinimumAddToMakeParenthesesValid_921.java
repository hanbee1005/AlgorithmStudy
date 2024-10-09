package string;

public class MinimumAddToMakeParenthesesValid_921 {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
    }

    private static int minAddToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                openCount++;
            } else {
                if(openCount > 0) {
                    openCount--;
                } else
                    closeCount++;
            }
        }

        return openCount + closeCount;
    }
}
