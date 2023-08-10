import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for(String str : phone_book){
            set.add(str);
        }
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                String key = phone_book[i].substring(0, j);
                //만약 키가 이미 있다면=접두사가 나왔다!
                if(set.contains(key)){
                    return false;
                }    
            }
        }
        return answer;
    }
}