class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        int g = 0;
        if(arr.length == 1){    //길이가 1인 경우
            return arr[0];  
        }
        // answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            g = gcd(answer, arr[i]);    //최대 공약수
            answer = (answer * arr[i]) / g; //최소 공배수
        }
        return answer;
    }
    
    public static int gcd(int a, int b) {  //최대 공약수 함수
        int r = a % b;
        if(r == 0){
            return b;
        }else{
            return gcd(b, r);    
        }
    }
}