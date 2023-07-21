import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int calculateCount(int[] xs, int distance) {
        int pastX = xs[0];
        int cnt = 1;
        for (int i = 1; i < xs.length; i++){
            if(xs[i] - pastX >= distance){
                pastX = xs[i];
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] xs = new int[n];
        for (int i = 0; i < n; i++)
            xs[i] = sc.nextInt();

        Arrays.sort(xs);

        int l = 1, r = xs[n - 1] - xs[0], ans = -1;
        while(l <= r){
            int m = (l + r) / 2;
            if(calculateCount(xs, m) >= c){
                ans = m;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        System.out.println(ans);
    }
}
