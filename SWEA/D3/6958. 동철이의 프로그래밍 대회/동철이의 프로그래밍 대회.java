import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] a = new int[N][M];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for(int i = 0; i < N; i++) {
                int sum = 0;
                for(int j = 0; j < M; j++) {
                    sum += a[i][j];
                }
                max = Math.max(max, sum);
            }
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                int sum = 0;
                for(int j = 0; j < M; j++) {
                    sum += a[i][j];
                }
                if(sum == max){
                    cnt++;
                }
            }

            System.out.println("#" + t + " " + cnt + " " + max);
        }
    }
}
