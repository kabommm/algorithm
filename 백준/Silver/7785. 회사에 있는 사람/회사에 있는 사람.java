import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        HashSet<String> set = new HashSet<>();

        // 각 사원의 마지막 기록이 enter -> 출력, leave -> 출력 x
        for(int i=0; i<n; i++){
            String name = sc.next();
            String inter = sc.next();
            if(inter.equals("enter")){
                set.add(name);
            }else{  //leave
                set.remove(name);
            }

        }
        //방법1. toArray 는 모든 요소를 배열로 반환
//        String arr[] = set.toArray(new String[set.size()]);

        //방법2. 선언시에 Hashset 을 리스트에 넣는다.
        ArrayList<String> al =new ArrayList<>(set);
        // 내림차순 정렬 - String 은 Object type 이므로 Collections.reverseOrder() 사용가능
        Collections.sort(al, Collections.reverseOrder());

        // 이름의 내림차순으로 출력
//        for(int i=arr.length-1; i>=0; i--){
//            System.out.println(arr[i]);
//        }
        //내림차순 정렬된 리스트 출력
        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i));
        }
    }
}
