class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String str : skill_trees){  //배열의 원소를 하나씩 검사
            String result = str;
            for(int i=0; i<str.length(); i++){
            //단어의 한 글자씩 추출
                String s = str.charAt(i) + "";
                if(!skill.contains(s)){ //스킬에 포함되어있지 않으면
                    result = result.replace(s,"");  //공백으로 대체
                }   //->result는 스킬에 포함되는 단어만으로 구성
            }
            //skill에서 result부분이 처음 등장하는 부분이 맨앞이면 answer++
            if(skill.indexOf(result) == 0){
                answer++;
            }
        }
        
        return answer;
    }
}