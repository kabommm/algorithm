import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //길이 w가 같으면 더 아래층 방이 우선순위
        //이차원 배열로 치면 arr[H][0]~arr[0][0]까지 채우고
        //그 다음은 arr[H][1]~arr[0][1]순으로 채운다.
        for(int i=0; i<t; i++){
            int h = sc.nextInt();   //층 수
            int w = sc.nextInt();   //방 수
            int n = sc.nextInt();   //몇 번째 손님

            if(n % h == 0) {
                System.out.println((h * 100) + (n / h));

            }else{
                System.out.println(((n % h) * 100) + ((n / h) + 1));
            }
        }
    }
}
