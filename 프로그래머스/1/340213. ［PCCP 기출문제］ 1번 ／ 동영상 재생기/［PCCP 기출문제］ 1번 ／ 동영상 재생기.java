class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {        
        int time = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);
        int len = toSec(video_len);
        
        for(int i = 0; i < commands.length; i++){
            if(opStart <= time && time <= opEnd) time = opEnd;
            
            if(commands[i].equals("prev")) time = Integer.max(0, time - 10);
            else time = Integer.min(len, time + 10);
            
            if(opStart <= time && time <= opEnd) time = opEnd;
        }
        
        return toStr(time);
    }
    
    static int toSec(String time){
        return (Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5)));
    }
    
    static String toStr(int time){
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}