import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[] = new int[N+M+1];

            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    arr[i+j]++;
                }
            }

            int max = 0;
            for(int i = 2; i <= N+M; i++) {
                max = Math.max(arr[i], max);
            }

            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 2; i <= N+M; i++) {
                if(arr[i] == max){
                    list.add(i);
                }
            }

            System.out.print("#" + t);
            for(int i=0; i<list.size(); i++){
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        }
    }
}