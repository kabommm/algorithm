import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean binarySearch(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            // key 값이 중간 위치의 값보다 클 경우
            if(arr[mid] < key) {
                left = mid + 1;
            }else if(arr[mid] > key) {  // key 값이 중간 위치의 값보다 작을 경우
                right = mid - 1;
            }else { // key 값과 중간 위치의 값이 같을 경우
                return true;
            }
        }
        // 값이 없으면
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        Arrays.sort(arr);   //이분 탐색을 위해서는 정렬되어 있어야 함
        int m = sc.nextInt();
        for(int i =0; i<m; i++){
            int num = sc.nextInt();
            if(binarySearch(arr,num) == true){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }
}
