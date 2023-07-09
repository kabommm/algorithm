import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char arr[][] = new char[n][m];
        for(int i=0; i<n; i++){
            String str = sc.next();
            //toCharArray()를 통해 문자열을 문자 배열로 변경
            char ch[] = str.toCharArray();

            arr[i] = ch;
        }

        //행열을 돌면서 경비원이 있는지 확인
        boolean[] existN = new boolean[n];
        boolean[] existM = new boolean[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 'X'){
                    existN[i] = true;
                    existM[j] = true;
                }
            }
        }


        int ansN = 0;
        int ansM = 0;
        for(int i=0; i<n; i++){
            if(!existN[i]){
                ++ansN;
            }
        }
        for(int i=0; i<m; i++){
            if(!existM[i]){
                ++ansM;
            }
        }
        System.out.println(Math.max(ansN,ansM));
    }
}
