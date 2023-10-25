import java.util.*;
public class Solution {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[8];

        for(int t=1; t<=10; t++) {
            int T = sc.nextInt();   //번호

            for (int i = 0; i < 8; i++) { //8개의 숫자 입력
                int num = sc.nextInt();
                arr[i] = num;
            }

            int value = 1;
            while (value != 0) {  //value 가 0이면 종료

                for (int i = 1; i < 6; i++){    //한바퀴
                    value = arr[0] - i;
                    if (value < 0) {  //arr[0]-2 가 음수이면 0으로 처리
                        value = 0;
                    }

                    for (int j = 0; j < 7; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[7] = value;
                    if (value == 0){
                        break;
                    }
                }

            }
            System.out.print("#" + t);
            for(int i=0; i<8; i++){
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
}

