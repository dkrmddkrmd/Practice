import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {        
        long[] BANS = new long[bans.length];
        for(int i = 0; i < bans.length; i++){
            BANS[i] = changeToLong(bans[i]);
        }
        
        Arrays.sort(BANS);
        
        for(long num : BANS){
            if(num <= n)
                n++;
            else
                break;
        }
        
        return changeToString(n);
    }
    
    static long changeToLong(String str){
        long num = 0;
        
        for(int i = 0; i < str.length(); i++){
            num = num * 26 + (str.charAt(i) - 'a' + 1);
        }
        return num;
    }
    
    static String changeToString(long num){
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            long rem = (num - 1) % 26;
            sb.append((char) (rem + 'a'));
            num = (num - 1) / 26;
        }
        
        return sb.reverse().toString();
    }
}