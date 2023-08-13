import java.util.*;
class Solution {
    //1. 변수 선언
    int answer = 0;
    int[][] visited;    //방문 배열
    int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};    //방향확인 배열
    //2. 함수 구현
    public void bfs(int[][] maps, int[][] visited){
        visited[0][0] = 1;  //시작점은 방문처리하고 시작
        int[] start ={0, 0};    //시작 정점 (0,0)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start); // 큐에 시작 정점 추가
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();   //큐에서 꺼낸값
            int cX = current[0];    //꺼낸값의 0에 해당하는 것 = x좌표
            int cY = current[1];    //꺼낸값의 1에 해당하는 것 = y좌표
            
            for(int i = 0; i < 4; i++){ //현재 좌표+상하좌우 한번 씩 4번 반복
                int nX = cX + d[i][0];
                int nY = cY + d[i][1];
                //좌표가 맵에서 벗어날 경우
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)          {
                    continue;             
                }//아직 방문x && 벽이 아니면 
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    int[] restart ={nX, nY};
                    visited[nX][nY] = visited[cX][cY] + 1;  //좌표가 지나간 수+1
                    queue.add(restart);
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        //maps와 똑같은 크기의 방문 배열을 생성
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited); //maps와 방문배열을 파라미터로 받는 함수 bfs
        answer = visited[maps.length-1][maps[0].length-1];  //우측맵 하단의 값
        
        if(answer == 0){    //상대 팀 진영에 도착할 수 없을 때는 -1을 return
            answer = -1;
        }
        return answer;
    }
}