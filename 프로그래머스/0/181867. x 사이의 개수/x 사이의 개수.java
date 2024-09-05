class Solution {
    public int[] solution(String myString) {
        int length = 1;
        for(int i=0; i<myString.length(); i++){
            if(myString.charAt(i) == 'x'){
                length++;
            }
        }
        int[] answer = new int[length];
        
        int idx = 0;
        int count = 0;
        for(int i=0; i<myString.length(); i++){
            if(myString.charAt(i) == 'x'){
                answer[idx] = count;
                idx++;
                count = 0;    //0으로 초기화
            }else if(i == myString.length() -1){
                count++;
                answer[idx] = count;
            }
            else{
                count++;
            }
        }
        return answer;
    }
}