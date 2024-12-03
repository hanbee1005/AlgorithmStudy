package string;

public class AddingSpacesToAString_2109 {
    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15}));
        System.out.println(addSpaces("icodeinpython", new int[]{1,5,7,9}));
        System.out.println(addSpaces("spacing", new int[]{0,1,2,3,4,5,6}));
    }

    private static String addSpaces(String s, int[] spaces) {
        char[] ch = s.toCharArray();
        char[] answer = new char[s.length() + spaces.length];

        int idx = 0 ,c = 0;
        for (int space : spaces){
            while (c < space) {
                answer[idx] = ch[c];
                idx++;
                c++;
            }

            answer[idx] = ' ';
            idx++;
        }

        while(c < s.length()) {
            answer[idx] = ch[c];
            idx++;
            c++;
        }

        return new String(answer);
    }
}
