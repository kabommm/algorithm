import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){    //순차적으로 들어오는 수를 배열에 담는다.
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);   //오름차순 정렬

        int ansDiff = arr[n - 1] - arr[0];  //가장 큰 차이(가장 큰 원소 - 가장 작은 원소)
        int rightIndex = 0;
        for (int leftIndex = 0; leftIndex < n; leftIndex++) {
            //차이가 m 이상이 아니면서 맨 끝의 원소에 다다르기 전까지
            while (arr[rightIndex] - arr[leftIndex] < m && rightIndex < n - 1) {
                rightIndex++;
            }
            int diff = arr[rightIndex] - arr[leftIndex];
            if (diff >= m) {    //차이가 m 이상이 되면
                ansDiff = Math.min(ansDiff, diff); //반환할 차이를 갱신
            }
        }
        System.out.println(ansDiff);
    }
}
