import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        ArrayList<String> list1 = new ArrayList<>();    //집합A
		ArrayList<String> list2 = new ArrayList<>();    //집합B

		ArrayList<String> u = new ArrayList<>();    //합집합
		ArrayList<String> n = new ArrayList<>();    //교집합

		//str1의 집합A
		for(int i = 0; i < str1.length()-1; i++) {
			char a = str1.charAt(i);
			char b = str1.charAt(i+1);
			// 둘다 문자라면, Character.isLetter()는 문자인지 참 거짓 반환 
			if(Character.isLetter(a) && Character.isLetter(b)) {
				list1.add((a+"") + (b+""));
			}
		}

		//str2의 집합B 
		for(int i = 0; i < str2.length()-1; i++) {
			char a = str2.charAt(i);
			char b = str2.charAt(i+1);
			// 둘다 문자라면
			if(Character.isLetter(a) && Character.isLetter(b)) {
				list2.add((a+"") + (b+""));
			}
        }
		
		//교집합
		for(String s : list1) {
			if(list2.remove(s)) { //삭제되었다면(같은 원소가 있었다는 뜻)
                //집합1에 집합2가 포함된다면 삭제후, 교집합에 추가 
				n.add(s);
            }
            u.add(s);
		}
		
		//합집합
		for(String s : list2) { //집합B에 남은 원소합집합에 추가 
			u.add(s);
		}
        
   		double jk = 0;
	
		if(u.size() == 0){  //두 집합이 모두 0 = 유사도는 1 
            jk = 1;	 
        }else{   //유사도 = 교집합 / 합집합
            jk = (double)n.size() / (double)u.size();
        }
        //둘다 가지는 원소 = n 일때u 교집합=min(A의 n개수,B의 n개수)
        //합집합=max(A의 n개수,B의 n개수)
        //두 글자씩 끊어서 집합생성,대소문자 구분x
        return (int)(jk*65536);
    }
}