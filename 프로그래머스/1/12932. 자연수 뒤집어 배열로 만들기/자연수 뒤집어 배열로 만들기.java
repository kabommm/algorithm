class Solution {
    public int[] solution(long n) {
        String str = n + "";
        int[] answer = new int[str.length()];
        for(int i=0; i<answer.length; i++){
            answer[i] = Integer.parseInt(str.charAt(str.length() - 1 - i) + "");
        }
        
        return answer;
    }
}