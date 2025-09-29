class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        
        int ind = myString.lastIndexOf(pat);
        
        answer = myString.substring(0, ind + pat.length());
        
        return answer;
    }
}