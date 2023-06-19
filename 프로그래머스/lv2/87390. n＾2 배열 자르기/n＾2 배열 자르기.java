import java.util.*;
class Solution {
    public List<Long> solution(int n, long left, long right) {
        ArrayList<Long> al = new ArrayList<>();
        
        // 1 2 3    arr[0][0] = 1 arr[0][1] = 2 arr[0][2] = 3
        // 2 2 3    arr[1][0] = 2 arr[1][1] = 2 arr[1][2] = 3
        // 3 3 3    arr[2][0] = 3 arr[2][1] = 3 arr[2][2] = 3

        for(long i=left; i<right+1; i++){
             al.add(Math.max(i / n,i % n) + 1);
        }
        return al;
    }
}