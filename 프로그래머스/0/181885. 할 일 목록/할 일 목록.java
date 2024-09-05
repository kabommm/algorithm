class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int length = 0;
        for(int i=0; i<finished.length; i++){
            if(finished[i] == false){
                length++;
            }
        }
        String[] answer = new String[length];
        int idx = 0;
        for(int i=0; i<finished.length; i++){
            if(finished[i] == false){
                answer[idx] = todo_list[i];
                idx++;
            }
        }
        
        return answer;
    }
}