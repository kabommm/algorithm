import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
         
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();    //스택이 비어있지 않고 top과 다음원소가 같으면
            }else{  //비어있거나 top과 다음원소가 다르면
               stack.push(s.charAt(i)); 
            }
        } 
        if(stack.isEmpty() == true ){   //비어있으면
            answer = 1;
        }     
        return answer;

    }
}