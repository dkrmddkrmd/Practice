import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 서버 증설 횟수
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < players.length; i++){
            int player = players[i];
            
            int needServerNum = player / m; 
            
            int nowServerNum = pq.size();
            
            if(nowServerNum < needServerNum){
                int nowPlusServer = needServerNum - nowServerNum;
                
                for(int j = 0; j < nowPlusServer; j++){
                    pq.offer(i + k - 1);
                }
                
                answer += nowPlusServer;
            }
            
            while(!pq.isEmpty() && pq.peek() <= i)
                pq.poll();
        }
        
        return answer;
    }
}