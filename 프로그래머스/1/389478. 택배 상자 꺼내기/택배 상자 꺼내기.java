class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 총 층수
        int floors = ((n - 1) / w) + 1;
        
        // num의 층수
        int numFloor = ((num - 1) / w) + 1;
        
        // 가장 끝 택배의 왼쪽 인덱스
        int topLeftInd = leftIndex(floors, n, w);
        
        // num의 왼쪽 인덱스
        int numLeftInd = leftIndex(numFloor, num, w);
        
        // 기본적으로 개수는
        answer = floors - numFloor;
        
        // 만약 총 층수가 홀수라면 numLeftInd가 더 작아야함 반대면 더 커야함
        if((floors % 2 != 0) && (numLeftInd <= topLeftInd))
            answer++;
        
        if((floors % 2 == 0) && (numLeftInd >= topLeftInd))
            answer++;
        
        return answer;
    }
    
    static int leftIndex(int floor, int num, int w){
        // floor 층에서 num이 몇 번째에 있는지 (왼쪽 기준으로)
        
        int stuff = (num-1) % w;
        int leftInd = 0;
        
        if(floor % 2 == 0){
            leftInd = w - stuff;
        }
        else{
            leftInd = stuff + 1;
        }
        
        return leftInd;
    }
}