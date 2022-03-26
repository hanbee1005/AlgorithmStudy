package Mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        Person[] people = new Person[testCase];
        for (int i = 0; i < testCase; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            people[i] = new Person(xy[0], xy[1]);
        }

        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < testCase; j++) {
                if (i != j) {
                    people[i].compareXY(people[j]);
                }
            }
        }

        for (int i = 0; i < testCase; i++) {
            System.out.print(people[i].rank + " ");
        }
    }

    private static class Person {
        private int x;
        private int y;
        private int rank;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
            this.rank = 1;
        }

        public void compareXY(Person p) {
            if (p.x > this.x && p.y > this.y) {  // 다른 사람의 덩치가 더 큰 경우
                rank++;
            }
        }
    }
}
