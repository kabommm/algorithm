class Solution {
    
    //변수 선언
    static boolean[] visited;   //방문배열  
    static int answer;  //답
    
    //dfs함수
    public void dfs(int depth, int limit, int[][] dungeons){  
        for (int i = 0; i < dungeons.length; i++){  
            //방문하지 않았거나 피로도가 남았다면
            if (!visited[i] && dungeons[i][0] <= limit) {  
                visited[i] = true;  //방문처리  
                dfs(depth + 1, limit - dungeons[i][1], dungeons);
                visited[i] = false;  
            }
             
        }  
        answer = Math.max(answer, depth);  
    } 
    //메인 함수
    public int solution(int k, int[][] dungeons) {  //[최소 피로도,소모 피로도]
        visited = new boolean[dungeons.length];  
        
        dfs(0, k, dungeons);    //시작점, 입력받은 k, 입력받은 배열
        return answer;
    }
}