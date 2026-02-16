import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static ArrayList<Vertex> adj;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }

        adj = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj.add(new Vertex(A, B, C));
        }

        Collections.sort(adj);

        int connection = 0;
        int ans = 0;

        for(int i = 0; i < E && (connection != V - 1); i++){
            Vertex v = adj.get(i);

            int a = v.from;
            int b = v.to;

            if(find(a) != find(b)){
                union(a, b);
                connection++;
                ans += v.weight;
            }
        }

        System.out.println(ans);
    }

    static class Vertex implements Comparable<Vertex>{
        int from;
        int to;
        int weight;

        public Vertex(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Vertex o){
            return this.weight - o.weight;
        }
    }

    static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY)
            parent[rootY] = rootX;
    }

    static int find(int x){
        if(x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }
}