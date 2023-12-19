import java.util.*;

public class Main {
    static StringBuilder sbD = new StringBuilder();
    static StringBuilder sbB = new StringBuilder();
    // 그래프의 정점 정보를 기록할 ArrayList
    static ArrayList<Integer>[] graph;
    static boolean visit[]; // 방문한 여부를 기록할 배열

    public static void dfs(int i) { //i는 시작 정점
        visit[i] = true;    // 방문처리
        sbD.append(i).append(" ");
        // 현재 위치한 정점이 갈 수 있는(인접한) 정점 리스트를 순회
        for(int y :  graph[i]) {
            if(!visit[y]){
                dfs(y);
            }
        }
    }

    public static void bfs(int i) { //i는 시작 정점
        visit[i] = true;    // 방문처리
        Queue<Integer> q = new LinkedList<>(); //LinkedList로 큐를 만든다.
        q.offer(i); //방문한 노드를 큐에 넣는다.

        while (!q.isEmpty()) {  //큐가 비어있을 떄 까지 반복
            i = q.poll(); //방문한 노드를 빼고
            sbB.append(i).append(" ");
            for(int y :  graph[i]) {
                //다음 갈 정점을 방문했었는지 체크
                if(!visit[y]){   //방문한 적이 없으면

                    q.offer(y);  //큐에 저장
                    visit[y] = true; //저장 후 방문 처리

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();  //정점의 수
        int m = sc.nextInt(); //간선의 수
        int r = sc.nextInt(); //시작 정점
        graph = new ArrayList[n+1];
        visit = new boolean[n+1];	 // 각 정점 방문 여부를 판단 할 배열

        // graph의 index를 정점의 개수만큼 만들어줌
        for(int i =0; i < n+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){ // 인접리스트 통한 연결정보 저장
            int start  = sc.nextInt();
            int last  = sc.nextInt();
            graph[start].add(last);
            graph[last].add(start);
        }
        // 오름차순을 위해 정렬
        for(int i = 1; i < n+1; i++) {
            Collections.sort(graph[i]);
        }
        // 깊이 우선 탐색 재귀 시작
        dfs(r);

        System.out.println(sbD);
        // 방문여부 배열을 BFS를 위해 다시 초기화
        visit = new boolean[n+1];
        // 깊이 우선 탐색 재귀 시작
        bfs(r);
        System.out.println(sbB);

    }
}
