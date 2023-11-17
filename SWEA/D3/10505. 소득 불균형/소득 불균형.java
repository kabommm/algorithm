
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            int N = sc.nextInt();

            int sum = 0;
            int arr[] = new int[N];

            for(int i=0; i<N; i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            int avg = sum / N;
            int answer = 0;

            for(int i=0; i<N; i++){
                if(arr[i]<=avg){
                    answer++;
                }
            }


            System.out.println("#" + t + " " + answer);
        }
    }
}
