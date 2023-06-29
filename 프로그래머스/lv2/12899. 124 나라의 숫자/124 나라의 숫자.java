class Solution {
    public String solution(int n) {
        String answer = "";
        String[] num = {"4", "1", "2"}; //규칙성을 위해 배열을 이용.
        
        while(n > 0){
          answer = num[n % 3] + answer; //나머지가 0이면 4, 1이면 1, 2이면 2
          n = (n - 1) / 3;
        }
        return answer;
    }
}