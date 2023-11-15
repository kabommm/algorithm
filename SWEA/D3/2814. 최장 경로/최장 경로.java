import java.util.Scanner;

public class Solution {

    public static int[][] map;
    public static boolean[] visited;
    public static int answer;
    public static int n;

    public static void dfs(int cnt, int v) {
        visited[v] = true;

        for(int i = 0; i < n+1; i++) {
            if(map[v][i] == 1 && !visited[i]) {
                dfs(cnt+1, i);
                visited[i] = false;
            }
        }
        answer = Math.max(cnt, answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            answer = Integer.MIN_VALUE;
            int N = sc.nextInt();   //정점
            int M = sc.nextInt();   //간선
            n = N;

            map = new int[N+1][N+1];
            visited = new boolean[N+1];

            for(int i = 0; i < M; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                map[n1][n2] = 1;
                map[n2][n1] = 1;
            }

            for(int i = 1; i < N+1; i++) {
                dfs(1, i);
                visited[i] = false;
            }

            System.out.println("#" + t + " " + answer); //경로의 길이 = 경로 상에 등장하는 정점의 개수
        }
    }
}
