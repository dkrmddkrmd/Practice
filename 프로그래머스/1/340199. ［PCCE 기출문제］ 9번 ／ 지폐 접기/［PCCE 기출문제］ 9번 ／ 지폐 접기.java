class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int big = Integer.max(bill[0], bill[1]);
        int small = Integer.min(bill[0], bill[1]);
        
        int wBig = Integer.max(wallet[0], wallet[1]);
        int wSmall = Integer.min(wallet[0], wallet[1]);
        
        while(big > wBig || small > wSmall){
            big /= 2;
            
            if(big < small){
                int temp = big;
                big = small;
                small = temp;
            }
            
            answer++;
        }
        
        return answer;
    }
}