import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();   //최대 숫자
        //LinkedHashMap: 입력된 Key 의 순서가 보장
        HashMap<Integer,Integer> map = new LinkedHashMap<>();

        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        // ket 로 이루어진 배열
        Integer arr[] = map.keySet().toArray(new Integer[map.size()]);
        //1순위: 빈도, 2순위 먼저 나온 수
        Arrays.sort(arr, (o1, o2) ->{
            return map.get(o2) - map.get(o1);
        });

        for(int i : arr){
            int count = map.get(i);
            while(count > 0){
                System.out.print(i + " ");
                --count;
            }
        }
    }
}
