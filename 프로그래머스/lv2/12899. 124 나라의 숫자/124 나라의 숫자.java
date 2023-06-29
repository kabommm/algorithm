class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"}; //규칙성을 위해 배열을 이용.
      
        while(n > 0){
          int idx = n % 3;  //나머지가 0이면 4, 1이면 1, 2이면 2
          n /= 3;
          
          if(idx == 0){
            --n;
          }
          answer = numbers[idx] + answer;
        }
        return answer;
    }
}