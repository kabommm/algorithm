import java.util.*;
class Solution {
    public int solution(int[] nums) {   //포켓몬이 담긴 배열
        int answer = 0;
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            map.add(nums[i]);
        }
        //가져가야 할 포켓몬의 수보다 포켓몬의 종류가 같거나 많다면
        if(map.size() >= nums.length/2){   
            answer = nums.length/2;
        }else{
            answer = map.size();    
        }
        return answer;
    }
}