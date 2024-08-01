package array;

public class NumberOfSeniorCitizens_2678 {
    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
        System.out.println(countSeniors(new String[]{"1313579440F2036","2921522980M5644"}));
    }

    private static int countSeniors(String[] details) {
        int answer = 0;

        for (String detail : details) {
            int ageTens = detail.charAt(11) - '0';
            int ageOnes = detail.charAt(12) - '0';

            int age = ageTens * 10 + ageOnes;
            if (age > 60) {
                answer++;
            }
        }

        return answer;
    }
}
