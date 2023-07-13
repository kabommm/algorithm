import java.util.Scanner;

public class Main {
    //누적합 배열을 구하는 함수(map 배열)
    static int[][] getPrefixSum(char[][] map) {
        int[][] acc = new int[map.length][map[0].length];
        for (int i = 1; i < map.length; i++)
            for (int j = 1; j < map[0].length; j++) {
                int alive = (map[i][j] == '*' ? 1 : 0);
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + alive;
            }
        return acc;
    }
    //주위생명을 구하는 함수(현재 누적합 배열, 좌표i, 좌표j, 기준k)
    static int getRangeSum(int[][] acc, int r, int c, int k) {
        int r1 = Math.max(r - k, 1);    //최소 1
        int c1 = Math.max(c - k, 1);    //최소 1
        int r2 = Math.min(r + k, acc.length - 1);   //최대 r+k
        int c2 = Math.min(c + k, acc[0].length - 1);    //최대 c+k
        return acc[r2][c2] - acc[r1 - 1][c2] - acc[r2][c1 - 1] + acc[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        int k = sc.nextInt();   //주위 기준(2k+1)
        int a = sc.nextInt();   
        int b = sc.nextInt();

        char[][] map = new char[n + 1][m + 1];
        for(int i=1; i<=n; i++){
            String str = sc.next();
            for(int j=1; j<=m; j++){
                map[i][j] = str.charAt(j - 1);
            }
        }

        for(int l=0; l<t; l++){ //t 시간동안 반복
            int[][] acc = getPrefixSum(map);    //지금 시간의 누적합 배열
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= m; j++) {
                    int nearAlive = getRangeSum(acc, i, j, k);  //주위생명
                    if (map[i][j] == '*') {
                        nearAlive--;    //자기자신 제외
                        if (nearAlive < a || b < nearAlive)//(주위 생명 < a || b < 주위 생명)
                            map[i][j] = '.';    //죽음
                    }//a <= 주위 생명 <= b -> 다음단계
                    else if (a < nearAlive && nearAlive <= b)//생명이 없음 && a < 주위 생명 <= b
                        map[i][j] = '*';    //탄생
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }
}
