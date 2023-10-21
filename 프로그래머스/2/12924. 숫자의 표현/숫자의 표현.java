class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=i; j<=n; j++){
                sum += j;
                if(sum == n){   //연속된 수의 합이 n과 같으면
                    answer++;
                    break;
                }else if(sum > n){
                    break;
                }
            }    
        }
        return answer;
    }
}