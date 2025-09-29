import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        
        List<String> li = new ArrayList<>();
        
        for(String s : strArr){
            
            if(!s.contains("ad"))
                li.add(s);
        }
        
        answer = li.toArray(new String[0]);
        
        return answer;
    }
}