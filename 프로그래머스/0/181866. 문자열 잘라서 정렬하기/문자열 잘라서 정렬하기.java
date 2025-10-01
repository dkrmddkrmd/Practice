import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = {};
        
        answer = Arrays.stream(myString.split("x+"))
            .filter(s -> !s.isEmpty())
            .sorted()
            .toArray(String[]::new);
        
        return answer;
    }
}