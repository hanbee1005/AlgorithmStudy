import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJAlgo_2002 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> cars = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String car = br.readLine();
            cars.put(car, i);
        }

        for(int i = 0; i < N; i++) {
            String car = br.readLine();
            int num = cars.get(car);
            cars.remove(car);
            for(int j : cars.values()) {
                if (num > j) {
                    result += 1;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
