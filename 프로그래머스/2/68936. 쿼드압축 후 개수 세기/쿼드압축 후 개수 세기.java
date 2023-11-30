class Solution {
    static int[] answer;
    public boolean check(int[][] arr, int x, int y, int size) {
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != arr[x][y]){
                    return false;
                }
            }
        }
        return true;
    }
    public void quad(int[][] arr, int x, int y, int size){
        if(check(arr,x,y,size)){
            if(arr[x][y] == 1){
                 answer[1]++;
            }else{
                answer[0]++;
            } 
            return; //반환하고 종료
        }
        quad(arr,x,y, size/2);
        quad(arr,x,y + size/2, size/2);
        quad(arr,x+size/2,y, size/2);
        quad(arr,x+size/2,y + size/2, size/2);
    }
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr,0,0,arr.length);
        return answer;
    }
}