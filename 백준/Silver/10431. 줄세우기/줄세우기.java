import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        //두 원소를 비교하여 나보다 큰 사람없으면 그대로
        //내 앞에 나보다 큰 사람 있으면 그 큰사람중 제일 작은사람 앞
        //그럼 그 제일 작은사람 부터 뒤까지 뒤로 1칸씩 이동
        //총 인원이 이것을 반복했을때 뒤로 물러서는 횟수는?
        for(int i=0; i<p; i++){
            int t = sc.nextInt();
            int arr[] = new int[20];
            int answer = 0;
            for(int j=0; j<20; j++) {
                int mm = sc.nextInt();
                arr[j] = mm;
            }
            //숫자가 들어왓을 때 현재 줄에 나보다 큰 학생의 수=이동횟수
            for(int j=0; j<20; j++){
                for(int k=0; k<j; k++) {
                    if (arr[k] > arr[j]) {
                        int num = arr[j];
                        //찾았다면 그 학생 앞에 서고
                        //그 학생부터 뒤까지 한칸씩 뒤로 이동
                        for (int l = j; l > k; l--) {
                            arr[l] = arr[l - 1];
                            answer++;
                        }
                        arr[k] = num;
                        break;
                    }
                }
            }
            System.out.println(t + " " + answer);
        }


    }

}
