import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        String arr[] = new String[N];

        for(int i=0; i<N; i++){
            arr[i]  = sc.next();
        }
        //단순 배열의 원소가 아닌 원소의 길이에 따라 정렬해야 하므로 오름차순 식을 사용하고 같은 경우는 조건문에서 compareTo 함수를 이용한다(람다식 표현)
        Arrays.sort(arr, (s1, s2) -> {
            // 단어 길이가 같을 경우
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            // 그 외의 경우
            else {
                return s1.length() - s2.length();
            }
        });

        System.out.println(arr[0]);

        for (int i = 1; i < N; i++) {
            // 중복되지 않는 단어만 출력
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
