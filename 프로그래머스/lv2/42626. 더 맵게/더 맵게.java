import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //list를 사용하면 정렬(sort)하는 과정이 필요해 시간초과가 난다 ->큐 자료구조
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){   //큐에 배열 값 주입
            q.offer(scoville[i]);
        }
        while(q.peek() < K){    //1 2 3 9 10 12
            if(q.size() == 1){
                return -1;
            }
            q.offer(q.poll() + q.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}