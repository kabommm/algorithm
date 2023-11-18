import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            int K = sc.nextInt();

            int answer = 0;
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<Math.pow(2,K); i++){
                int num = sc.nextInt();
                list.add(num);
            }

            while(list.size() >= 2){
                for(int i=0; i<list.size(); i++){
                    if(list.get(i) < list.get(i+1)){
                        answer += list.get(i+1) - list.get(i);
                        list.remove(i);
                    }else{
                        answer += list.get(i) - list.get(i+1);
                        list.remove(i+1);
                    }
                }
            }



            System.out.println("#" + t + " " + answer);
        }
    }
}
