import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt(); // 오늘 하루 동안 팔린 책의 개수
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String title = sc.next();
            map.put(title, map.getOrDefault(title,0)+1);
        }
        String maxTitle = "";
        int max = 0;
        //value 값의 비교가 필요하기 때문에 getValue()를 사용할 수 있는 entrySet 를 사용
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            // value 가 최대 값이거나(가장 많이 팔린)
            // 최대 값이 같으면 Title(책 이름) 사전순
            if(entry.getValue() > max || (entry.getValue() == max && entry.getKey().compareTo(maxTitle) < 0)){
            // 두 개의 문자열을 앞에서부터 순차적으로 비교 -> 두 문자열이 같다면 0, 작으면 음수를, 크면 양수를 반환
                maxTitle = entry.getKey();
                max = entry.getValue();
            }
        }
        System.out.println(maxTitle);
    }
}
