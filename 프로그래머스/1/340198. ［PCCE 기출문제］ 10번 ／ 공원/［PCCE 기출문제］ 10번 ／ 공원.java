import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int parkRow = park.length;
        int parkCol = park[0].length;
        
        Arrays.sort(mats);
        
        for(int i = mats.length - 1; i >= 0; i--){
            int size = mats[i];
            
            for(int j = 0; j < parkRow - size + 1; j++){
                for(int k = 0; k < parkCol - size + 1; k++){
                    if(findMat(park, j, k, size))
                        return size;
                }
            }
        }

        return -1;
    }
    
    boolean findMat(String[][] park, int row, int col, int size){
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(!park[i][j].equals("-1"))
                    return false;
            }
        }
        return true;
    }
}