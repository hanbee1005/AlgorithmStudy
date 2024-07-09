package array;

public class AverageWaitingTime_1701 {
    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }

    private static double averageWaitingTime(int[][] customers) {
        long sum = 0;
        long currentTime = 0;
        for (int[] customer : customers) {
            if (currentTime < customer[0]) {
                currentTime = customer[0];
            }

            currentTime += customer[1];
            sum += currentTime - customer[0];
        }

        return (double) sum / customers.length;
    }
}
