class Solution {
    public int solution(int a, int b) {
        int answer = 2 * a * b;
        int answer2 = Integer.parseInt(a+"" + b+"");
        
        if(answer2 >= answer){
            answer = answer2;
        }
        return answer;
    }
}