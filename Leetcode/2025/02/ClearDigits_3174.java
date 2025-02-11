package stack;

public class ClearDigits_3174 {
    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
    }

    private static String clearDigits(String s) {
        int len = s.length();
        StringBuilder answer = new StringBuilder();
        int i = -1;

        for(int j = 0; j < len; j++) {
            char c = s.charAt(j);
            if (c >= 'a' && c <= 'z') {
                i++;
                answer.append(c);
            } else {
                if(i >= 0) {
                    answer.deleteCharAt(i);
                    i--;
                }
            }
        }

        return answer.toString();
    }
}
