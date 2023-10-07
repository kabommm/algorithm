import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // boolean answer = true;
        // int count1 = 0;
        // int count2 = 0;
        // for(int i=0; i<s.length(); i++){        
        //     if(s.charAt(i) == '('){ // (면
        //         count1++;
        //     }else{  // )면
        //         count2++;
        //     }
        //     // ex : ())(
        //     if(count1 < count2 ){   //)가 더 많으면
        //         answer = false;
        //         break;
        //     }
        //     }
        // if(count1 != count2){   //(와 )의 개수가 다르면
        //     answer = false;
        // }
            
        // return answer;
        Stack<Character> stack = new Stack<>();  
        for(int i = 0; i < s.length(); i++){  
            if(s.charAt(i) == '('){  
                stack.push('(');  
            }else{  
                if(stack.isEmpty()){  
                    return false;  
                }  
                stack.pop();  
            }  
        }  
        if(!stack.isEmpty()){    //스택이 비어있지 않다면 거짓
            answer = false;
        }
        return answer;
    }
}