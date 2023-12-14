import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) ->{
            int first = Math.abs(o1);
            int last = Math.abs(o2);
            if(first == last){  //절대값이 같으면 음수부터 리턴
                return o1 > o2 ? 1 : -1;    //1이라는 숫자에 상관없이 양수와 음수를 표현
            }//절댓값이 다르면 작은 수부터 리턴
            return first - last;
        });

        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            if(x ==0){
                if(q.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(q.poll());
                }
            }else{
                q.add(x);
            }
        }
    }
}