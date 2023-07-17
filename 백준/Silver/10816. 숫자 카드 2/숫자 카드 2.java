import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static int findLowerBound(int arr[], int value){
        int l =  0;
        int r = arr.length - 1;
        int ans = arr.length;
        while(l <= r) {
            int mid = (l+r)/2;
            if(arr[mid] < value) {
                l = mid + 1;
            }else{
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
    static int findUpperBound(int arr[], int value){
        int l =  0;
        int r = arr.length - 1;
        int ans = arr.length;
        while(l <= r) {
            int mid = (l+r)/2;
            if(arr[mid] <= value) {
                l = mid + 1;
            }else{
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
//        int arr[] = new int[n];
//        for(int i=0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr);
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int m = sc.nextInt();
//        for(int i=0; i<m; i++){
//            int num = sc.nextInt();
//            int lowerBound = findLowerBound(arr, num);
//            int upperBound = findUpperBound(arr, num);
//        bw.write(upperBound- lowerBound + " ");
//        }
//        bw.flush();


        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            map.put(num,map.getOrDefault(num,0)+ 1);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int num = sc.nextInt();
            bw.write(map.getOrDefault(num,0)+ " ");
        }
        bw.flush();
    }
}
