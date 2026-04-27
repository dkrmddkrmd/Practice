import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int workers = schedules.length;
        
        int answer = workers;
        
        boolean eventFail[] = new boolean[workers];
        
        for(int i = 0; i < workers; i++){
            int schedule = schedules[i];
            int scheduleHour = schedule / 100;
            int scheduleMinute = schedule % 100;
            
            int nowDay = startday;
            
            scheduleMinute += 10;
            if(scheduleMinute >= 60){
                scheduleHour++;
                scheduleMinute -= 60;
            }

            
            for(int j = 0; j < 7; j++, nowDay++){
                if(nowDay == 6 || nowDay == 7 || nowDay == 13){
                    continue;
                }
                
                int time = timelogs[i][j];
                int timeHour = time / 100;
                int timeMinute = time % 100;
                
                if(scheduleHour > timeHour)
                    continue;
                else if(scheduleHour < timeHour){
                    eventFail[i] = true;
                    break;
                }
                else{
                    if(scheduleMinute >= timeMinute)
                        continue;
                    else{
                        eventFail[i] = true;
                        break;
                    }
                }
            }
        }
        int wrong = 0;
        
        for(int i = 0; i < workers; i++){
            if(eventFail[i]){
                wrong++;
            }
        }
        
        answer -= wrong;
        
        return answer;
    }
}