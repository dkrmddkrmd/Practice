import java.util.*;

class Solution {
    static int answer = 1_000_000_000;
    static int stages;
    static boolean[] buyTicket;
    static int[][] nCost;
    static int[][] nHint;
    
    public int solution(int[][] cost, int[][] hint) {
        stages = cost.length;
        buyTicket = new boolean[stages];
        nCost = cost;
        nHint = hint;
        
        dfs(0);
        
        return answer;
    }
    
    static void dfs(int stage){
        if(stage == stages - 1){
            int pay = 0;
            int[] ticketNum = new int[stages];
            
            // 티켓 다 더하기
            for(int i = 0; i < stages - 1; i++){
                if(buyTicket[i]){
                    pay += nHint[i][0];
                    
                    for(int j = 1; j < nHint[i].length; j++){
                        ticketNum[nHint[i][j] - 1]++;
                    }
                }
            }
            
            // 최종 가격 구하기
            for(int i = 0; i < stages; i++){
                ticketNum[i] = Integer.min(ticketNum[i], stages - 1);
                
                pay += nCost[i][ticketNum[i]];
            }
            
            answer = Integer.min(answer, pay);
            
            return;
        }
        
        //buy
        
        buyTicket[stage] = true;
        
        dfs(stage + 1);
        
        buyTicket[stage] = false;
        
        //don't buy
        
        dfs(stage + 1);
    }
}