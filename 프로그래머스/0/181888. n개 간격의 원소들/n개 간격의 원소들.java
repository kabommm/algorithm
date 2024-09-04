class Solution {
    public int[] solution(int[] num_list, int n) {
        int length = 0;
        for(int i=0; i<num_list.length; i+=n){
            length++;
        }
        int[] answer = new int[length];
        int idx = 0;
        for(int i=0; i<num_list.length; i+=n){
            answer[idx] = num_list[i]; 
            idx++;
        }
        return answer;
    }
}