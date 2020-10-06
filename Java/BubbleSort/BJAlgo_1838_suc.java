import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJAlgo_1838_suc {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> data = new PriorityQueue<>();

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            data.add(new Pair(i, Integer.parseInt(inputs[i])));
        }

        int result = 0;
        int index = 0;
        while (!data.isEmpty()) {
            Pair tmp = data.poll();
            if (result < (tmp.index - index)) {
                result = tmp.index - index;
            }

            index++;
        }

        System.out.println(result);
    }
}

class Pair implements Comparable<Pair>{
    int index;
    int value;

    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair pair) {
        return (int) (this.value - pair.value);
    }
}
