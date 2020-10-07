import java.io.*;

public class BJAlgo_2750 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dataList = new int[N];
        for (int i = 0; i < N; i++) {
            dataList[i] = Integer.parseInt(br.readLine());
        }

        for (int stand = 0; stand < dataList.length - 1; stand++) {
            int lowest = stand;
            for (int num = stand + 1; num < dataList.length; num++) {
                if (dataList[lowest] > dataList[num]) {
                    lowest = num;
                }
            }
            int tmp = dataList[stand];
            dataList[stand] = dataList[lowest];
            dataList[lowest] = tmp;
        }

        for (int i = 0; i < dataList.length; i++) {
            System.out.println(dataList[i]);
        }
    }
}
