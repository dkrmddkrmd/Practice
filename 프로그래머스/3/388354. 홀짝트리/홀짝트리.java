import java.util.*;

class Solution {
    int SIZE = 100_0001;
    List<Integer>[] node;
    boolean[] isVisit;
    List<List<Integer>> trees;
    
    int[] NODES;
    
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        NODES = nodes;
        
        node = new ArrayList[SIZE];
        isVisit = new boolean[SIZE];
        trees = new ArrayList<>();
        
        for(int i = 0; i < nodes.length; i++){
            node[nodes[i]] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            node[u].add(v);
            node[v].add(u);
        }
        
        bfs();
        
        answer = findAns();
        
        return answer;
    }
    
    void bfs(){
        for(int i = 0; i < NODES.length; i++){
            int num = NODES[i];
            
            if(isVisit[num]) continue;
            
            List<Integer> l = new ArrayList<>();
            Deque<Integer> dq = new ArrayDeque<>();
            
            l.add(num);
            dq.add(num);
            isVisit[num] = true;
            
            while(!dq.isEmpty()){
                int now = dq.pollFirst();
                
                for(int next : node[now]){
                    if(!isVisit[next]){
                        isVisit[next] = true;
                        l.add(next);
                        dq.offerLast(next);
                    }
                }
                
            }
            
            trees.add(l);
        }
    }
    
    int[] findAns(){
        int first = 0;
        int second = 0;
        
        for(List<Integer> l : trees){
            int[] counts = new int[4];
            
            for(int now : l){
                // 0 홀수면서 연관 노드 홀수개
                // 1 홀수면서 연관 노드 짝수개
                // 2 짝수면서 연관 노드 홀수개
                // 3 짝수면서 연관 노드 짝수개
                
                // 홀짝트리 - 모두 0이거나 3이여야함 -> 그 중 하나만 1이거나 2면 됨
                // 역홀짝 트리 - 모두 1이거나 2이여야함 -> 그 중 하나만 0이거나 3
                
                if(now % 2 != 0){
                    if(node[now].size() % 2 != 0)
                        counts[0]++;
                    else
                        counts[1]++;
                }
                else{
                    if(node[now].size() % 2 != 0)
                        counts[2]++;
                    else
                        counts[3]++;
                }
            }
            
            if(counts[0] + counts[3] == 1)
                first++;
            
            if(counts[1] + counts[2] == 1)
                second++;
            
        }
        
    
        return new int[] {first, second};
    }
}