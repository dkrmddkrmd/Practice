import java.util.*;
import java.io.*;

class Node{
    int from;
    int to;
    int weight;

    public Node(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static final int MaxVal = 1_000_000_000;
    static int N, M;
    static Node[] edges;
    static long[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Node[M];
        dist = new long[N+1];

        Arrays.fill(dist, MaxVal);
        dist[1] = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[i] = new Node(A, B, C);
        }

        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M; j++){
                Node now = edges[j];

                if(dist[now.from] != MaxVal && dist[now.from] + now.weight < dist[now.to])
                    dist[now.to] = dist[now.from] + now.weight;
            }
        }

        boolean isCycle = false;

        for(int j = 0; j < M; j++){
            Node now = edges[j];

            if(dist[now.from] != MaxVal && dist[now.from] + now.weight < dist[now.to]){
                isCycle = true;
                break;
            }
        }

        if(isCycle){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++){
            if(dist[i] == MaxVal)
                sb.append(-1).append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }
}