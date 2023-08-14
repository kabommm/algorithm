class Solution {
    //1. 변수 선언
    int answer = 0;
    //2. dfs 함수 구현
    public void dfs(int[] numbers, int index, int target, int sum){
        if(index == numbers.length){ // 마지막 노드 까지 탐색 끝
            if(target == sum){  //끝까지 탐색한 값이 타겟넘버와 같으면
                answer++; //방법+1
            }
        } else {    //마지막 노드까지 계속 탐색
            dfs(numbers, index + 1, target, sum + numbers[index]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(numbers, index + 1, target, sum - numbers[index]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }
    }
    //3. 메인함수
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0);
        return answer;
    }
}