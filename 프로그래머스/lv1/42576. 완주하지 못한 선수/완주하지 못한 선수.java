import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String i : participant) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for (String i : completion) {
            map.put(i, map.get(i) - 1);
        }
        for (String i : map.keySet()) { //value 값들을 모두 조사
            if(map.get(i) != 0) {   //Value가 0이 아닌 값이 완주하지 못한 값 
                answer = i;
                break;
            }
        }
        return answer;
    }
}