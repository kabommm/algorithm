class Solution {
    public String solution(int n, int t, int m, int p) {
        //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        // t * m 즉 몇바퀴, 0부터 계속 n진법으로 변환한 것을 저장
        for(int i = 0; sb.length() <= t * m; i++){
            sb.append(Integer.toString(i, n));
        }
        
        // 총 t회, 내 차례만 정답에 추가
        for(int i = p - 1; answer.length() < t; i += m){
            answer.append(sb.charAt(i));
        }
        // StringBuilder 문자열로 변환 + 대문자 변환
        return answer.toString().toUpperCase();
    }
}