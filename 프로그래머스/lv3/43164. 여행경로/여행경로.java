import java.util.*;
class Solution {
    
    boolean[] visited;
    ArrayList<String> list; 
    
    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            list.add(route);
            return;
        }
        //ICN SFO ATL ICN ATL SFO
        //visited[0], visited[2] visited[3] visited[1] visited[4] 
        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, cnt);
        System.out.println(list.get(0));
        Collections.sort(list); //정렬 이해가 안감
        answer = list.get(0).split(" ");
        return answer;
    }
}