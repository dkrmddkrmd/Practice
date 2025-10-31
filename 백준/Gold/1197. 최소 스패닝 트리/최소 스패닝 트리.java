import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class Main{
    static int V, E;

    static int[] parent;
    static List<Edge> edges;

    static int find(int x){
        if(x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY)
            return;

        parent[rootY] = rootX;
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }
        edges = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A, B, C));
        }

        Collections.sort(edges);

        int totalSum = 0;
        int totalEdge = 0;

        for(Edge edge : edges){
            if(find(edge.from) != find(edge.to)){
                union(edge.from, edge.to);
                totalSum += edge.cost;
                totalEdge++;
                if(totalEdge == V - 1){
                    break;
                }
            }
        }

        System.out.println(totalSum);
    }
}