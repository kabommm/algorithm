import java.util.*;
class Solution {
    public String solution(String number, int k) {
        //숫자를 두개 제거하면 만들 수 있는 수를 배열에 담고
        //오름차순 뒤 맨 마지막 원소의 값 반환
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int max = 0;
        
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = idx; j <= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        answer = sb.toString();
        return answer;
    }
}