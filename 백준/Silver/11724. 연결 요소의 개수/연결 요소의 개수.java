import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] graph;
    static boolean visited[];
    static int answer;

    static void dfs(int node){
        visited[node] = true;
        for(int i=1; i <= n; i++){
            if(graph[node][i] == 1 && !visited[i]){
                //연결이 되어있는데 방문한 적이 없다면
                dfs(i);

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //정점의 개수
        m = sc.nextInt();   //간선의 개수

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            int u  = sc.nextInt();
            int v  = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }

        }
        System.out.println(answer);
    }
}
