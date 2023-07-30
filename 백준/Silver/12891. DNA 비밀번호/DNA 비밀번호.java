import java.util.Scanner;

public class Main {

    //문자를 축약된 index 로 변환하는 함수
    static int baseToIndex(char alp) {
        if (alp == 'A') return 0;
        else if (alp == 'C') return 1;
        else if (alp == 'G') return 2;
        else if (alp == 'T') return 3;
        return -1;
    }
    //최소개수를 만족하는지 체크
    static boolean isValidSequence(int[] baseCount, int[] minimumBaseCount) {
        for (int i = 0; i < baseCount.length; i++)
            if (baseCount[i] < minimumBaseCount[i])
                return false;   //하나라도 최소개수보다 작으면 false
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();

        //읽어들인 문자열을 문자 배열로 전환
        char[] sequence = sc.next().toCharArray();

        int[] minimumBaseCount = new int[4];
        for (int i = 0; i < 4; i++)
            minimumBaseCount[i] = sc.nextInt();

        int[] currentBaseCount = new int[4];
        for (int i = 0; i < P; i++)
            currentBaseCount[baseToIndex(sequence[i])]++;
        int ans = isValidSequence(currentBaseCount, minimumBaseCount) ? 1 : 0;

        //첫번째 인덱스를 버리고 다음 인덱스만 추가하는 식으로 중간의 정보를 가져가는 효율적인 순회
        for (int i = 1; i <= S - P; i++) {
            //첫번째 값 제거
            currentBaseCount[baseToIndex(sequence[i - 1])]--;
            //다음 값 추가
            currentBaseCount[baseToIndex(sequence[i + P - 1])]++;
            //4개의 값 배열이 최소개수를 만족한다면 정답+1
            if (isValidSequence(currentBaseCount, minimumBaseCount))
                ans++;
        }
        System.out.println(ans);
    }
}
