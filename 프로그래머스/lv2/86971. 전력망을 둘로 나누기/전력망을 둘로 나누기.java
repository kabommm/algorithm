import java.util.ArrayList;

class Solution {
    
    //변수 선언
    static ArrayList<Integer>[] graph;
    static int min;
    
    static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;    //노드 개수를 세는 변수
 
        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
 
        return cnt;
    }
    
    //메인 함수
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];   //그래프의 인접 리스트를 저장하는 배열
        min = Integer.MAX_VALUE;    //트리의 최소 크기
 
        // 그래프 ArrayList 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
 
        // 양방향 간선 추가
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            boolean[] visited = new boolean[n + 1];

            // 해당 간선을 그래프에서 제거
            //Arraylist에서 Integer객체를 제거해야 하므로 int -> Integer로 변환
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
 
            int cnt = dfs(1, visited); // 임의의 시작점에서 dfs 탐색
            // 그룹의 노드 개수 차이를 구하고, 최소 트리 크기인 min을 갱신
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
 
            // 그래프에 다시 간선 추가
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
 
        return min;
    }
}