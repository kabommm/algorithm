class Solution {
    public int solution(int n) {
        int answer = n+1;
        int num1 = 0;
        // String bi = Integer.toBinaryString(n);  //n을 2진수로 string값
        String bi = Integer.toString(n,2);  //n을 2진수로
        for(int i=0; i<bi.length(); i++){
            if(bi.charAt(i) == '1'){
                num1++; //1의 개수
            }
        }
        for(int i=answer; i<1000000; i++){
            String bi2 = Integer.toBinaryString(i);
            int num2 = 0;
            for(int j=0; j<bi2.length(); j++){
                if(bi2.charAt(j) == '1'){
                    num2++; //1의 개수
                }
            }
            if(num1 == num2){   //1의 개수가 같으면 바로반환
                return i;       
            } 
        }
        return answer; 
    }
}