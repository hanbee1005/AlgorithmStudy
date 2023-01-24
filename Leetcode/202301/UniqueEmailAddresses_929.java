package hashmap;

import java.util.HashMap;
import java.util.Map;

public class UniqueEmailAddresses_929 {
    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"}));
    }

    private static int numUniqueEmails(String[] emails) {
        if (emails.length == 0) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        int result = 0;

        for (String email : emails) {
            String[] splitEmail = email.split("@");
            String key = splitEmail[0].replaceAll("\\.", "").split("\\+")[0].concat("@").concat(splitEmail[1]);
            if (!map.containsKey(key)) {
                map.put(key, 1);
                result++;
            }
        }

        return result;
    }
}
