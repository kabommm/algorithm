class Solution {
    public String solution(int n, int t, int m, int p) {
        
    String answer = "";
    int num = 0;
    String str = "";
    String mystr = "";

    // (t * m)t바퀴동안, 0부터 계속 n진법으로 변환한 것을 저장
    while (str.length() < m * t) {  
        str += Integer.toString(num, n);
        num++;
    }
    // t회, 내 차례만 정답에 추가
    for (int i=0; i<t; i++) {
        mystr += str.charAt(p - 1 + i * m);
    }
    //대문자 변환
    answer = mystr.toUpperCase();
        
    return answer.toString().toUpperCase();
        
    }
}