class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for(char c : pat.toCharArray()){
            if(c == 'A'){
                sb.append('B');
            }
            else{
                sb.append('A');
            }
        }
        String str = sb.toString();
        if(myString.contains(str))
            answer = 1;
        
        return answer;
    }
}