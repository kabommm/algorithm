import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Meeting{
        int start;
        int end;
        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //정렬 시 두가지 요건이 필요하므로 이차원 배열 선언
        int arr[][] = new int[n][2];
        //(또는 두 필드를 만들어 사용하는 클래스형 배열 선언
        Meeting meetings[] = new Meeting[n];

        for(int i=0; i<n; i++){
//            arr[i][0] = sc.nextInt();	// 시작시간
//            arr[i][1] = sc.nextInt();	// 종료시간
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }
        //종료시간이 빠른 순으로 정렬
        //종료 시간이 같다면 시작시간이 빠른순

        //2차원 배열 람다식 정렬
//        Arrays.sort(arr, (o1, o2) -> {
//            if(o1[1] == o2[1]) {
//                return o1[0] - o2[0];
//            }
//            return o1[1] - o2[1];
//        });

        //커스텀 정렬 람다식
        Arrays.sort(meetings, (o1, o2) -> {
            if(o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int answer = 0; //회의 횟수
        int time = 0;   //회의 끝나는 시간

        for(int i = 0; i < n; i++) {
            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
//            if(time <= arr[i][0]) {
//                time = arr[i][1];
//                answer++;
//            }
            if(time <= meetings[i].start) {
                time = meetings[i].end;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
