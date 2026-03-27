import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}

public class Main {
    static int V, E, K;
    static List<Node>[] nodes;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        nodes = new ArrayList[V+1];
        for(int i = 1; i <= V; i++){
            nodes[i] = new ArrayList<>();
        }
        dist = new int[V+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[u].add(new Node(v, w));
        }

        dijkstra(K);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight)
                continue;

            for(Node next : nodes[now.to]){
                if(dist[now.to] + next.weight < dist[next.to]){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }
}