package array;

public class CrawlerLogFolder_1598 {
    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        System.out.println(minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(minOperations(new String[]{"d1/","../","../","../"}));
    }

    public static int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if (log.equals("./")) continue;
            if (log.equals("../")) {
                count = Math.max(0, count - 1);
                continue;
            }

            count++;
        }

        return count;
    }
}
