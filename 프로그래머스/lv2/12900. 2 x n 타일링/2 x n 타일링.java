class Solution {
    public int solution(int n) {
        int answer = 0;
        // 가로의길이 n을 2와 1의 조합과 순서의 경우의 수
        // 규칙을 찾는다 n=1...1, n=2...2, n=3...3, n=4...5
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; i++) {   //피보나치 수열
          answer = (a + b) % 1000000007;

          a = b;
          b = answer;
        }
        return answer;
    }
}