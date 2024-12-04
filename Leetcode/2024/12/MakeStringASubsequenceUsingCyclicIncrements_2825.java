package string;

public class MakeStringASubsequenceUsingCyclicIncrements_2825 {
    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("abc", "ad"));
        System.out.println(canMakeSubsequence("zc", "ad"));
        System.out.println(canMakeSubsequence("ab", "d"));
    }

    private static boolean canMakeSubsequence(String str1, String str2) {
        int srcLen = str1.length();
        int tgtLen = str2.length();
        int srcIdx = 0;
        int tgtIdx = 0;

        while (srcIdx < srcLen && tgtIdx < tgtLen) {
            char srcChar = str1.charAt(srcIdx);
            char tgtChar = str2.charAt(tgtIdx);

            if (srcChar == tgtChar ||
                    (srcChar == 'z' && tgtChar == 'a') ||
                    (srcChar + 1 == tgtChar)) {
                srcIdx++;
                tgtIdx++;
            } else {
                srcIdx++;
            }
        }
        return tgtIdx == tgtLen;
    }
}
