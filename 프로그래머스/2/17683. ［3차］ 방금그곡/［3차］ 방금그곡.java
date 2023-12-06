import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        int time = 0;

        m = edit(m);

        for (int inx = 0; inx < musicinfos.length; inx++) {

            String[] info = musicinfos[inx].split(",");

            int start = (60 * Integer.parseInt(info[0].substring(0, 2)) + Integer.parseInt(info[0].substring(3)));
            int end = (60 * Integer.parseInt(info[1].substring(0, 2)) + Integer.parseInt(info[1].substring(3)));
            int t = end - start;

            if (t > time) {
                info[3] = edit(info[3]);
                StringBuffer sb = new StringBuffer();
                for (int jnx = 0; jnx < t; jnx++) {
                    sb.append(info[3].charAt(jnx % (info[3].length())));
                }
                if (sb.toString().indexOf(m) >= 0) {
                    answer = info[2];
                    time = t;
                }
            }
        }

        return answer;
    }

    public String edit(String m) {

        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");

        return m;
//         String answer = "(None)";
//         StringBuilder sb = new StringBuilder();
        
//         List<int[]> list = new ArrayList<>();
        
//         for(int i = 0; i < m.length(); i++){
            
//             if(i < m.length()-1){
//                 //# 건너뛰기, #전은 소문자
//                 if(m.charAt(i) != '#' && m.charAt(i+1) == '#'){
//                     sb.append((m.charAt(i)+"").toLowerCase());
//                     i++;
//                 }else{
//                     sb.append(m.charAt(i));
//                 }
//             }else{  //마지막은 #이 아닌경우만 저장
//                 if(m.charAt(i) != '#'){
//                     sb.append(m.charAt(i));
//                 }
//             }
//         }
        
//         for(int i = 0; i < musicinfos.length; i++){
//             String[] split = musicinfos[i].split(",");
            
//             String startTime = split[0];
//             String endTime = split[1];
//             String title = split[2];
//             String sing = split[3];
            
//             String[] starths = startTime.split(":");
//             String[] endhs = endTime.split(":");
            
//             int startHour = Integer.parseInt(starths[0]);
//             int endHour = Integer.parseInt(endhs[0]);
            
//             int startSec = Integer.parseInt(starths[1]);
//             int endSec = Integer.parseInt(endhs[1]);
            
//             int term = (endHour*60 + endSec) - (startHour*60 + startSec);
            
//             StringBuilder sing2 = new StringBuilder();
            
//             int idx = 0;
//             for(int j = 0; j < term; j++){
//                 //음악 길이보다 재생된 시간이 길 때 -> 처음부터 반복해서 재생
//                 if(idx > sing.length()-1){
//                     idx = 0;
//                 }
//                 //음악 길이보다 재생된 시간이 짧을 때 -> 처음부터 재생 시간만큼만 재생
//                 if(idx < sing.length()-1){//# 건너뛰기, #전은 소문자
//                     if(sing.charAt(idx) != '#' && sing.charAt(idx+1) == '#'){
//                         sing2.append((sing.charAt(idx)+"").toLowerCase());
//                         idx++;
//                     }else{//마지막은 #이 아닌경우만 저장
//                         if(sing.charAt(idx) != '#'){
//                             sing2.append(sing.charAt(idx));
//                         }
//                     }
//                 }else{
//                     sing2.append(sing.charAt(idx));
//                 }
                
//                 idx++;
//             }
            
            
//             for(int j = 0; j < m.length(); j++){
//                 if((sing2.toString()).contains(sb.toString())){
//                     int[] a = new int[2];
//                     a[0] = term;
//                     a[1] = i;
//                     list.add(a);
//                 }
                
//             }
            
//         }
        
//         Collections.sort(list, (o1, o2) -> {
//             if(o1[0] < o2[0]){
//                 return 1;
//             }else if(o1[0] > o2[0]){
//                 return -1;
//             }else{
//                 return Integer.compare(o1[1], o2[1]);
//             }
//         });
        
//         if(list.size() != 0){
//             answer = musicinfos[list.get(0)[1]].split(",")[2];
//         }
        
//         return answer;
    }
}