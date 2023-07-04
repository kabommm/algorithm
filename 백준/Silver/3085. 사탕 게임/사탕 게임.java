import java.util.Scanner;

public class Main {
    public static void swap(char[][] map, int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }
    public static int maxRow(char[][] map) {
        int maxRow = 0;
        for(int i=0; i< map.length; i++){
            int len = 1;
            for(int j = 1; j< map.length; j++ ){
                if(map[i][j] == map[i][j-1]){
                    len++;
                }else{
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }
    public static int maxColumn(char[][] map) {
        int maxColumn = 0;
        for(int i=0; i< map.length; i++){
            int len = 1;
            for(int j = 1; j< map.length; j++){
                if(map[j][i] == map[j-1][i]){
                    len++;
                }else{
                    maxColumn = Math.max(maxColumn, len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }
        return maxColumn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char map[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            String str = sc.next();
            for(int j=0; j<n; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            //상하좌우 비교 -> 문자가 다르면 교환
            for(int j=0; j<n; j++) {
                if(j+1 < n && map[i][j] != map[i][j+1]){
                    swap(map, i, j, i, j+1);
                    answer = Math.max(answer, Math.max(maxColumn(map), maxRow(map)));
                    swap(map, i, j, i, j+1);
                }
                if(i+1 < n && map[i][j] != map[i+1][j]){
                    swap(map, i, j, i+1, j);
                    answer = Math.max(answer, Math.max(maxColumn(map), maxRow(map)));
                    swap(map, i, j, i+1, j);
                }
            }
        }
        System.out.println(answer);
    }
}
