import java.util.*;

class Solution {
    static int[] DIFFS;
    static int[] TIMES;
    static long LIMIT;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        DIFFS = diffs;
        TIMES = times;
        LIMIT = limit;
        
        int low = 1;
        int high = 100000;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(canSolve(mid)){
                answer = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return answer;
    }
    
    static boolean canSolve(int num){
        long time = 0;
        
        for(int i = 0; i < DIFFS.length; i++){
            int diff = DIFFS[i] - num;
            
            if(diff > 0 && i != 0){
                time += (diff * (TIMES[i-1] + TIMES[i]));
            }
            
            time += TIMES[i];
        }
        
        if(time <= LIMIT)
            return true;
        
        return false;
    }
}