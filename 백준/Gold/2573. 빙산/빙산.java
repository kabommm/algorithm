import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] graph;
    static boolean visited[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Ice> list;

    static int dfs(int r, int c){
        visited[r][c] = true;
        int cnt = 1;
        for(int i=0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(visited[nr][nc]){
                continue;
            }
            cnt += dfs(nr,nc);
        }
        return cnt;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];
        list = new ArrayList<>();


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j] >0){
                    list.add(new Ice(i,j,graph[i][j]));
                }
                visited[i][j] = true;
            }
        }

        for(int i = 1; !list.isEmpty(); i++){
            for(int j =0; j<list.size(); j++){
                for(int k=0; k<4; k++){
                    int nr = list.get(j).row + dr[k];
                    int nc = list.get(j).col + dc[k];
                    if(graph[nr][nc] == 0){
                        list.get(j).height--;
                    }
                }
            }

            for(int j =0; j<list.size(); j++){
                if(list.get(j).height <= 0 ){
                    graph[list.get(j).row][list.get(j).col] = 0;
                    list.set(j, list.get(list.size() -1 ));
                    list.remove(list.size() -1);
                    j--;
                }else{
                    visited[list.get(j).row][list.get(j).col]= false;
                }
            }

            if(list.size() > 0 && dfs(list.get(0).row, list.get(0).col) != list.size()){
                System.out.println(i);
                System.exit(0);
            }
        }

        System.out.println(0);

    }
}

class Ice{
    int row;
    int col;
    int height;

    public Ice(int r, int c, int h){
        row = r;
        col = c;
        height = h;
    }
}

