package Sep2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] palindrome = isPalindrome(br.readLine());
            sb.append(palindrome[0]).append(" ").append(palindrome[1]).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] recursion(String s, int l, int r, int count){
        if(l >= r) return new int[]{1, count};
        else if(s.charAt(l) != s.charAt(r)) return new int[]{0, count};
        else return recursion(s, l+1, r-1, count + 1);
    }
    public static int[] isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1, 1);
    }
}
