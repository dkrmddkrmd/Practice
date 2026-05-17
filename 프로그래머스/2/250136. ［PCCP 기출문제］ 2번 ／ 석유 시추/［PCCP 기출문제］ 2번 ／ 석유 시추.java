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
    static int n, m;
    static int[] totalPetrol;
    static int[][] LAND;
    static boolean[] findCol;
    
    // 상 우 하 좌
    static int[] dirR = {-1, 0, 1, 0};
    static int[] dirC = {0, 1, 0, -1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        findCol = new boolean[m];
        totalPetrol = new int[m];
        LAND = land;
        
        checkLand();
        
        for(int i = 0; i < m; i++){
            answer = Integer.max(answer, totalPetrol[i]);
        }
        
        return answer;
    }
    
    static void checkLand(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(LAND[i][j] == 1)
                    bfs(i, j);
            }
        }
    }
    
    static void bfs(int r, int c){
        Deque<Point> d = new ArrayDeque<>();
        
        d.offerLast(new Point(r, c));
        LAND[r][c] = 2;
        
        // 총 석유량
        int count = 0;
        
        while(!d.isEmpty()){
            Point now = d.pollFirst();
            
            // 현재 석유 추가 및 추가할 열 체크
            count++;
            findCol[now.col] = true;
            
            // 상하좌우 체크
            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dirR[i];
                int nextCol = now.col + dirC[i];
                
                if(checkPetrol(nextRow, nextCol)){
                    LAND[nextRow][nextCol] = 2;
                    d.offerLast(new Point(nextRow, nextCol));
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            if(findCol[i])
                totalPetrol[i] += count;
        }
        
        // findCol 초기화
        Arrays.fill(findCol, false);
    }
    
    static boolean checkPetrol(int row, int col){
        return (row >= 0 && row < n && col >= 0 && col < m && LAND[row][col] == 1);
    }
}
