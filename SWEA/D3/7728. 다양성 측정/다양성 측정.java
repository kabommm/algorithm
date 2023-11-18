import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            String str = sc.next();
            int arr[] = new int[str.length()];

            for(int i=0; i<str.length(); i++){
                arr[i] = Integer.parseInt(str.charAt(i)+"");
            }

            Arrays.sort(arr);

            int answer = 1;

            for(int i=0; i<arr.length-1; i++){
                if(arr[i] != arr[i+1]){
                    answer++;
                }
            }
            System.out.println("#" + t + " " + answer);
        }
    }
}
