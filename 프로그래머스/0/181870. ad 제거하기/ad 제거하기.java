import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        
        ArrayList<String> answer = new ArrayList<>();
        
        for (String str : strArr) {
            if (!str.contains("ad")) {
                answer.add(str);
            }
        }
        String ans[] = new String[0];
        return answer.toArray(ans);
    }
}