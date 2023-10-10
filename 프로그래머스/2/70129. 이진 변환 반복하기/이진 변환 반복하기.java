class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];  //[반복 횟수,제거한 0의 수]
        while(!s.equals("1")) {  //s가 1이될 때까지 반복
            int count = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    answer[1]++;    //0이 나온 만큼 두번째 배열의 원소 증가
                    count++;    //0이 나온 수
                }
            }
            s = Integer.toString(s.length() - count,2);    //이진으로 변환(문자열)
            //s = Integer.toBinaryString(len);
            //Integer.toString(8,2)   (변활할 숫자,N진수)
            answer[0]++;    //한 번 순회할 때마다 배열의 첫번째 원소 증가
        }
        return answer;
    }
}