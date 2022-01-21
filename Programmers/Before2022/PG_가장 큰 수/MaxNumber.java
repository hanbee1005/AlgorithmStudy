import java.util.Arrays;
import java.util.Comparator;

public class MaxNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }

    private static String solution(int[] numbers) {
        String[] numStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }

        Comparator<String> comp = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
        Arrays.sort(numStr, comp);

        if ("0".equals(numStr[0])) {
            return "0";
        }

        StringBuffer answer = new StringBuffer();
        for (String str : numStr) {
            answer.append(str);
        }

        return answer.toString();
    }
}
