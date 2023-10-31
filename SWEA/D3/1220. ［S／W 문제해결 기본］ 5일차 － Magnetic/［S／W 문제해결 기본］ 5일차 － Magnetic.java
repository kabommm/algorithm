import java.util.*;
public class Solution {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        StringBuffer sb = new StringBuffer();

        for(int t=1; t<=10; t++) {

            int num = sc.nextInt(); //100 으로 고정
            int map[][] = new int[100][100];

            for(int i=0; i<num; i++){
                for(int j=0; j<100; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int answer = solve(num, map);

            System.out.println("#"+t + " " + answer);
        }
    }

    static int solve(int N, int map[][]){

        int count = 0;
        //1=빨간색, 2=파란색
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++)
            {
                if(map[j][i] == 0 || map[j][i] == 2){
                    continue;
                }
                //빨간색
                for(int k=j+1; k<N; k++){
                    j = k;
                    if(map[k][i] == 2){ //파란색을 마주하면
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}

