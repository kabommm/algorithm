class Solution {
    //변수 선언
    static boolean[] visited;
    static int answer = 0;
    //DFS 함수 구현
    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) { //단어가 target과 같으면 반환
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {   //방문했으면 패스
                continue;
            }

            int k = 0;    // 같은 스펠링의 개수
            for (int j = 0; j < begin.length(); j++) {
        //시작단어의 j+1번째 스펠링과 집합에 있는 i번째 단어의 j+1번째 스펠링이 같으면
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                visited[i] = true;  //방문체크
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }
}