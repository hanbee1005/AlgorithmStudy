package Sep2023;

/**
 * Top Coder CorporationSalary SRM407 Div 2 Level 2
 */
public class TopCoderCorporationSalary {
    private static long[] salaries;

    public static void main(String[] args) {
        System.out.println(totalSalary(new String[]{"N"}));
        System.out.println(totalSalary(new String[]{"NNYN", "NNYN", "NNNN", "NYYN"}));
        System.out.println(totalSalary(new String[]{"NNNNNN", "YNYNNY", "YNNNNY", "NNNNNN", "YNYNNN", "YNNYNN"}));
        System.out.println(totalSalary(new String[]{"NYNNYN", "NNNNNN", "NNNNNN", "NNYNNN", "NNNNNN", "NNNYYN"}));
        System.out.println(totalSalary(new String[]{"NNNN", "NNNN", "NNNN", "NNNN"}));
    }

    private static long totalSalary(String[] relations) {
        salaries = new long[relations.length];

        long total = 0;
        for (int i = 0; i < relations.length; i++) {
            total += findSalary(i, relations);
        }

        return total;
    }

    private static long findSalary(int i, String[] relations) {
        if (salaries[i] == 0) {
            long salary = 0;
            String relation = relations[i];

            for (int j = 0; j < relation.length(); j++) {
                if (relation.charAt(j) == 'Y') {
                    salary += findSalary(j, relations);
                }
            }

            if (salary == 0) return 1;

            salaries[i] = salary;
        }

        return salaries[i];
    }
}
