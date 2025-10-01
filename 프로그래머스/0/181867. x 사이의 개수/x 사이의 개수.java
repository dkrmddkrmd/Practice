import java.util.*;

class Solution {
    public int[] solution(String myString) {
        // 1. limit을 -1로 주어 마지막 빈 문자열도 포함하도록 split
        String[] myStr = myString.split("x", -1);
        
        // 2. 배열의 길이는 .length 속성을 사용
        int[] answer = new int[myStr.length];
        
        for(int i = 0; i < myStr.length; i++){
            answer[i] = myStr[i].length();
        }
        
        return answer;
    }
}