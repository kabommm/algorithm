import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int ans = 0;

        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);   //1 2 3 4 5 7

        int start = 0;
        int end = arr.length-1;


        while(start < end){

            if(arr[start]+arr[end] == M){
                ans++;
                start++;
                end--;
            }else if(arr[start]+arr[end] > M){
                end--;
            }else{
                start++;
            }
        }

        System.out.println(ans);
    }
}
