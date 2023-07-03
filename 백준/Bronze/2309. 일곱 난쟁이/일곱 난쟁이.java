import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[9];
        int sum = 0;

        for(int i=0; i<9; i++){
            int n = sc.nextInt();
            arr[i] = n;
            sum += n;
        }
        loop:
        for(int i=0; i< arr.length-1; i++){
            for(int j=i+1; j< arr.length; j++){
                if(sum - (arr[i]+arr[j]) == 100){
                    arr[i] = 0;
                    arr[j] = 0;
                    break loop; //loop 가 있는 곳으로 탈출
                }
            }
        }
        Arrays.sort(arr);
        for(int i=2; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
