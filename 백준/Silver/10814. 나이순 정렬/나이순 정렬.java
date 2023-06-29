import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        String arr[][] = new String[N][2];
        
        for(int i=0; i<N; i++){
            String age  = sc.next();    //나이
            String name  = sc.next();   //이름
            arr[i][0] = age;
            arr[i][1] = name;
        }
        //단순 배열의 원소가 아닌 배열의 특정 부분(이름)에 따라 정렬해야 하므로 오름차순 식을 사용한다(람다식 표현)
        Arrays.sort(arr, (s1, s2) -> Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]) );    
       
        for(int i=0; i<N; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
