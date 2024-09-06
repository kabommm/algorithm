import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //list를 사용하면 정렬(sort)하는 과정이 필요해 시간초과가 난다 ->큐 자료구조
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0; i<scoville.length; i++){   //큐에 배열 값 주입
            pq.offer(scoville[i]);
        }
        while(!pq.isEmpty()) {
            /* 원소가 1개일 경우 */
            if (pq.size() == 1) {
                if (pq.peek() >= K) {
                    return answer;
                } else {
                    return -1;
                }
            }

            /* 스코빌 지수 만족 */
            if (pq.peek() >= K) {
                return answer;
            } else {
                int target = pq.poll(); /* 가장 작은 수 */
                int second = pq.poll(); /* 두번째로 작은 수 */

                int result = target + (second * 2);

                pq.offer(result);

                answer++;
            }
        }
        
        return answer;
    }
}