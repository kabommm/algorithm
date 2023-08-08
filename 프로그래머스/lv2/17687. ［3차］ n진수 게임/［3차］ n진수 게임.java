class Solution {
    public String solution(int n, int t, int m, int p) {
        
    String answer = "";
    int num = 0;
    String str = "";

    // (t * m)t바퀴동안, 0부터 계속 n진법으로 변환한 것을 저장
    while (str.length() < m * t) {  //총 m * t +1번
        str += Integer.toString(num, n);
        num++;
    }
    // t회, 내 차례만 정답에 추가
    for (int i=0; i<t; i++) {
        answer += str.charAt(p - 1 + i * m);
    }
    //대문자 변환
        
    return answer.toUpperCase();
        
    }
}