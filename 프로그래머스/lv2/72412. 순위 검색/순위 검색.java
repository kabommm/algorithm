import java.util.*;
class Solution {
    static HashMap<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        
        int[] answer = new int[query.length];
        map = new HashMap<String, List<Integer>>();
 
        for (int i = 0; i < info.length; i++) {
            //문장마다 각 키워드를 배열의 원소로하는 배열 p를 생성
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0);
        }
 
        //value(점수 List)를 오름차순으로 정렬
        for (String key : map.keySet()){
            Collections.sort(map.get(key));
        }
 
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            //map에 query의 첫번째 키워드(점수 제외 문자열)로 시작하는 것이 있으면 탐색
            //없으면 정답 배열에 0을 삽입
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0; //q[0]=언어+직군+경력+소울 푸드, q[1]=점수(정수형으로 변환)
        }
 
        return answer;
    }
 
    // 이분 탐색
    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
 
        return list.size() - start;
    }
 
    // info가 포함될 수 있는 문장
    private static void makeSentence(String[] p, String str, int cnt) {
        if (cnt == 4) { //5번째 키워드(점수)까지 다 돌았으면 반환
            if (!map.containsKey(str)) {//map의 key에 해당 문장이 없으면
                List<Integer> list = new ArrayList<Integer>();
                map.put(str, list); //key에 문장 value에 list
            }
            //배열의 5번째 원소 즉, 점수를 value값(list)으로 넣음
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeSentence(p, str + "-", cnt + 1);
        makeSentence(p, str + p[cnt], cnt + 1);
    }
}