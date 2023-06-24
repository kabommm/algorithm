import java.util.*;
class Solution {
    //1. 필요 변수 선언
    static String[] arr;
    static ArrayList<String> list;
    
    // 2. 완전탐색 메서드
    public static void recursion(String word, String str, int depth) {
        list.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            recursion(word, str + arr[i], depth + 1);
        }
    }
    //3. 메인
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        // 완전탐색 메서드
        recursion(word, "", 0);
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
}