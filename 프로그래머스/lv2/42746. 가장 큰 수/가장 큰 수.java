import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = numbers[i] + "";
        }
        //ex) o1 = 1,  o2 = 10  -> 110 과 101 비교  
        //내림차순
        Arrays.sort(arr, (o1, o2) ->{
            return (o2 + o1).compareTo(o1 + o2);    //내림차순
             //오름차순 정렬 (o1+o2).compareTo(o1+o2);
        });
        
        //답이 00000이 나올 수 있으므로 처음이 0이면 0을 리턴
        if (arr[0].equals("0")) {
           return "0";
        }
        
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }
        return answer.toString();   //StringBuilder - > String
    }
}