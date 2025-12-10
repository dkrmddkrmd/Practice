import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] parent;
    static long[] dist;

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0)
                break;

            parent = new int[N+1];
            dist = new long[N+1];

            for(int i = 1; i <= N; i++){
                parent[i] = i;
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(s.equals("!")){
                    long diff = Integer.parseInt(st.nextToken());
                    union(a, b, diff);
                }
                else{
                    if(find(a) != find(b)){
                        sb.append("UNKNOWN\n");
                    }
                    else{
                        sb.append(dist[b] - dist[a]).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static void union(int x, int y, long w){
        int pX = find(x);
        int pY = find(y);

        if(pX == pY)
            return;

        dist[pY] = dist[x] + w - dist[y];
        parent[pY] = pX;
    }

    static int find(int x){
        if(x == parent[x])
            return x;

        int root = find(parent[x]);
        dist[x] += dist[parent[x]];
        return parent[x] = root;
    }
}