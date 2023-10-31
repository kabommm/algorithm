import java.util.*;

public class Main {

    public static int count;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int[] arr = new int[num];
        count =0;
        nQueen(0, arr, num);
        System.out.println(count);

    }

    private static void nQueen(int level, int[] row, int N) {
        if (level == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            row[level] = i;

            if (isPromising(level, row)){
                nQueen(level + 1, row, N);
            }
        }
    }

    private static boolean isPromising(int next, int[] row) {
        for (int i = 0; i < next; i++) {
            if (row[i] == row[next] || Math.abs(row[i]-row[next]) == next - i){
                return false;
            }
        }
        return true;
    }
}
