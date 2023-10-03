class Solution {
    public String solution(String s) {
        String answer = "";
        String arr[] = s.split(" ");    //공백 기준으로 배열에 담음
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, Integer.parseInt(arr[i]));
            min = Math.min(min, Integer.parseInt(arr[i]));
        }
        answer = (min + "") + " " + (max + "");
        return answer;
    }
}