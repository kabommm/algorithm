import java.util.*;
class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map = new HashMap<>();
        //장르별(key) 누적 플레이수(value)를 담는다
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        //key값만 가져온 Arraylist
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()) {
            genre.add(key);
        }
        //(많이 재생된 장르 순으로) 내림차순 정렬
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1)); 
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);
            
            //해당 장르의 음악 중 play횟수가 가장 큰 인덱스를 찾는다
            int max = 0;
            int firstIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }
            
            //해당 장르의 음악 중에서 play횟수가 두번째로 큰 인덱스를 찾는다.
            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j] && j != firstIdx) { 
                    max = plays[j];
                    secondIdx = j;
                }
            }
            
            list.add(firstIdx);
            //장르에 속한곡이 2개 이상이라 secondIdx가 존재할 경우
            if(secondIdx >= 0){
                list.add(secondIdx);    
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}