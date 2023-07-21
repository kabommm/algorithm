import java.util.Scanner;

public class Main {
    static boolean isPossible(int[] heights, int cutHeight, int thresholdHeight) {
        long sum = 0;   //잘린 나무의 합
        for (int i=0; i<heights.length; i++){
            if (heights[i] > cutHeight){
                sum += heights[i] - cutHeight;
            }
        }
        return sum >= thresholdHeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] h = new int[n];
        for (int i = 0; i < n; i++)
            h[i] = sc.nextInt();

        int l = 0, r = 1000000000, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(h, mid, m)) {
                ans = mid;
                l = mid + 1;    //절단기 높이를 높힌다
            }
            else{
                r = mid - 1;   //절단기 높이를 낮춘다
            }
        }
        System.out.println(ans);

    }
}
