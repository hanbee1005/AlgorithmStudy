package Jun2024;

/**
 * Level 3. 선입 선출 스케줄링
 */
public class FirstInFirstOutScheduling {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 2, 3}));
    }

    private static int solution(int n, int[] cores) {
        int answer = 0;

        int len = cores.length;
        if(n <= len) return n;

        //작업 시간
        int low = 1;
        int high = 10000 * n;
        int time = 0;
        int work = 0; //작업량

        //n개의 일을 수행 가능한 최소 시간 time을 구함
        while(low <= high){
            int mid = (low + high) / 2;

            //작업 처리 시간 동안 처리 가능한 일의 양
            int count = calculate(mid, cores);

            if(count >= n){
                high = mid-1;
                time = mid;
                work = count;
            }
            else{
                low = mid+1;
            }
        }

        work -= n;
        for(int i = cores.length - 1; i >= 0; i--){
            if(time % cores[i] == 0){
                if(work == 0){
                    answer = i + 1;
                    break;
                }
                work--;
            }
        }

        return answer;
    }

    public static int calculate(int mid, int[] cores){
        //0초에 모두 코어에 진입함
        int count = cores.length;

        for (int core : cores) {
            count += mid / core;
        }

        return count;
    }
}
