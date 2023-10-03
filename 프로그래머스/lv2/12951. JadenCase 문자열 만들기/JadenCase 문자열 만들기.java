class Solution {
    public String solution(String s) {
        String answer = "";
        String arr[] = s.split(" ");  //공백 기준으로 문자열을 담은 배열
        for(int i=0; i<arr.length; i++){
            // 문자열의 길이가 0이라면(공백 이라면, 즉 공백문자가 연속해 있었던 경우)answer에 " "만 추가
    		if(arr[i].length() == 0) {
    			answer += " ";
    		}else{
                answer += arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase() + " ";//맨앞 문자와 인덱스1부터와 공백을 더함
            }
        }
            // 입력 받은 문자열의 맨 마지막이 " " 라면 끝에 공백이 있는 채로 반환
            if(s.charAt(s.length()-1) == ' '){
                return answer;
            }   //문자로 끝나는 일반적인 경우는 마지막 공백이 안나오게 answer.length()-1로 반환
        return answer.substring(0, answer.length()-1);
    }
}