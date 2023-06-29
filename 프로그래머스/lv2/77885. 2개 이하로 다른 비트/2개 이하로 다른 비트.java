class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            String bi = Long.toString(numbers[i],2);    //2진수로 변환
                if(numbers[i] % 2 == 0){    //짝수이면
                    answer[i] = numbers[i]+1;   //1을 더한다
                }else{  //홀수
                    //가장 아래 자리에 있는 0 -> 1, 그보다 아래 자리수의 1 -> 0
                    int zero =  bi.lastIndexOf("0"); //0의 처음 등장 위치(오른쪽)
                    //zero부터 시작해서 1의 처음 등장 위치(왼쪽)
                    int one = bi.indexOf("1",zero);
                    if(zero == -1){ // -1을 반환 = 0이 없다
                        //맨앞의 10은 고정 나머지 0 -> 1
                        //10은 고정인 이유는 새 자릿수 1과 1에서 0으로 바뀐 것으로 이미 비트가 다른 지점이 2개이므로 나머지는 기존의 전부 1인것과 같이 1로 맞춰준다.
                        numbers[i] += 1;
                        bi =  Long.toString(numbers[i], 2);
                        bi = bi.substring(0, 2)+
                        bi.substring(2, bi.length()).replace("0","1");
                    }else{
                        bi = bi.substring(0, zero)+"1"+ //zero에 1
                        bi.substring(zero+1, one)+"0"+  //one에 0
                        bi.substring(one+1, bi.length());   //bi의 끝까지
                    }
                
                    answer[i] = Long.parseLong(bi, 2);
                }
        }
        
        return answer;
    }
}