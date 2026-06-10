import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 0; i < answer.length; i++){
            m.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            String now = callings[i];
            int rank = m.get(now);
            
            String player = answer[rank - 1];
            
            answer[rank] = player;
            answer[rank - 1] = now;
            
            m.replace(now, rank - 1);
            m.replace(player, rank);
        }
        
        return answer;
    }
}