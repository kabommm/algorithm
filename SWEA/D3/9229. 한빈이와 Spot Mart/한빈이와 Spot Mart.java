import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            int N = sc.nextInt();   //과자 봉지 개수
            int M = sc.nextInt();   //무게 제한

            int arr[] = new int[N];
            for(int i=0; i<N; i++){
                int snack = sc.nextInt();
                arr[i] = snack;
            }

            int answer = -1;
            int max = 0;

            for(int i=0; i<arr.length-1; i++){
                for(int j=i+1; j< arr.length; j++){
                    if(arr[i]+arr[j]<=M && max < arr[i]+arr[j]){    //주게를 초과하지 않는 선에서 max 보다 크면
                        max = Math.max(arr[i]+arr[j],max);
                        answer = max;
                    }
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
