import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> map = new HashSet<>();
        int count = 1;
        while(count <= elements.length){   //길이 1부터 총 길이만큼
            for (int i = 0; i < elements.length; i++) { //시작 위치
                int value = 0;  //더한 값
                for (int j = i; j < i + count; j++) {
                    value += elements[j % elements.length];
                }
                map.add(value);
            }
            count++;
        }   
        answer = map.size();
        return answer;
    }
}