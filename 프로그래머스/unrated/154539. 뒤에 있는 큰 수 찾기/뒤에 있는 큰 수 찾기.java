import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        //각 원소의 뒷 큰수 = 자신보다 뒤에 있는 숫자 중 자신보다 크면서 가까운 수
        //뒷 큰수가 없으면 -1, 맨 뒤의 수는 비교할 큰 수가 없으므로 무조건 -1
        
        // numbers의 길이가 최대 1,000,000라 이중 for문으로 시간초과 -> 스택
        Stack<Integer> stack = new Stack<>();

        stack.push(0);  //비어있는 스택에 인덱스 0 push
        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);  //인덱스 삽입
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}