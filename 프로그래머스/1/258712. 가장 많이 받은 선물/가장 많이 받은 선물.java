import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int fNum = friends.length;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < fNum; i++){
            map.put(friends[i], i);
        }
        
        int[][] gift = new int[fNum][fNum];
        int[] giftVal = new int[fNum];
        
        for(int i = 0; i < gifts.length; i++){
            String[] friend = gifts[i].split(" ");
            int num1 = map.get(friend[0]);
            int num2 = map.get(friend[1]);
            
            gift[num1][num2]++;
            giftVal[num1]++;
            giftVal[num2]--;
        }
        
        int[] getGift = new int[fNum];
        
        for(int i = 0; i < fNum; i++){
            for(int j = i + 1; j < fNum; j++){
                int num1 = map.get(friends[i]);
                int num2 = map.get(friends[j]);
                
                if(gift[num1][num2] < gift[num2][num1]){
                    getGift[num2]++;
                    continue;
                }
                else if(gift[num1][num2] > gift[num2][num1]){
                    getGift[num1]++;
                }
                else{
                    if(giftVal[num1] > giftVal[num2]){
                        getGift[num1]++;
                    }
                    else if(giftVal[num1] < giftVal[num2]){
                        getGift[num2]++;
                    }
                }
            }
        }
        
        int answer = -1;
        
        for(int i = 0; i < fNum; i++){
           answer = Integer.max(answer, getGift[i]); 
        }
        
        return answer;
    }
}