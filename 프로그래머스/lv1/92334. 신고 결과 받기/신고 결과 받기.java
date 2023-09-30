import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        
        HashSet<String> report_set = new HashSet<>(Arrays.asList(report));
        HashMap<String, Integer> reported = new HashMap<>();

        //HashMap에 id_list를 저장
        for (String user_id: id_list) {
            reported.put(user_id, 0);
        }
        //HashMap에 피신고자의 누적 횟수를 저장
        for (String i: report_set) {
            reported.put(i.split(" ")[1], reported.get(i.split(" ")[1]) + 1);
        }

        for (String i: report_set) {
            //피신고자가 기준 k횟수보다 누적 신고값이 크면
            if (reported.get(i.split(" ")[1]) >= k) {
                answer[Arrays.asList(id_list).indexOf(i.split(" ")[0])] += 1;
            }
        }

      return answer;
    }
}