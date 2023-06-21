import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            //스택이 비어있지 않고 등장한 문자가 크면서 k--가 0보다 크면
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        
        return new String(result);
    }
}