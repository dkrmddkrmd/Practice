import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int healCount = bandage[0]; // 시전 시간
        int hps = bandage[1]; // 초당 회복량
        int plusHeal = bandage[2]; // 추가 회복량
        int hp = health; // 피
        int totalAttack = attacks.length; // 총 공격 횟수
        int attackCount = 0; // 공격 당한 횟수
        int time = 0; // 시간
        int healTime = 0; // 현재 붕대 시전 시간
        
        while(attackCount != totalAttack){
            time++;
            
            if(time == attacks[attackCount][0]){
                // 맞을 시간
                hp -= attacks[attackCount][1];
                if(hp <= 0){
                    return -1;
                }
                attackCount++;
                healTime = 0;
                
                continue;
            }
            
            hp += hps;
            
            healTime++;
            if(healTime == healCount){
                healTime = 0;
                hp += plusHeal;
            }
            
            hp = Integer.min(hp, health);
        
        }
        
        
        return hp;
    }
}