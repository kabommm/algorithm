import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            int arr[] = new int[5];
            for(int i=0; i<5; i++){
                int N = sc.nextInt();
                if(N<40){
                    arr[i] = 40;
                }else{
                    arr[i] = N;
                }
            }
            int sum = 0;
            for(int i=0; i<5; i++){
                sum += arr[i];
            }
            int answer = sum/5;

            System.out.println("#" + t + " " + answer);
        }
    }
}
