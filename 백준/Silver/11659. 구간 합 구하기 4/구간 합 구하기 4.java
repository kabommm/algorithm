import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //수의 개수
        int m = sc.nextInt();   //합을 구해야 하는 횟수
        int arr[] = new int[n];
        //이중 반복문으로는 시간초과 -> 누적합 이용
        int sum = 0;
        int stack[] = new int[n];   //누적합 계산을 위한 배열
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            arr[i] = num;
            sum += arr[i];
            stack[i] = sum;
        }
        // 5 9 12 14 15
        for(int i=0; i<m; i++){
            int start = sc.nextInt();   //여기부터
            int last = sc.nextInt();    //여기까지의 합
            if(start == 1){ //인덱스 음수 방지
                System.out.println(stack[last-1]);
            }else{
                System.out.println(stack[last-1] - stack[start-2]);
            }
        }

    }
}
