class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        int myLen = myString.length();
        int patLen = pat.length();
        
        // 1. 반복문 범위를 수정 (<=)
        for (int i = 0; i <= myLen - patLen; i++) {
            boolean isSame = true;
            for (int j = 0; j < patLen; j++) {
                // 2. charAt()으로 문자에 접근
                if (myString.charAt(i + j) != pat.charAt(j)) {
                    isSame = false;
                    // 3. 다른 문자를 찾으면 즉시 안쪽 반복문 탈출 (break)
                    break; 
                }
            }
            
            if (isSame) {
                answer++;
            }
        }
        
        return answer;
    }
}