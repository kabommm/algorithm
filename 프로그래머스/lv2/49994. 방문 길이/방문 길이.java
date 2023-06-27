import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][][] visit = new int[11][11][4];   //x, y, 문자

        int x = 5;
        int y = 5;
        int dx[] = { 0, 0, -1, 1 };
        int dy[] = { 1, -1, 0, 0 };

        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int idx = 0;
            int reflact = 0;

            if (ch == 'U') {
                idx = 0;
                reflact = 1;
            } else if (ch == 'D') {
                idx = 1;
                reflact = 0;
            } else if (ch == 'L') {
                idx = 2;
                reflact = 3;
            } else if (ch == 'R') {
                idx = 3;
                reflact = 2;
            }

            if (x + dx[idx] < 0 || x + dx[idx] > 10 || y + dy[idx] < 0 || y + dy[idx] > 10){
                continue;
            }
            
            if (visit[x][y][idx] == 0 && visit[x+dx[idx]][y+dy[idx]][reflact] == 0) {
                visit[x][y][idx] = 1;
                visit[x+ dx[idx]][y+ dy[idx]][reflact] = 1;
                answer++;
            }


            x += dx[idx];
            y += dy[idx];


        }
        
//         int arr[] = {0,0};
//         HashSet<String> set = new HashSet<>();
//         //이동할 때마다 좌표를 저장하고 그 좌표를 조회해서 중복이 아니면 answer++
//         for(int i=0; i<dirs.length(); i++){
//             Character ch = dirs.charAt(i);
//             String str = "";
// //(0,1), (-1,1), (-1,2), (0,2), (1,2), (1,1), (0,1), (-1,1), (-1,2)
// //(-1,0), (-1,1), (-2,1), (-3,1), (-4,1), (-5,1), x(-6,1), x(-6,1), (-5,2)
//             if(ch == 'U' && arr[1] < 5){ //(0,+1)
//                 ++arr[1];
//                 str += arr[0]+"";
//                 str += arr[1]+"";
//                 set.add(str); 
//             }else if(ch == 'D' && arr[1] > -5){   //(0,-1)
//                 --arr[1];
//                 str += arr[0]+"";
//                 str += arr[1]+"";
//                 set.add(str); 
//             }else if(ch == 'R' && arr[0] < 5){   //(+1,0)
//                 ++arr[0];
//                 str += arr[0]+"";
//                 str += arr[1]+"";
//                 set.add(str); 
//             }else if(ch == 'L' && arr[0] > -5){    //(-1,0)
//                 --arr[0];
//                 str += arr[0]+"";
//                 str += arr[1]+"";
//                 set.add(str); 
//             }
//             }
        
//         answer = set.size();
        return answer;
    }
}