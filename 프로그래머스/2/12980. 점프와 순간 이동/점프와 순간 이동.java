import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(true){    //값이 반환 될 때까지 계속 반복
            if(n == 0){ //역추적한 n이 시작점으로 돌아갔을때 비로소 탈출 종료
                break;
            }
            if( n % 2 == 0){   //2로 나누어지면
                n /= 2;
            }else{
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
}