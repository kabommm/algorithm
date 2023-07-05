class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] arr = new int[n][n];

        int x = 0, y = -1;  //(0,0)부터 시작이므로 y는 -1시작
        int num = 1;
        //직각 삼각형 형태로 아래->오른->대각 순으로 순환, n의 크기면 n번 순환하는 패턴
        for (int i = 0; i < n; i++) {   //x좌표
            for (int j = i; j < n; j++) { 	///y좌표
                if(i%3 == 0) {         //아래
                    y++;
                }else if(i%3 == 1){    //우측
                    x++;
                }else if(i%3 == 2){    //대각
                    x--;
                    y--;
                }
                arr[y][x] = num;
                num++;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0){
                    break;    
                }
                answer[idx] = arr[i][j];
                idx++;
            }
        }   
        
        return answer;
    }
}