package array;

public class FindTheStudentThatWillReplaceTheChalk_1894 {
    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[]{5,1,5}, 22));
        System.out.println(chalkReplacer(new int[]{3,4,1,2}, 25));
        System.out.println(chalkReplacer(new int[]{1}, 1000000000));
    }

    private static int chalkReplacer(int[] chalk, int k) {
        long totalChalkNeeded = 0;
        for (int studentChalkUse : chalk) {
            totalChalkNeeded += studentChalkUse;
        }

        int remainingChalk = (int)(k % totalChalkNeeded);

        for (int studentIndex = 0; studentIndex < chalk.length; studentIndex++) {
            if (remainingChalk < chalk[studentIndex]) {
                return studentIndex;
            }
            remainingChalk -= chalk[studentIndex];
        }

        return 0;
    }
}
