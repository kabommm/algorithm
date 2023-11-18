import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();   //정점의 개수

        for(int t=1; t<=tc; t++){

            String str = sc.next();

            String arr[][] = new String[5][5+(4*(str.length()-1) ) ];

            //줄1,5
            for(int i=0; i< arr[0].length; i++){
                arr[0][i] = ".";
                arr[4][i] = ".";
            }
            for(int i=2; i<arr[0].length; i = i+4){
                arr[0][i] = "#";
                arr[4][i] = "#";
            }
            //줄2,4
            for(int i=0; i< arr[0].length; i = i+2){
                arr[1][i] = ".";
                arr[3][i] = ".";
            }
            for(int i=1; i<arr[0].length; i = i+2){
                arr[1][i] = "#";
                arr[3][i] = "#";
            }
            //줄3
            for(int i=0; i< arr[0].length; i++){
                arr[2][i] = ".";
            }
            for(int i=0; i<arr[0].length; i = i+4){
                arr[2][i] = "#";
            }
            int idx = 0;
            for(int i=2; i<arr[0].length; i = i+4){
                arr[2][i] = str.charAt(idx)+"";
                idx++;
            }

            for(int i=0; i<5; i++){
                for(int j=0; j< arr[0].length; j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}
