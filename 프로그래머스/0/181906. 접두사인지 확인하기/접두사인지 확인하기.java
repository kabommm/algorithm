class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 1;
        int size = 0;
        if(my_string.length() - is_prefix.length() >=0){
            size = is_prefix.length();
        }else{
            return 0;
        }
            
        for(int i=0; i<size; i++){
            if(my_string.charAt(i) != is_prefix.charAt(i)){
                answer = 0;
            }
        }
        return answer;
    }
}