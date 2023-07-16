import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        //시간 복잡도 단축을 위해 A+B+C = X ->A + B = X - C
        //A+B의 집합을 만든다
        int sums[] = new int[n *(n+1) /2];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                sums[idx] = arr[i] + arr[j];
                idx++;
            }
        }
        Arrays.sort(sums);
        //모든 X - C에 대해 A+B를 확인한다
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int num = arr[i] - arr[j];
                //Arrays.binarySearch 는 num 과 일치하는 요소의 인덱스를 반환
                //실패하면 음수를 반환
                if(Arrays.binarySearch(sums, num) >= 0){
                    ans = Math.max(ans, arr[i]);
                }
            }
        }
        System.out.println(ans);
    }
}
