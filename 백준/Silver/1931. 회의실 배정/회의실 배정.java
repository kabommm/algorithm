import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];


        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();	// 시작시간
            arr[i][1] = sc.nextInt();	// 종료시간
        }
        //종료시간이 빠른 순으로 정렬
        //종료 시간이 같다면 시작시간이 빠른순

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];

        });

        int answer = 0;
        int time = 0;

        for(int i = 0; i < n; i++) {
            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(time <= arr[i][0]) {
                time = arr[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
