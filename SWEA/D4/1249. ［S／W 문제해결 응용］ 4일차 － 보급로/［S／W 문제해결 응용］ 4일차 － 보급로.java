import java.util.*;

class Pos{
    int x;
    int y;
    int dis;

    Pos(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class Solution {

    static int[] xdir = {-1, 1, 0, 0};
    static int[] ydir = {0, 0, -1, 1};
    static int[][] map;
    static int num;
    
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int t=1; t<=n; t++) {

            num = sc.nextInt(); //지도의 크기 numXnum
            map = new int[num][num];

            for(int i=0; i<num; i++){
                String str = sc.next();
                String sarr[] = str.split("");
                for(int j=0; j<num; j++){
                    map[i][j] = Integer.parseInt(sarr[j]);
                }
            }

            int answer = bfs();

            System.out.println("#"+t + " " + answer);
        }
    }

    private static int bfs(){

        int[][] visited = new int[num][num];
        for(int i=0;i<num;i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        Queue<Pos> q = new LinkedList<>();

        visited[0][0] = 0;
        q.offer(new Pos(0,0,0));
        int dis = Integer.MAX_VALUE;

        while(!q.isEmpty()){    //큐가 빌때까지
            Pos p = q.poll();
            //도착지에 도착한 경우 최소값과 비교해서 더 작다면 갱신
            if(p.x == num-1 && p.y == num-1) {
                dis = Math.min(dis, p.dis);
                continue;
            }

            for(int i=0; i<4; i++) {
                int nx = p.x + xdir[i];
                int ny = p.y + ydir[i];
                if(0 <= nx && nx < num && 0 <= ny && ny < num) {
                    int distance = p.dis + map[nx][ny];
                    // 만약 이미 지나갔던 최단비용보다 더 작은 비용으로 지나갈 수 있다면
                    // 값을 갱신해주고 Queue에 넣어주는 부분
                    if(visited[nx][ny] > distance) {
                        visited[nx][ny] = distance;
                        q.add(new Pos(nx, ny, distance));
                    }
                }
            }
        }
        return dis;
    }
}


