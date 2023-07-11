import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        //이중 반복문을 하면 시간초과가 나므로 대신 boolean 배열을 통해 체크
        boolean exist[] = new boolean[1000001]; //각 숫자를 나타내는 boolean배열
        for(int i=0; i<arr.length; i++){
            exist[arr[i]] = true;
        }
        for(int i=0; i<n; i++){
            int pair = x - arr[i];
            if(0<= pair && pair <= 1000000){    //범위 주의!!
                if(exist[pair]){    //해당숫자가 배열에 존재했다면 answer++
                    answer++;
                }
            }
        }
        System.out.println(answer/2);   //쌍이라 중복이 있으므로 2분의1
    }
}
