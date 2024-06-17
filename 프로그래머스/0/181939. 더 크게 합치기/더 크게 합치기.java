class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String aa = a + "";
        String bb = b + "";
        
        String str1 = aa+bb;
        String str2 = bb+aa;
        
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        
        if(num1 > num2){
            answer = num1;
        }else{
            answer = num2;
        }
        
        return answer;
    }
}