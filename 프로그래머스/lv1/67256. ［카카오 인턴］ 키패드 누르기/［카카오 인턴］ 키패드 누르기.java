class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left =10;
        int right =12;
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer += "L";
                left = numbers[i];
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer += "R";
                right = numbers[i];
            }else{  //2,5,8,0
                if(numbers[i]==0){
                   numbers[i] = 11;
                }
                int leftdist = Math.abs(numbers[i]-left) / 3
                   + Math.abs(numbers[i]-left) % 3;
                
                int rightdist = Math.abs(numbers[i]-right)/3
                    + Math.abs(numbers[i]-right) % 3;
                
                if(leftdist<rightdist){
                    answer+="L";
                    left = numbers[i];
                }else if(leftdist>rightdist){
                    answer+="R";
                    right = numbers[i];
                }else{
                    if(hand.equals("left")){
                        answer+="L";
                        left = numbers[i];
                    }else{
                        answer+="R";
                        right = numbers[i];
                    }
                }
            }
            
        }
        return answer;
    }
}