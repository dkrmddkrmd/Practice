import java.util.*;
import java.io.*;

public class Main{
    static int N, M, V;

    static List<List<Integer>> graph;
    static boolean[] visited1;
    static int[] visit1;
    static int seq1 = 1;

    static StringBuilder sb1;
    static StringBuilder sb2;

    static void dfs(int start){
        visited1[start] = true;
        visit1[seq1++] = start;

        for(int next : graph.get(start)){
            if(!visited1[next]){
                dfs(next);
            }
        }
    }

    static void bfs(int start){
        visited1[start] = true;
        visit1[seq1++] = start;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(start);

        while (!deque.isEmpty()){
            int now = deque.pollFirst();
            for (int next : graph.get(now)){
                if(!visited1[next]){
                    visited1[next] = true;
                    visit1[seq1++] = next;
                    deque.offerLast(next);
                }
            }
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited1 = new boolean[N+1];
        visit1 = new int[N+1];
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++){
            Collections.sort(graph.get(i));
        }

        dfs(V);
        for (int i =1; i <= N; i++){
            if(visit1[i] != 0)
                sb1.append(visit1[i]).append(" ");
        }
        Arrays.fill(visited1, false);
        seq1 = 1;
        sb1.append("\n");
        bfs(V);
        for (int i =1; i <= N; i++){
            if(visit1[i] != 0)
                sb1.append(visit1[i]).append(" ");
        }


        System.out.println(sb1);

    }
}