class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //규칙: answer[0] * answer[1] = brown + yellow
        int sum = brown+yellow;
        for(int i=3; i<=sum; i++){  //가로는 최소3
            if(sum % i == 0 && sum/i >= 3){//sum이 i로 나누어 떨어지고 세로 최소3
                int col = i;
                int row = sum/i;
                //가로가 세로보다 같거나 크며 노란 격자가 가운데 존재하기 위해선 (가로 - 2) * (세로 - 2 ) = yellow
                if(col>=row && (col-2)*(row-2) == yellow){                                       answer[0] = col;
                    answer[1] = row;      
                    break;
                }
            }
    
        }
        return answer;
    }
}