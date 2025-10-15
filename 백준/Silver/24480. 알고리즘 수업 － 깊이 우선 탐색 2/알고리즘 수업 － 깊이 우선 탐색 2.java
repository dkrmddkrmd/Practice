import java.util.*;
import java.io.*;

public class Main{
    static int N, M, R;

    static List<List<Integer>> graph;

    static boolean[] visited;
    static int[] visit;

    static StringBuilder ans;
    static int seq = 1;

    static void dfs(int start){
        visited[start] = true;
        visit[start] = seq++;

        for(int nextVec : graph.get(start)){
            if(!visited[nextVec]){
                dfs(nextVec);
            }
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        ans = new StringBuilder();

        visited = new boolean[N+1];
        visit = new int[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(R);

        for(int i = 1; i <= N; i++){
            ans.append(visit[i]).append("\n");
        }

        System.out.println(ans);
    }
}