import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String my_string) {
        String myTrimmedString = my_string.trim();
        
        String[] answer = myTrimmedString.split("\\s+");
        
        return answer;
    }
}