import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int to;
    int cost;

    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

public class Main{
    static List<List<Node>> edgeToParty;
    static List<List<Node>> edgeToHome;

    static int[] distToParty;
    static int[] distToHome;

    static void dijkstra(int start, List<List<Node>> edge, int[] dist){
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(now.cost > dist[now.to])
                continue;

            for(Node next : edge.get(now.to)){
                int nextDist = next.cost + now.cost;

                if(nextDist < dist[next.to]){
                    dist[next.to] = nextDist;
                    pq.offer(new Node(next.to, nextDist));
                }
            }
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        edgeToParty = new ArrayList<>();
        edgeToHome = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            edgeToParty.add(new ArrayList<>());
            edgeToHome.add(new ArrayList<>());
        }

        distToParty = new int[N+1];
        distToHome = new int[N+1];

        Arrays.fill(distToParty, Integer.MAX_VALUE);
        Arrays.fill(distToHome, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeToParty.get(u).add(new Node(v, c));
            edgeToHome.get(v).add(new Node(u, c));
        }

        dijkstra(X, edgeToParty, distToParty);
        dijkstra(X, edgeToHome, distToHome);

        int maxVal = -1;
        for(int i = 1; i <= N; i++){
            maxVal = Math.max(maxVal, distToHome[i] + distToParty[i]);
        }

        System.out.println(maxVal);
    }
}