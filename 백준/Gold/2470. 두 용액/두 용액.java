import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int findPair(int arr[], int fromIndex, int toIndex, int value){
        int pair = 0;
        int abs = 2000000000;
        int l =  fromIndex;
        int r = toIndex;
        while(l <= r){
            int m = (l+r)/2;
            int sum = value + arr[m];
            int sumAbs = Math.abs(sum);
            if(sumAbs < abs){   //구한 절대값이 이전 갱신한 절대값보다 작으면
                pair = arr[m];  //구해야하는 파트너
                abs = sumAbs;   //절대값 기준 갱신
            }

            if(sum < 0){
                l = m+1;
            }else if(sum > 0){
                r = m-1;
            }else{  //0인 경우 바로 반환
                return arr[m];
            }
        }
        return pair;   //arr[i]의 짝 반환
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        int ansAbs = 2000000000;    //처음 비교를 위해 두 쌍의 합의 최대 값을 초기값으로 설정
        int ans1 = 0;
        int ans2 = 0;
        //첫 용액에 대해 최적의 쌍이 최적쌍이 되는 파트너 용액을 찾는다
        for(int i=0; i<n-1; i++){
            //Arrays.binarySearch 메서드는 boolean 타입으로 반환하는데 이 문제는
            //정확한 값이 아닌 가장 가까운 특정 값을 찾아야 한다. 따라서 이 문제는 직접 함수로 구현해야 한다.
            int pair = findPair(arr, i+1, n-1, arr[i]);
            int abs = Math.abs(arr[i] + pair);
            if(abs < ansAbs){   //절댓값이 작으면(두 수의 합이 0에 가까운) 갱신
                ansAbs = abs;
                ans1 = arr[i];  //쌍의 처음 수
                ans2 = pair;    //쌍의 파트너 수
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
