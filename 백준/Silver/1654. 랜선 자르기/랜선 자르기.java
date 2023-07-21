import java.util.Scanner;

public class Main {

    static int calculateCount(int[] lengths, long cutLength) {
        int cnt = 0;
        for (int i=0; i<lengths.length; i++){
            cnt += lengths[i] / cutLength;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] len = new int[k];
        //k개의 랜선을 가지고 같은 길이의 n개 이상의 랜선을 만들 때 랜선의 최대 길이
        for (int i = 0; i < k; i++)
            len[i] = sc.nextInt();

        long l = 1, r = (1L << 31) - 1, ans = 0;
        while (l <= r) {
            long m = (l + r) / 2;
            if(calculateCount(len, m) >= n){
                ans = m;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        System.out.println(ans);



    }
}
