import java.util.Scanner;

public class Main {

    static boolean isPossible(int[] useAmounts, int drawAmount, int maxDrawCount) {
        int drawCount = 1;
        int currentAmount = drawAmount;
        for (int i =0; i< useAmounts.length; i++) {
            if (useAmounts[i] > drawAmount){
                return false;
            }
            if (currentAmount < useAmounts[i]) {
                if (drawCount == maxDrawCount){
                    return false;
                }
                drawCount++;
                currentAmount = drawAmount;
            }
            currentAmount -= useAmounts[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] useAmounts = new int[n];
        for (int i = 0; i < n; i++){
            useAmounts[i] = sc.nextInt();    
        }

        int l = 1, r = n * 10000, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(useAmounts, mid, m)){
                ans = mid;
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        System.out.println(ans);

    }
}
