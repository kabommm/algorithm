import java.util.Scanner;

public class Main{
    static int map[][]; // 각 정점간 탐색 경로 저장
    static boolean visit[]; // 정점 탐색여부 체크
    static int count = 0;   // 정점과 연결된 바이러스 걸리는 컴퓨터 수

    public static void dfs(int i) {
        visit[i] = true;    // 방문처리 후

        for(int j=0; j<map[i].length; j++) {   //인접행렬을 탐색
            // 연결된 정점이면서 방문하지 않은 경우
            if(map[i][j] == 1 && !visit[j]) {// 연결된 정점이면서 방문하지 않은 경우
                dfs(j); // DFS 수행
                count++;   // 감염된 컴퓨터 수 증가, 여기엔 최초 방문 1번 컴퓨터도 포함된다.
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();  //컴퓨터의 수
        int m = sc.nextInt(); //연결되어 있는 컴퓨터 쌍의 수
        map = new int[n+1][n+1];	// 각 정점간 탐색 경로를 저장할 배열
        visit = new boolean[n+1];	// 정점의 탐색 여부 체크
        for(int i=0; i<m; i++){ // 인접행렬을 통한 연결정보 저장
            int start  = sc.nextInt();
            int last  = sc.nextInt();
            map[start][last] = 1;
            map[last][start]= 1;
        }
        dfs(1);
        System.out.println(count);
    }
}
