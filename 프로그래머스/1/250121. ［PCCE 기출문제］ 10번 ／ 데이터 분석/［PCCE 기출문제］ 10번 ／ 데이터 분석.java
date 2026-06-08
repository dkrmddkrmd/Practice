import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        List<String> datas = Arrays.asList("code", "date", "maximum", "remain");
        
        int extNum = datas.indexOf(ext);
        int sortNum = datas.indexOf(sort_by);
        
        return Arrays.stream(data)
                    .filter(row -> row[extNum] < val_ext)
                    .sorted(Comparator.comparingInt(row -> row[sortNum]))
                    .toArray(int[][]::new);
    }
}