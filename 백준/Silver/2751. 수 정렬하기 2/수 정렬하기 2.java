import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        //int형 배열로 Arrays.sort를 사용하면 int형은 Dual-Pivot Quicksort를 사용한다.
        //Dual-Pivot Quicksort의 최악 시간 복잡도는 N^2이므로 Tim sort를 사용하기 위해
        //Integer형이 필요하므로 ArrayList를 사용한다.
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            int num  = sc.nextInt();
            al.add(num);
        }
        Collections.sort(al);    //ArrayList의 정렬 Collections.sort 사용
        for(int value : al) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
    }
}
