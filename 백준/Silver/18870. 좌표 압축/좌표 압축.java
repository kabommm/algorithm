import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];	//반환하기 위한 원본 배열
        int[] answer = new int[n];	//순서 계산을 위한 정렬이 필요한 배열
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            int num  = sc.nextInt();
            arr[i] = num;
            answer[i] = num;
        }
        Arrays.sort(answer);    //정렬 할 배열만 오름차순 정렬

        int idx = 0;
        for(int i=0; i<answer.length; i++) {
            if(!map.containsKey(answer[i])){    //키가 없으면 즉, 중복이 아니면
                map.put(answer[i], idx);
                idx++;
            }

        }

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++) {
            sb.append(map.get(arr[i])).append(' ');
        }
        System.out.println(sb);
    }
}
