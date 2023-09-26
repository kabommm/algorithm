import java.util.*;
class Solution {
    
    List<String> al = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    
    public void combination(String order, String others, int count) {
        if (count == 0) {   //course[i]번 다 돌았으면
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }

        //문자열 끝까지
        for (int i = 0; i < others.length(); i++){
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        //orders의 각 문자열 오름차순 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);    //다시 문자열로 변환
        }

        for (int i=0; i<course.length; i++) {
            for (int j=0; j<orders.length; j++){
                combination("", orders[j], course[i]);
            }

            // 가장 많은 조합 저장
            if (!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);
                //Collections.max: 리스트 내의 최대 원소 구하기
                
                if (max > 1){
                    for (String key : map.keySet()){
                        if (map.get(key) == max){
                            al.add(key);    //정답 리스트에 추가
                        }    
                    }
                }
                map.clear();
            }
        }

        Collections.sort(al);
        String[] answer = new String[al.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = al.get(i);
    
        
        return answer;
    }
}