import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n+1];

        for(int i=1; i<=n; i++){ //길이가 n인 수열
            int num = sc.nextInt();
            arr[i] = num;
        }
        for(int i=1; i<=n; i++){ //길이가 n인 수열
            arr[i] = arr[i-1] ^ arr[i]; //XOR 연산자를 통해 연산
        }
        //쿼리의 답은 s~e 까지의 수열을 모두 XOR 한 값
        //XOR: 같으면 0 다르면 1
        int ans = 0; //쿼리의 답
        int temp = 0;
        for(int i=0; i<q; i++){ //q개의 쿼리
            int s = sc.nextInt();   //수열의 s번째
            int e = sc.nextInt();   //수열의 e번째
            //s~e까지 XOR 한 값
            temp = arr[e] ^ arr[s-1];  //e~s까지 XOR 한 값
            ans = ans ^ temp;
        }
        System.out.println(ans);


    }
}
