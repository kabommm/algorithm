class Solution {
  public int solution(int n) {
      int answer = 0;
      answer = m(n);
      return answer;
  }
    
    public int m(int n){
        int sum = 0;    //약수의 합
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0 && (n / i) == i){
                sum += i;
            }else if(n % i == 0){
                sum += i;
                sum += (n / i);
            }
        }
        return sum;
    }
}