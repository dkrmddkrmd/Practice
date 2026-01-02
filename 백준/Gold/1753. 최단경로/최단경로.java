import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    public int compareTo(Node node){
        return this.cost - node.cost;
    }
}

public class Main{
    static int V, E, K;

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int dist[] = new int[V+1];
        ArrayList<Node>[] adj = new ArrayList[V+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        for(int i = 1; i <= V; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, e));
        }

        pq.offer(new Node(K, 0));
        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.index] < now.cost)
                continue;

            for (Node node : adj[now.index]){
                if(dist[node.index] > dist[now.index] + node.cost){
                    dist[node.index] = dist[now.index] + node.cost;
                    pq.offer(new Node(node.index, dist[node.index]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
            }
            else{
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}