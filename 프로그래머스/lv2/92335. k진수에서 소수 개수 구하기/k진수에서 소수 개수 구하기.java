class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k);    //n을 k진수로 변환한 값
        // String s = "";
        String[] arr = str.split("0");  //0을 기준으로 끊어서 배열에 담기
        
        for(String s: arr){  //배열 반복문
            if(s.equals("")) {  //?????
                continue;
            }
            //Long형으로 변환 Long.parseLong                      
            if(isprime(Long.parseLong(s))){ //소수이면
                answer++;
            }
        }
        // for(int i=0; i<str.length(); i++){
        //     if(str.charAt(i) != 0){
        //         s += str.charAt(i);
        //     }else if((str.charAt(i)+"").equals("0") || i == str.length()-1){  //0이 나타나거나 마지막 숫자이면
        //         if(isprime(Long.parseLong(s))){   //소수이면
        //             answer++;
        //         }
        //         s = ""; //s 초기화
        //     }
        // }
        return answer;
    }
    //소수 판별
    public boolean isprime(long n){
            if(n <= 1){
                return false;
            }else if(n == 2){
                return true;    
            } 
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    return false;     
                }         
            }
            return true; 
        }
}