import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int ansLength = n + 1;  //최소길이 갱신을 위해 n+1로 설정
        int nextIndex = 0;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {   //0부터 시작~n-1부터 시작
            //합 s보다 작고 인덱스가 끝 크기 이하일 떄까지 반복
            while(currentSum < s && nextIndex < n){
                currentSum += arr[nextIndex++];
            }
            if(currentSum >= s){    //합 s를 넘어서면
                ansLength = Math.min(ansLength, nextIndex - i);//최소길이 갱신
            }
            currentSum -= arr[i];   //총합에서 현재 배열의 값을 빼주고 새로 시작
        }
        if(ansLength > n){  //n보다 크면 불가능 -> 0출력
            ansLength = 0;
        }
        System.out.println(ansLength);

    }
}
