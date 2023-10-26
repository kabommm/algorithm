import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int jump = 0;   //점프 횟수
        int sum = 1;    //현 위치, 0은 2를 곱해도 0이므로 1로 시작 대신 배터리 1소모
        // +k or 지금까지 온 거리 sum * 2로 이동
        //점프+순간이동으로 도달 가능한 경우의 수를 구하고 그중 최솟값 반환
        
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