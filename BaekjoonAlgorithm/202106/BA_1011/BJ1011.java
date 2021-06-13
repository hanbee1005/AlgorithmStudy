import java.io.*;

public class BJ1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            int movingDistance = 0;
            int xMovingDistance = 0;
            int yMovingDistance = 0;

            while (true) {
                movingDistance++;

                x += movingDistance;
                xMovingDistance++;  // x의 이동 횟수

                if (x >= y) {
                    break;
                }

                y -= movingDistance;
                yMovingDistance++;  // y의 이동 횟수

                if (x >= y) {
                    break;
                }
            }

            bw.write(String.valueOf(xMovingDistance + yMovingDistance));
            bw.newLine();
        }

        bw.flush();
    }
}
