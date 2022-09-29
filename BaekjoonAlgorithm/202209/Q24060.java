package Sep2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q24060 {

    private static int[] sorted;  // 합치는 과정에서 정렬하여 원소를 담을 임시배열
    private static List<Integer> setting = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        sorted = new int[N];
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        mergeSort(A, 0, N - 1);
        sorted = null;

        if ((setting.size() < K)) {
            System.out.println(-1);
        } else {
            System.out.println(setting.get(K - 1));
        }
    }

    private static void mergeSort(int[] A, int left, int right) {
        /*
         *  left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우
         *  더이상 쪼갤 수 없으므로 return한다.
         */
        if (left == right) return;

        int mid = (left + right) / 2;  // 절반 위치

        mergeSort(A, left, mid); // 절반 중 왼쪽 부분리스트(left ~ mid)
        mergeSort(A, mid + 1, right); // 절반 중 오른쪽 부분리스트(mid+1 ~ right)

        merge(A, left, mid, right); // 병합작업
    }

    private static void merge(int[] A, int left, int mid, int right) {
        int l = left;  // 왼쪽 부분 리스트의 시작점
        int r = mid + 1;  // 오른쪽 부분 리스트의 시작점
        int idx = left;  // 채워 넣을 배열의 인덱스

        while (l <= mid && r <= right) {
            /*
             *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
             */
            if (A[l] <= A[r]) {
                setting.add(A[l]);
                sorted[idx++] = A[l++];
            }
            /*
             *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
             *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
             */
            else {
                setting.add(A[r]);
                sorted[idx++] = A[r++];
            }
        }

        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if(l > mid) {
            while(r <= right) {
                setting.add(A[r]);
                sorted[idx++] = A[r++];
            }
        }

        /*
         * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
         * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
         * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        else {
            while(l <= mid) {
                setting.add(A[l]);
                sorted[idx++] = A[l++];
            }
        }

        /*
         * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
         */
        for(int i = left; i <= right; i++) {
            A[i] = sorted[i];
        }
    }
}
