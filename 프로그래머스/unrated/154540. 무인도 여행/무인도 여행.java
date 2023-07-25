import java.util.*;
class Solution {
    
    // 변수 선언
    static int sum=0;
    
    public void dfs(String[] maps, boolean[][] visited, int i, int j) {
        //범위 밖 무시
    	if(i<0 || j<0 || i>=maps.length || j>=maps[0].length()){
            return;    
        }
        //무인도거나 방문했다면
    	if(maps[i].charAt(j) == 'X' || visited[i][j]){
            return;    
        }else { //범위 안의 방문하지 않은 섬
    		visited[i][j]=true; //방문처리
    		sum += maps[i].charAt(j)-'0';   //해당 문자를 숫자 처리한 값을 더함
    	}
        //상하좌우 반복
    	dfs(maps, visited, i+1, j);
    	dfs(maps, visited, i-1, j);
    	dfs(maps, visited, i, j+1);
    	dfs(maps, visited, i, j-1);
    }
    
    //리스트를 반환하기 위해 int[] -> List<Integer> 
    public List<Integer> solution(String[] maps) {  
        //정답 리스트
        List<Integer> list = new ArrayList<>();
        //방문 배열
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        //순회
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                dfs(maps, visited, i, j);
        		if(sum>0) {
        			list.add(sum);
        			sum=0;
        		}
            }
        }
        
        if(list.size()==0){
            list.add(-1);
        }
        //리스트 오름차순 정렬
        Collections.sort(list);
        return list;

    }
}