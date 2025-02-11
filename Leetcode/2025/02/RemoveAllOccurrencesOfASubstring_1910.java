package stack;

public class RemoveAllOccurrencesOfASubstring_1910 {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrences("axxxxyyyyb", "xy"));
        System.out.println(removeOccurrences("ccctltctlltlb", "ctl"));
    }

    private static String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);

        while(sb.indexOf(part) != -1) {
            int idx = sb.indexOf(part);
            sb.delete(idx, idx + part.length());
        }

        return sb.toString();
    }
}
