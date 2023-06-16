import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int num = 0;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i],number[i]);
        }
        //시작점: 처음부터 ~ 10개가 딱 떨어질 때 까지의 수 
        for(int i=0; i<discount.length - 10 + 1; i++){  
            HashMap<String,Integer> com = new HashMap<>();
            for(int j = 0; j < 10; j++){
                com.put(discount[i+j], com.getOrDefault(discount[i+j],0)+1);
            }   //없으면 0 있으면 기존 value +1
            
            for(String key : map.keySet()){
                if(map.get(key) != com.get(key)){
                    num++;
                    break;  //하나가 안맞으면 그대로 -1이므로 바로 탈출
                }
            }
        }
        answer = discount.length - 10 + 1 - num;
        return answer;
    }
}