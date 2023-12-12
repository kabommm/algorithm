import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String str = sc.next();
        //String str = Integer.toString(B);
        
        int sum=0;
        for(int i=0; i<A; i++){
            sum += str.charAt(i) -'0';
        }
        System.out.print(sum);
    }
}