import java.util.*;
public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++){

            String answer = "";

            List<Integer> list = new ArrayList<>();

            int len = sc.nextInt(); //원본 암호문의 길이 N

            for(int i=0; i<len; i++){
                int code = sc.nextInt();    //원본 암호문
                list.add(code);
            }

            int command = sc.nextInt();//명령어의 개수

            for(int i=0; i<command; i++){
                String str = sc.next();    //명령어
                int x = sc.nextInt(); //x 위치에 삽입
                int y = sc.nextInt();  //y 개의 숫자

                for(int j=0; j<y; j++){
                    int num = sc.nextInt();
                    list.add(x+j, num);
                }
            }

            for(int i=0; i<10; i++){
                answer += (list.get(i) + "") + " ";
            }

            System.out.println("#" + test_case + " " + answer);
        }

    }
}
