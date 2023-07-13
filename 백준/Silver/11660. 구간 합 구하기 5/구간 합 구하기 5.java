import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //(n,n)의 크기
        int m = sc.nextInt();

        int arr[][] = new int[n+1][n+1];
        int ans[][] = new int[n+1][n+1];    //구간 합 배열
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                ans[i][j] = ans[i-1][j] + ans[i][j-1] - ans[i-1][j-1] + arr[i][j];
            }
        }
        //시간초과 때문에 BufferedWriter 출력 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<m; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            //arr[x1][y1]~ arr[x2][y2] 합
            //필요한 값이 모두 있는 누적합(x2, y2)에서 불필요한 값이 있는 누적합(x1-1,y2)(x2, y1-1)을 빼고
            //중복에서 제외된 값을 더해준다.(x1-1,y1-1)
            bw.write(ans[x2][y2] - ans[x1 - 1][y2] - ans[x2][y1 - 1] + ans[x1 -1][y1 - 1] + "\n");

        }
        bw.flush();
    }
}
