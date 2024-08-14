package string;

public class LengthOfLastWord_58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    private static int lengthOfLastWord(String s) {
        String input=s.trim();
        int len=0;
        for(int i = input.length() - 1; i >= 0; i--){
            if(input.charAt(i) == ' '){
                break;
            }

            len++;
        }
        return len;
    }
}
