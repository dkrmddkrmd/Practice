import java.util.*;

class Point{
    int row;
    int col;
    
    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    static int[][] POINTS;
    static int[][] ROUTES;
    static Point[] robots;
    static List<Point>[] robotTrace;
    static int maxTime = 0;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        //init
        POINTS = points;
        ROUTES = routes;
        robots = new Point[routes.length];
        robotTrace = new ArrayList[robots.length];
        
        for(int i = 0; i < robots.length; i++){
            robots[i] = new Point(points[routes[i][0] - 1][0], points[routes[i][0] - 1][1]);
            robotTrace[i] = new ArrayList<>();
            robotTrace[i].add(new Point(robots[i].row, robots[i].col));
        }
        
        answer = simulation();
        
        return answer;
    }
    
    static int simulation(){
        int totalCount = 0;
        
        for(int i = 0; i < robots.length; i++){
            // 각 로봇 별로 이동
            move(i);
        }
        
        // 겹치는 곳 확인
        int[][] map = new int[101][101];
        
        for(int i = 0; i <= maxTime; i++){
            for(int j = 0; j < robots.length; j++){
                if(i >= robotTrace[j].size()){
                    continue;
                }
                
                int row = robotTrace[j].get(i).row;
                int col = robotTrace[j].get(i).col;
                
                map[row][col]++;
                
                if(map[row][col] == 2)
                    totalCount++;
            }
            
            for(int j = 0; j < map.length; j++){
                Arrays.fill(map[j], 0);
            }
        }
        
        return totalCount;
    }
    
    static void move(int num){
        // 다음 가야할 루트
        int next = 1;
        int nextRow = POINTS[ROUTES[num][next] - 1][0];
        int nextCol = POINTS[ROUTES[num][next] - 1][1];
        
        for(int i = 1; ; i++){
            // 만약 row가 다르면 이동
            if(robots[num].row != nextRow){
                robots[num].row = robots[num].row > nextRow ? robots[num].row - 1 : robots[num].row + 1; 
            }
            else{
                robots[num].col = robots[num].col > nextCol ? robots[num].col - 1 : robots[num].col + 1; 
            }
            
            robotTrace[num].add(new Point(robots[num].row, robots[num].col));
            
            if(goDest(num, next)){
                next++;
                
                // 최종 목적지 도착
                if(next == ROUTES[num].length){
                    maxTime = Integer.max(maxTime, i);
                    break;
                }
                
                nextRow = POINTS[ROUTES[num][next] - 1][0];
                nextCol = POINTS[ROUTES[num][next] - 1][1];
            }
        }
    }
    
    static boolean goDest(int num, int next){
        return (robots[num].row == POINTS[ROUTES[num][next] - 1][0] && robots[num].col == POINTS[ROUTES[num][next] - 1][1]);
    }
}