import java.util.*;

class Container{
    int row;
    int col;
    
    public Container(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    // 상 우 하 좌
    static int[] dirR = {-1, 0, 1, 0};
    static int[] dirC = {0, 1, 0, -1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        int n = storage.length;
        int m = storage[0].length();
        
        int[][] sto = new int[n+2][m+2];
        
        for(int i = 0; i < n; i++){
            String str = storage[i];
            
            for(int j = 0; j < m; j++){
                sto[i+1][j+1] = (int) str.charAt(j);
            }
        }
        
        // 내부 삭제 -> -1 및
        // 외부 삭제 -> -1
        
        for(int i = 0; i < requests.length; i++){
            String str = requests[i];
            int container = (int) str.charAt(0);
            
            Queue<Container> q = new LinkedList<>();
            
            if(str.length() == 2){
                // 크레인                
                for(int j = 1; j <= n; j++){
                    for(int k = 1; k <= m; k++){
                        if(sto[j][k] == container){
                            if(checkOutside(sto, j, k))
                                q.offer(new Container(j, k));
                            else
                                sto[j][k] = -1;
                        }
                    }
                }
                
            }
            else{
                // 외부 컨테이너 제거
                for(int j = 1; j <= n; j++){
                    for(int k = 1; k <= m; k++){
                        if(sto[j][k] == container && checkOutside(sto, j, k))
                            q.offer(new Container(j, k));
                    }
                }
            }
            
            Queue<Container> followQ = new LinkedList<>();
            
            //다시 0으로 바꾸기
            while(!q.isEmpty()){
                Container c = q.poll();
                sto[c.row][c.col] = 0;
                followQ.offer(c);
            }
            
            while(!followQ.isEmpty()){
                Container c = followQ.poll();
                
                for(int j = 0; j < 4; j++){
                    int nextR = c.row + dirR[j];
                    int nextC = c.col + dirC[j];
                    
                    if(sto[nextR][nextC] == -1){
                        sto[nextR][nextC] = 0;
                        followQ.offer(new Container(nextR, nextC));
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(sto[i][j] > 0)
                    answer++;
            }
        }
        
        return answer;
    }
    
    static boolean checkOutside(int[][] sto, int row, int col){
        for(int i = 0; i < 4; i++){
            if(sto[row + dirR[i]][col + dirC[i]] == 0)
                return true;
        }
        
        return false;
    }
}