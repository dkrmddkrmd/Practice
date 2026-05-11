import java.util.*;

class Solution {
    static int N;
    static int[][] Q;
    static int[] ANS;
    static int answer = 0;
    static Set<Integer> picked;
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        ANS = ans;
        
        picked = new HashSet<>();
        
        dfs(1, 0);
        
        return answer;
    }
    
    static void dfs(int start, int depth){
        if(depth == 5){
            if(findAns())
                answer++;
            return;
        }
        
        for(int i = start; i <= N; i++){
            picked.add(i);
            
            dfs(i + 1, depth + 1);
            
            picked.remove(i);
        }
    }
    
    static boolean findAns(){
        for(int i = 0; i < Q.length; i++){
            int count = 0;
            for(int j = 0; j < Q[i].length; j++){
                if(picked.contains(Q[i][j]))
                    count++;
            }
            if(count != ANS[i])
                return false;
        }
        return true;
    }
}