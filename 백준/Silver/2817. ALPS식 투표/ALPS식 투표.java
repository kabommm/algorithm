import java.util.Scanner;

public class Main {
    static class Score{
        Score(int staffIndex, double scr) {
            this.staffIndex = staffIndex;
            this.scr = scr;
        }
        int staffIndex;
        double scr;
    }

    public static void sort(Score[] arr) {  //내림차순 정렬함수
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].scr > arr[j].scr) {
                    Score cur = arr[i];
                    for (int k = i; k > j; k--)
                        arr[k] = arr[k - 1];
                    arr[j] = cur;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();   //참가자 수
        int n = sc.nextInt();   //스태프 수

        //득표가 전체의 5프로 미만이면 바로 제외
        boolean arr[] = new boolean[26];    //스태프의 이름(알파벳 크기 집합)
        int staffCount[] = new int[26];   //득표수
        int count = 0;

        for(int i=0; i<n; i++){
            String str = sc.next(); //스태프 이름
            int vote = sc.nextInt();   //받은 득표수

            if(vote >= x * 0.05){   //득표수가 참가자의 5프로 이상이면
                int idx = str.charAt(0) - 'A';
                arr[idx] = true;    //참가 가능한 스태프이므로 그 위치가 참
                staffCount[idx] = vote; //받은 득표수 기록
                count++;
            }
        }

        //남은 스태프마다 받은 득표수를 1~14로 나눈 점수 집합을 구한다.
        Score[] scores = new Score[count * 14];
        int index = 0;
        for (int i = 0 ; i < 26; i++) {
            if (arr[i]) {   //arr의 원소가 true 이면 즉 득표를 받은 유효한 스태프이면
                for (int j = 1; j <= 14; j++){  //1부터 14까지 나눈 점수를 배열에 차례로 저장
                    scores[index] = new Score(i, (double)staffCount[i] / j); // 실수형
                    ++index;
                }
            }
        }

        //전체 점수 집합에서 점수가 큰 1~14번째 스태프에게 칩을 1개씩 지급
        sort(scores);   //내림차순 정렬함수

        int[] ans = new int[26];
        for (int i = 0; i < 14; i++){
            ans[scores[i].staffIndex]++;
        }

        //스태프 이름에 대해 사전순으로 후보 스태프와 받은 칩의 수를 출력
        for (int i = 0; i < 26; i++) {
            if (arr[i]){
                System.out.println((char)(i + 'A') + " " + ans[i]);
            }
        }
    }
}
