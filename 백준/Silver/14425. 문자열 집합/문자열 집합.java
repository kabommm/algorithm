import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean isExist(String[] arr, String key) {

        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            //두 문자열이 같으면 0, 해당 문자열이 인수로 전달된 문자열보다 작으면 음수, 크면 양수 반환
            int result = arr[mid].compareTo(key);

            // result 값이 음수라면 -> 더 앞에 위치
            if(result < 0) {
                left = mid + 1;
            }else if(result > 0) {  // result 값이 양수라면 -> 더 뒤에 위치
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
        int m = sc.nextInt();
        int ans = 0;    //정답 갯수
        String arr[] = new String[n];

        for(int i=0; i<n; i++){
            String str = sc.next();
            arr[i] = str;
        }
        Arrays.sort(arr);   //이분 탐색을 위해서는 정렬되어 있어야 함

        for(int i =0; i<m; i++){
            String str = sc.next();
            if(isExist(arr,str)){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
