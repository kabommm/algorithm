import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n+1]; //각 칸의 높이를 담을 배열
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();  //높이를 배열에 저장
        }
        //변화량 배열
        int delta[] = new int[n+2]; //b 가 마지막 순서일 경우 b+1이 초과를 방지하기 위해 n+2 크기
        //조교의 지시에 따른 변화랑을 배열에 저장
        for(int i=0; i<m; i++){
            int a = sc.nextInt();   //a 칸부터
            int b = sc.nextInt();   //b 칸까지
            int k = sc.nextInt();   //|k|만큼

            delta[a] += k;  //a~b 번째까지
            delta[b+1] -= k;    //b+1 번째부터는 다시 원복

        }
        int ans[] = new int[n+1];   //조교의 지시 결과 배열
        for(int i=1; i<=n; i++){
            ans[i] = ans[i-1] + delta[i];
        }
        for(int i=1; i<=n; i++){
            System.out.print(arr[i] + ans[i] + " ");
        }
    }
}
