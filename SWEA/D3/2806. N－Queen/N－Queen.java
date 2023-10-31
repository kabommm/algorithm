import java.util.*;

public class Solution {

    public static int[] arr;    // 퀸의 위치
    public static int count;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            int num = in.nextInt();
            arr = new int[num];
            count =0;
            nQueen(num, 0);
            System.out.println("#" + i + " " + count);

        }

    }

    public static void nQueen(int depth, int curr) {
        boolean isPossible;		//놓을 수 있는가

        // 모든 원소를 다 채운 상태면 count 증가, 반환
        if (depth == curr) {
            count++;
            return;
        }

        for (int i = 0; i < depth; i++) {   // [curr][i]에 퀸을 놓을 수 있는지 확인
            isPossible = true;

            for (int j = 0; j < curr; j++) {
                if (arr[j] == i || i == arr[j]+(curr - j) || i == arr[j]-(curr - j)) {		//직선, 대각선 확인
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                arr[curr] = i;
                nQueen(depth, curr + 1);
            }
        }

    }
}
