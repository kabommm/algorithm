import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        
        for(int i=0; i<dirs.length(); i++){
            int gpsX = x;
            int gpsY = y;
            String str = "";     
//0001, -1, (-1,2), (0,2), (1,2), (1,1), (0,1), (-1,1), (-1,2)
//(-1,0), (-1,1), (-2,1), (-3,1), (-4,1), (-5,1), x(-6,1), x(-6,1), (-5,2)
            if(dirs.charAt(i) == 'U'){
                ++gpsY;
                str += x;
                str += y;
                str += gpsX;
                str += gpsY;    //이곳
            }else if(dirs.charAt(i) == 'D'){
                --gpsY;
                str += gpsX;
                str += gpsY;    //이곳
                str += x;
                str += y;
            }else if(dirs.charAt(i) == 'R'){
                ++gpsX;
                str += x;
                str += y;
                str += gpsX;    //이곳
                str += gpsY;
            }else if(dirs.charAt(i) == 'L'){
                --gpsX;
                str += gpsX;    //이곳
                str += gpsY;
                str += x;
                str += y;
            }
            
            //범위 벗어나면 무시
            if(gpsX < -5 || gpsY < -5 || gpsX > 5 || gpsY > 5){
                 continue;
            }
            set.add(str);
            x = gpsX;
            y = gpsY;
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
        
        answer = set.size();
        return answer;
    }
}