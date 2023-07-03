import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] arr = new int[50];
        int sum = 2;
        arr[0] = 1;

        for(int i=1; i<arr.length; i++) {
            arr[i] = arr[i-1] + sum;
            ++sum;
        }

        boolean[] check = new boolean[1001];

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                for(int k=0; k<arr.length; k++) {
                    int index = arr[i] + arr[j] + arr[k];
                    if(index > 1000){
                        continue;
                    }
                    check[index] = true;
                }
            }
        }

        for(int i=0; i<T; i++) {
            int num = sc.nextInt();
            if(check[num]){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
}
