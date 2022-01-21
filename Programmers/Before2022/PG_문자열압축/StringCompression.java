import java.util.ArrayList;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(Solution("a"));
    }

    private static int Solution(String s) {
        int answer = 1;

        for (int n = 1; n <= s.length() / 2; n++) {
            String now = "";
            int count = 0;

            ArrayList<String> strings = new ArrayList<>();
            int start = 0;
            int end = start + n;
            while(end < s.length()) {
                strings.add(s.substring(start, end));
                start = end;
                end = start + n;
            }
            strings.add(s.substring(start));

            StringBuilder sb = new StringBuilder();

            for(String currentStr : strings) {
                if (now.equals("")) {
                    now = currentStr;
                    count++;
                    continue;
                }

                if (now.equals(currentStr)) {
                    count++;
                } else {
                    if (count <= 1) {
                        sb.append(now);
                    } else {
                        sb.append(count).append(now);
                    }
                    now = currentStr;
                    count = 1;
                }
            }

            if (count <= 1) {
                sb.append(now);
            } else {
                sb.append(count).append(now);
            }

            if (answer == 1) {
                answer = sb.length();
            } else {
                answer = Math.min(answer, sb.length());
            }
        }

        return answer;
    }
}
