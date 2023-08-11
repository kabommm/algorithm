class Solution {
    
    public boolean isprime(int n){
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    return false;     
                }         
            }
            return true; 
        }
    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(isprime(i)){ //소수판별 결과 참이면
                answer++;
            }
        }
        return answer;
    }
}