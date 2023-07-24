import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = files;
        Arrays.sort(answer, (o1, o2) -> {
        String head1 = o1.split("[0-9]")[0].toLowerCase();
        String head2 = o2.split("[0-9]")[0].toLowerCase();

        int result = head1.compareTo(head2);

        if (result == 0) {
            int number1 = convert(o1, head1);
            int number2 = convert(o2, head2);

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
            if (c >= '0' && c <= '9') {
                number.append(c);
            } else {
                break;
            }
        }

        return Integer.parseInt(number.toString());
    }
}