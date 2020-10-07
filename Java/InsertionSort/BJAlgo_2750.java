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
            for (int num = stand + 1; num > 0; num--) {
                if (dataList[num] < dataList[num - 1]) {
                    int tmp = dataList[num];
                    dataList[num] = dataList[num - 1];
                    dataList[num - 1] = tmp;
                }
            }
        }

        for (int i = 0; i < dataList.length; i++) {
            System.out.println(dataList[i]);
        }
    }
}
