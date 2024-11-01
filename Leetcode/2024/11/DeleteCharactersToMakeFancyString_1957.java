package string;

public class DeleteCharactersToMakeFancyString_1957 {
    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
        System.out.println(makeFancyString("aab"));
    }

    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char last = ' ';
        int count = 0;

        for (char c : s.toCharArray()) {
            if (last != c) {
                sb.append(c);
                last = c;
                count = 1;
            } else {
                if (count < 2) {
                    sb.append(c);
                    count++;
                }
            }
        }

        return sb.toString();
    }
}
