class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] rooms = new int[1450];    //24*60+10

        for (int i=0; i<book_time.length; i++) {
            String inTime = book_time[i][0];
            String outTime = book_time[i][1];

            rooms[calTime(inTime)] += 1; // 입실 시간
            rooms[calTime(outTime) + 10] += -1; // 퇴실 + 청소 시간
        }

        // 누적합
        for (int i = 1; i < 1450; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);    //가장 높은 순간이 방의 수
        }
        return answer;
    }
    //문자로 받은 시간 -> 숫자
    private static int calTime(String time){
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        return ((Integer.parseInt(hour) * 60) + Integer.parseInt(minute));
    }
}