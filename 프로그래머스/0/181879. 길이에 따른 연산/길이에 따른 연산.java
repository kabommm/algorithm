class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        if(num_list.length >= 11){  //모든 원소의 합
            for(int sum : num_list){
                answer += sum;
            }
        }else{  //모든 원소의 곱
            answer = 1;
            for(int mul : num_list){
                answer *= mul;
            }
        }
        
        return answer;
    }
}