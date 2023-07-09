import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //위에서 주어진 n은 목판의 크기이지 문자열의 길이가 주어지지 않음
        //따라서 문자열의 길이가 0이 들어오는 경우가 있어서 받는 값이 없는 NoSuchElement 에러 발생
        //String str = sc.next();
        String str = sc.hasNext() ?  sc.next() : "";

        boolean[][] passVertical = new boolean[n][n];   //수직 방문
        boolean[][] passHorizontal = new boolean[n][n]; //수평 방문

        int y = 0, x = 0;
        for (int i = 0; i < str.length(); i++) {    //문자열 차례로 검사
            if (str.charAt(i) == 'D') {   //아래
                if (y == n - 1){
                    continue;
                }
                passVertical[y][x] = true;  //현 위치 방문
                passVertical[y + 1][x] = true;  //이동한 위치 방문
                ++y;
            }
            else if (str.charAt(i) == 'U') {  //위
                if (y == 0){
                    continue;
                }
                passVertical[y][x] = true;  //현 위치 방문
                passVertical[y - 1][x] = true;  //이동한 위치 방문
                --y;
            }
            else if (str.charAt(i) == 'L') {  //왼쪽
                if (x == 0){
                    continue;
                }
                passHorizontal[y][x] = true;    //현 위치 방문
                passHorizontal[y][x - 1] = true;    //이동한 위치 방문
                --x;
            }
            else {  //오른쪽
                if (x == n - 1) {
                    continue;
                }
                passHorizontal[y][x] = true;    //현 위치 방문
                passHorizontal[y][x + 1] = true;    //이동한 위치 방문
                ++x;
            }
        }

        for (int i = 0; i < n; i++) {
            String ans = "";
            for (int j = 0; j < n; j++) {
                if (passHorizontal[i][j] && passVertical[i][j]){    //수직&수평 방문
                    ans += "+";
                }else if(passVertical[i][j]){
                    ans += "|";
                }else if(passHorizontal[i][j]){
                    ans += "-";
                }else{
                    ans += ".";
                }
            }
            System.out.println(ans);
        }
    }
}
