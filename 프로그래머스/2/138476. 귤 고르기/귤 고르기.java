import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        int size = 1;   //몇번 등장했지는지 빈도
        int key = tangerine[0];
        
        for (int e : tangerine) {   //배열반복문을 사용해야 하는 이유
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        //정렬을 사용하기 위한 ArrayList, list는 map의 key를 반환
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        // Value 값으로 내림차순 정렬
        Collections.sort(keySet, (o1, o2) -> {  //list는 Collections
            return map.get(o2).compareTo(map.get(o1));   
        });
        
        for (int i : keySet) {
            k -= map.get(i);   //value값
            answer++;
            if(k<1){
                return answer;
            }
        }
        return answer;
    }
}