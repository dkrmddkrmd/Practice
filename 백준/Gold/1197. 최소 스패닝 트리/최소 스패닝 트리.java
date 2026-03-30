import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int from;
    int to;
    int weight;

    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}

public class Main {
    static int V, E;
    static PriorityQueue<Node> pq;
    static int[] parent;
    static long dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());


        parent = new int[V+1];
        pq = new PriorityQueue<>();

        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new Node(A, B, C));
        }

        int isTree = 0;
        while (!pq.isEmpty() && isTree != V - 1){
            Node now = pq.poll();

            int rootA = find(now.from);
            int rootB = find(now.to);

            if(rootA != rootB){
                union(now.from, now.to);
                dist += now.weight;
                isTree++;
            }
        }

        System.out.println(dist);
    }
    static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY)
            return;

        parent[rootY] = rootX;
    }

    static int find(int x){
        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }
}