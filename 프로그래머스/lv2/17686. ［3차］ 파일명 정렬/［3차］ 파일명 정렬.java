import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = files;
        Arrays.sort(answer, (o1, o2) -> {
        String head1 = o1.split("[0-9]")[0].toLowerCase();
        String head2 = o2.split("[0-9]")[0].toLowerCase();
        int result = head1.compareTo(head2);    //숫자 앞 HEAD의 사전순 정렬

        if(result == 0){    //HEAD가 같은 문자면 -> 숫자 비교
            int number1 = convert(o1, head1);   //NUMBER 추출
            int number2 = convert(o2, head2);   //NUMBER 추출

            result = Integer.compare(number1, number2);
        }
        return result;
    });
        return answer;
    }

    private int convert(String s, String head) {
        StringBuilder number = new StringBuilder();
        s = s.substring(head.length());
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') { //숫자이면
                number.append(c);   //숫자를 순서대로 이어붙히기 
            }else{  //숫자가 끝나면 종료
                break;
            }
        }
        return Integer.parseInt(number.toString()); //이어붙힌 숫자를 int형으로
    }
}
