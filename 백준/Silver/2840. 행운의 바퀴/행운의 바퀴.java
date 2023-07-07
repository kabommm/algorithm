import java.util.Arrays;
import java.util.Scanner;

//이해 안됨
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //n칸
        int k = sc.nextInt();   //k번 돌림

        char arr[] = new char[n];
        Arrays.fill(arr, '?');  //배열의 원소를 모두 ?으로 채움
        int idx = 0;

        for(int i=0; i<k; i++){
            int s = sc.nextInt();   //글자가 바뀐 횟수, 시계방향으로 s만큼 이동
            char ch = sc.next().charAt(0); //화살표가 가리키는 문자

            int nextIdx = ((idx-s) % n + n) % n;  //이동한 칸의 인덱스, 음수 반환을 방지해 +n후에 n으로 나눔
            if(arr[nextIdx] == '?'){
                arr[nextIdx] = ch;
            }else if(arr[nextIdx] != ch){   //?도 아니고 ch가 아니면
                System.out.println("!");
                return; //종료
            }
            idx = nextIdx;
        }
        boolean[] used = new boolean[26];
        for(int i =0; i<n; i++){
            if(arr[i] == '?'){
                continue;
            }
            if(used[arr[i] -'A']){
                System.out.println("!");
                return;
            }
            used[arr[i] - 'A'] = true;
        }

        for(int i=0; i<n; i++){
            System.out.print(arr[(idx+i) % n]);
        }

    }
}
