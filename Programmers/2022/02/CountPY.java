package Feb2022;

public class CountPY {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }

    private static boolean solution(String s) {
        long pCount = s.chars().filter(c -> String.valueOf((char) c).equalsIgnoreCase("p")).count();
        long yCount = s.chars().filter(c -> String.valueOf((char) c).equalsIgnoreCase("y")).count();

        return pCount == yCount;
    }
}
