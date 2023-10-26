import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        //최소 구명보트를 써야하므로 최대한 100kg에 가깝게 효율적으로 태워보내야함
        //어차피 2명이 제한이므로 가장 무거운사람과 가벼운 사람이 타는것이 효율적임
        int answer = 0;        
        int idx = 0;
        Arrays.sort(people);
        int min = 0;
        int max = people.length-1;
        while(min <= max) {
            if(people[min] + people[max] <= limit) {
                answer++;
                min++;
                max--;
            }
            else {
                answer++;
                max--;
            }
        }
        return answer;
    }
}