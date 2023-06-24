import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        //각 hashmap에 key를 저장하고 key의 개수가 같으면 방법++
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        //map2에 숫자와(key) 등장 횟수(value)를 저장
        for (int i = 0;i < topping.length; i++) {
            //getOrDefault를 이용해 비어있으면0+1 이미있다면 value+1
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
            //value가 1이면 삭제
            if(map2.get(topping[i]) - 1 == 0){
                map2.remove(topping[i]);    
            }else{  //value가 2이상이면 -1
                map2.put(topping[i], map2.get(topping[i]) - 1);      
            }
            if(map1.size() == map2.size()){  
                answer++;
            }
        }
        return answer;
    }
}