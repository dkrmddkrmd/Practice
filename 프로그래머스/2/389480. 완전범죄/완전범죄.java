import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1000000;
        int answer = INF;
        
        int dp[] = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int i = 0; i < info.length; i++){
            int aVal = info[i][0];
            int bVal = info[i][1];

            for(int j = m - 1; j >= 0; j--){
                int aChoice = dp[j] + aVal;
                
                int bChoice = INF;
                if(j >= bVal)
                    bChoice = dp[j - bVal];
                
                dp[j] = Integer.min(aChoice, bChoice);
            }
        }
        
        for(int i = 0; i < m; i++){
            answer = Integer.min(answer, dp[i]);
        }
        
        if(answer >= n)
            return - 1;
        
        return answer;
    }
}