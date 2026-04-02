import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = 0;

        // 신호등 개수
        int signalCount = signals.length;
        
        // 신호등 패턴
        boolean[][] yellowSignals = new boolean[signalCount][21];
        
        // 신호등 길이
        int[] signalTime = new int[signalCount];
        
        // 현재 신호등 위치
        int[] signalPlace = new int[signalCount];
        Arrays.fill(signalPlace, 1);
        
        // 최대 시간
        int maxTime = 0;
        
        for(int i = 0; i < signalCount; i++){
            signalTime[i] = signals[i][0] + signals[i][1] + signals[i][2];
            for(int j = signals[i][0] + 1; j <= signals[i][0] + signals[i][1]; j++){
                yellowSignals[i][j] = true;
            }
        }
        
        maxTime = lcm(signalTime[0], signalTime[1]);
        for(int i = 2; i < signalCount; i++){
            maxTime = lcm(maxTime, signalTime[i]);
        }
        
        for(int sec = 1; sec <= maxTime; sec++){
            boolean isYellow = true;
            
            for(int i = 0; i < signalCount; i++){
                if(!yellowSignals[i][signalPlace[i]])
                    isYellow = false;
                
                signalPlace[i]++;
                if(signalPlace[i] == signalTime[i] + 1)
                    signalPlace[i] = 1;
            }
            
            if(isYellow){
                answer = sec;
                break;
            }
        }
        
        if(answer == 0)
            answer = -1;
        
        return answer;
    }
    
    static int gcd(int a, int b){
        if(a < b){
            int temp = b;
            b = a;
            a = temp;
        }
        
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
    
    static int lcm(int a, int b){
        return (a / gcd(a, b)) * b;
    }
}