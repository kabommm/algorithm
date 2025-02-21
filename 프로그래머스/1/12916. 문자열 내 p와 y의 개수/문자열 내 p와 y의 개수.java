class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toLowerCase();
        int p=0;
        int y=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'p'){
                p++;
            }else if(str.charAt(i) == 'y'){
                y++;
            }
        }
        if(p==y){
            return answer;
        }else{
            return false;
        }
            
    }
}