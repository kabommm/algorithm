import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); //오름차순 정렬, 0 1 3 5 6
        for(int i=0; i<citations.length; i++){
            int num = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer,num);
        }
        return answer;
    }
}