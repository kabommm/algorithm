import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("[{}]", " ");   //{와 }제거
        String[] str = s.trim().split(" ,");
        int[] answer = new int[str.length];
        
        HashSet<Integer> set = new HashSet<>();
        //원소 가 적은 순으로 검사-> 새 원소가 나타나면 배열에 원소 추가
        Arrays.sort(str, (a,b) -> {    //길이 오름차순으로 배열 정렬
            return a.length() - b.length();
        });
        int idx = 0;    
        for(String strs : str){
            for(String st : strs.split(",")){
                int a  = Integer.parseInt(st.trim());
                if(set.contains(a)){
                    continue;
                }else{
                    set.add(a);
                    answer[idx++] = a;  
                }
                       
            } 
        }
        return answer;
    }
}