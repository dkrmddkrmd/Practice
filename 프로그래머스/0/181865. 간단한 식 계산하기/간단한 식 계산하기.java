class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        int a = 0, b = 0;
        int len = binomial.length();
        int place = 0;
        
        for(int i = 0; i < len; i++){
            int num = binomial.charAt(i) - '0';
            if(num >= 0 && num <= 9){
                continue;
            }
            else{
                place = i;
                break;
            }
        }
        
        a = Integer.parseInt(binomial.substring(0, place));
        b = Integer.parseInt(binomial.substring(place + 3, len));
        if(binomial.charAt(place + 1) == '+'){
            answer = a + b;
        }
        else if(binomial.charAt(place + 1) == '-'){
            answer = a - b;
        }
        else{
            answer = a * b;
        }
        
        return answer;
    }
}