class Solution {
    public String solution(String new_id) {
        //.는 처음과 끝 사용x, 연속으로 사용x
        String answer;
        
        // 1단계
        String lower = new_id.toLowerCase();

        // 2단계
        char[] arr = lower.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        // 3단계
        String dot = sb.toString().replace("..", ".");
        while (dot.contains("..")) {
            dot = dot.replace("..", ".");
        }

        // 4단계
        if (dot.length() > 0) {
            if (dot.charAt(0) == '.') {
                dot = dot.substring(1, dot.length());
            }
        }
        if (dot.length() > 0) {
            if (dot.charAt(dot.length() - 1) == '.') {
                dot = dot.substring(0, dot.length() - 1);
            }
        }

        // 5단계
        if (dot.equals("")) {
            dot = "a";
        }

        // 6단계
        if (dot.length() >= 16) {
            dot = dot.substring(0, 15);

            if (dot.charAt(dot.length() - 1) == '.') {
                dot = dot.substring(0, dot.length() - 1);
            }
        }

        // 7단계
        StringBuilder ans = new StringBuilder(dot);
        if (ans.length() <= 2) {
            char last = ans.charAt(ans.length() - 1);

            while (ans.length() < 3) {
                ans.append(last);
            }
        }

        answer = String.valueOf(ans);
        return answer;
    }
}