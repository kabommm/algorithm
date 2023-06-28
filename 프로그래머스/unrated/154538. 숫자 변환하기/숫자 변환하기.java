import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];  
        dp[x] = 0;  
        //x부터 y까지
        for (int i = x; i <= y; i++) {  
            
            if (i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            if (i + n <= y) {  
                if (dp[i + n] == 0) {  //처음 방문
                    dp[i + n] = dp[i] + 1;  
                } else {  //방문해서 연산한 적이 있으면
                    dp[i + n] = Math.min(dp[i + n], dp[i] + 1);  
                }  
            }  
            if (i * 2 <= y) {  
                if (dp[i * 2] == 0) {  //처음 방문
                    dp[i * 2] = dp[i] + 1;  
                } else {  //방문해서 연산한 적이 있으면
                    dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);  
                }  
            }  
            if (i * 3 <= y) {  
                if (dp[i * 3] == 0) {   //처음 방문  
                    dp[i * 3] = dp[i] + 1;  
                } else {  //방문해서 연산한 적이 있으면
                    dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);  
                }  
            }  
        }  
        return dp[y];
    }
}