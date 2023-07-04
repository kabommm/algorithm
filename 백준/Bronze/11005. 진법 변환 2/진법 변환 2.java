import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //10진수
        int B = sc.nextInt();   //B진법

        String num = Integer.toString(N,B);

        System.out.println(num.toUpperCase());

    }
}
