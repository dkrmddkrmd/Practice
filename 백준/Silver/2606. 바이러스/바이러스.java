import java.util.*;
import java.io.*;

public class Main{
    static int N, M, R;

    static List<List<Integer>> graph;

    static boolean[] visited;
    //static int[] visit;

    //static StringBuilder ans;
    //static int seq = 1;

    static void bfs(int start){
        visited[start] = true;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(start);
        //visit[start] = seq++;

        while (!deque.isEmpty()){
            int now = deque.pollFirst();
            for (int vec : graph.get(now)){
                if(!visited[vec]){
                    visited[vec] = true;
                    deque.offerLast(vec);
                    //visit[vec] = seq++;
                }
            }
        }
    }


    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        R = 1;

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        //ans = new StringBuilder();
        visited = new boolean[N+1];
        //visit = new int[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

//        for(int i = 1; i <= N; i++){
//            Collections.sort(graph.get(i));
//        }

        bfs(R);

        for(int i = 1; i <= N; i++){
            if(visited[i])
                ans++;
        }

        System.out.println(ans-1);
    }
}