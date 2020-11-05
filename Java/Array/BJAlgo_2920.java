import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJAlgo_2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        boolean ascending = true;
        boolean descending = true;

        for(int i = 1; i < tmp.length; i++) {
            if(Integer.parseInt(tmp[i]) > Integer.parseInt(tmp[i - 1])) {
                descending = false;
            } else if(Integer.parseInt(tmp[i]) < Integer.parseInt(tmp[i - 1])) {
                ascending = false;
            }
        }

        if (ascending) {
            System.out.println("ascending");
        } else if (descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
