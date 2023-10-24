import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int num = 1;
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);

        for(int i=1; i<words.length; i++){
            //끝말이 이어지지 않았거나 이미 나온단어이면 중지
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || set.contains(words[i]) ){
                break;
            }else{  //중복된 단어가 아니고 끝말이 이어지면 추가
                set.add(words[i]);
                num++;
            } 
        }
        if(num==words.length){  //모든 단어 순회
            return answer;  
        }else{
            answer[0] = (num % n) + 1;
            answer[1] = (num / n) + 1;
        }
        return answer;
    }
}