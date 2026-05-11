import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;        
        Set<Integer> s = new HashSet<>();
        
        for(int i = 1; i <= n - 4; i++){
            s.add(i);
            for(int j = i + 1; j <= n - 3; j++){
                s.add(j);
                for(int k = j + 1; k <= n - 2; k++){
                    s.add(k);
                    for(int l = k + 1; l <= n - 1; l++){
                        s.add(l);
                        for(int m = l + 1; m <= n; m++){
                            s.add(m);
                            boolean isAns = true;
                            
                            for(int o = 0; o < q.length; o++){
                                int countAns = 0;
                                for(int p = 0; p < 5; p++){
                                    if(s.contains(q[o][p]))
                                        countAns++;
                                }
                                if(countAns != ans[o]){
                                    isAns = false;
                                    break;
                                }
                            }
                            
                            if(isAns)
                                answer++;
                            
                            s.remove(m);
                        }
                        s.remove(l);
                    }
                    s.remove(k);
                }
                s.remove(j);
            }
            s.remove(i);
        }
        
        return answer;
    }
}