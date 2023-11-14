import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            String answer = "Possible";

            int N = sc.nextInt();   //사람 수
            int M = sc.nextInt();   //M 초의 시간동안
            int K = sc.nextInt();   //K 개를 만든다.

            int arr[] = new int[N];
            for(int i=0; i<N; i++){
                int sec = sc.nextInt(); //몇 초에 도착
                arr[i] = sec;
            }

            Arrays.sort(arr);

            int sum = 0;

            for(int i=0; i<arr.length; i++) {
                sum = (arr[i] / M) * K;
                if(sum-i-1 < 0 ) {
                    answer = "Impossible";
                    break;
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
